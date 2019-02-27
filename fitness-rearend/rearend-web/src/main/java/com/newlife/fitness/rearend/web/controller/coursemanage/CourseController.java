package com.newlife.fitness.rearend.web.controller.coursemanage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlife.fitness.entity.Course;
import com.newlife.fitness.entity.CourseVideo;
import com.newlife.fitness.rearend.biz.CourseService;
import com.newlife.fitness.rearend.biz.CourseVideoService;
import com.newlife.fitness.rearend.web.utils.WorkUtils;

@Controller
@RequestMapping("/manage")
public class CourseController {

	// 课程id
	private static int courseId;

	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;

	@Autowired
	@Qualifier("courseVideoService")
	private CourseVideoService courseVideoService;

	/**
	 * 获取所有课程
	 * 
	 * @return
	 */
	@RequestMapping("/getcourses")
	@ResponseBody
	public Object getCourseList(@RequestParam(value = "cName", required = false) String cname,
			@RequestParam(value = "cIsvip", required = false) String cIsvip, @RequestParam("page") Integer page,
			@RequestParam("limit") Integer limit) {
		// 获取总数
		int count = courseService.getCourseCount(cname, cIsvip);
		List<Course> courses = courseService.getCourses(cname, cIsvip, page, limit);
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", count);
		msg.put("data", courses);
		return msg;
	}

	/**
	 * 获取课程的详细视频
	 * 
	 * @param cid
	 * @return
	 */
	@RequestMapping("/getcoursevideos")
	@ResponseBody
	public Object getCourseVideo(@RequestParam("cid") Integer cid,@RequestParam("page") Integer page,@RequestParam("limit") Integer limit) {
		Map<String, Object> msg = new HashMap<String, Object>();
		int count = courseVideoService.getCourseVideoCountByCourseId(cid);
		List<CourseVideo> courseVideos = courseVideoService.getCourseVideoByCourseId(cid,page,limit);
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", count);
		msg.put("data", courseVideos);
		return msg;
	}

	@RequestMapping(value = "/course", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addFUser(Course course) {
		Map<String, Object> msg = new HashMap<String, Object>();
		int flag = 0;
		// 保存课程
		try {
			flag = courseService.saveCourse(course);
			courseId = course.getId();
			if (flag > 0) {
				msg.put("msg", "添加成功");
			} else {
				msg.put("msg", "添加失败");
			}
		} catch (Exception ex) {
			msg.put("msg", "添加失败");
		}
		return msg;
	}

	/**
	 * 获取单个课程
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/course/{id}",method=RequestMethod.GET)
	@ResponseBody
	public Course getCourse(@PathVariable("id") Integer id) {
		return courseService.getCourse(id);
	}

	/**
	 * 上传视频
	 * 
	 * @throws IOException
	 */
	@RequestMapping(value = "/uploadvideo")
	@ResponseBody
	public Object uploadVideo(@RequestParam(value="cid",required=false) Integer cid, @RequestParam("file") MultipartFile multipartFile) {
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		// 获取文件名称
		String originalFilename = multipartFile.getOriginalFilename();
		// 创建文件
		File file = new File("D:\\文件上传测试\\" + originalFilename);
		//
		if (!file.exists()) {
			file.mkdirs();
		}
		//创建课程视频对象且封装属性
		CourseVideo courseVideo = new CourseVideo();
		courseVideo.setTitle(originalFilename);
		courseVideo.setVideoUrl(file.getPath());
		if(cid!=null) {
			courseVideo.setCourseId(cid);			
		}else {
			courseVideo.setCourseId(courseId);
		}
		try {
			//保存文件
			flag = courseVideoService.saveCourseVideo(courseVideo);
			if (flag > 0) {
				// 将文件移动到d盘
				multipartFile.transferTo(file);
				msg.put("code", 0);
			} else {
				msg.put("code", -1);
			}
		} catch (IllegalStateException e) {
			msg.put("code", -1);
			e.printStackTrace();
		} catch (IOException e) {
			msg.put("code", -1);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return msg;
	}

	
	/**
	 *   删除课程 
	 * @return
	 */
	@RequestMapping(value="/course/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> delCourse(@PathVariable("id") Integer id){
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			flag = courseService.delCourse(id);
			if(flag>0) {
				msg.put("msg", "删除成功");
			}else {
				msg.put("msg", "未知原因");
			}
		}catch (Exception e) {
			msg.put("msg", "出现异常");
		}
		return msg;
	}
	
	/**
	 * 删除课程视频
	 * @return
	 */
	@RequestMapping("/course/courseVideo/{id}")
	@ResponseBody
	public Map<String,Object> delCourseVideo(@PathVariable("id") Integer id){
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			flag = courseVideoService.delCourseVideo(id);
			if(flag>0) {
				msg.put("msg", "删除成功");
			}else {
				msg.put("msg", "未知原因");
			}
		}catch (Exception e) {
			msg.put("msg", "出现异常");
		}
		return msg;
	}
	
	/**
	 * 表格导入
	 * @return
	 */
	@RequestMapping("/importCourse")
	@ResponseBody
	public Map<String,Object> importCourse(@RequestParam("file") MultipartFile multipartFile){
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			InputStream inputStream = multipartFile.getInputStream();
			System.out.println(multipartFile.getOriginalFilename());
			List<Course> importCourses = WorkUtils.importCourse(inputStream);
			int flag = courseService.importCourse(importCourses);
			if (flag > 0) {
				msg.put("code", 0);
				msg.put("msg", "导入成功");
			} else {
				msg.put("code", -1);
				msg.put("msg", "导入失败:插入数据时出现异常");
			}
		} catch (IOException e) {
			msg.put("code", -1);
			msg.put("msg", "导入失败:导入文件时出现异常");
			e.printStackTrace();
		}
		
		return msg;
	}
	
}
