package com.newlife.fitness.rearend.web.controller.fusermanage;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlife.fitness.entity.FUser;
import com.newlife.fitness.rearend.biz.FUserService;
import com.newlife.fitness.rearend.web.utils.WorkUtils;

@Controller
@RequestMapping("/manage")
public class FUserController {

	@Autowired
	@Qualifier("fuserService")
	private FUserService fuserService;

	// 查询用户
	@RequestMapping("/finduser")
	@ResponseBody
	public Object findFUser(@RequestParam(value = "fUserName", required = false) String fUserName,
			@RequestParam(value = "fSex", required = false) String fSex,
			@RequestParam(value = "fIsvip", required = false) String fIsvip,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {

		// 获取数据总条数
		int count = fuserService.getCountByUserNameOrSex(fUserName, fSex, fIsvip);
		// 获取数据
		List<FUser> fusers = fuserService.getFUserByUserNameOrSex(fUserName, fSex, fIsvip, page, limit);
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", count);
		msg.put("data", fusers);
		return msg;

	}

	// rest风格新增一个用户
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addFUser(FUser user) {
		System.out.println(user);
		Map<String, Object> msg = new HashMap<String, Object>();
		// 保存用户
		int flag = 0;
		try {
			flag = fuserService.saveFUser(user);
			if (flag > 0) {
				msg.put("msg", "添加成功");
			} else {
				msg.put("msg", "添加失败:未知原因");
			}
		} catch (Exception ex) {
			msg.put("msg", "添加失败:" + ex.getMessage());
		}
		return msg;
	}

	// rest风格获取一个用户
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	@ResponseBody
	public FUser getUser(@PathVariable("id") int id) {
		// 获取用户
		FUser user = null;
		user = fuserService.getFUser(id);
		return user;
	}

	// 执行更新方法前获取要更新的对象
	@ModelAttribute
	public void userMode(@PathVariable(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			FUser fUser = fuserService.getFUser(id);
			map.put("fuser", fUser);
		}
	}

	// rest风格更新用户
	@RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateUser(@ModelAttribute("fuser") FUser user) {
		System.out.println(user);
		Map<String, Object> msg = new HashMap<String, Object>();
		System.out.println("==="+user);
		int flag = 0;
		try {
			flag = fuserService.modifyUser(user);
			if (flag > 0) {
				msg.put("msg", "修改成功");
			} else {
				msg.put("msg", "修改失败:未知原因");
			}
		} catch (Exception ex) {
			msg.put("msg", "修改失败:" + ex.getMessage());
		}
		return msg;
	}

	// rest风格刪除用户
	@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delUser(@PathVariable("id") int id) {
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			flag = fuserService.delUser(id);
			if (flag > 0) {
				msg.put("msg", "删除成功");
			} else {
				msg.put("msg", "删除失败:未知原因");
			}
		} catch (Exception ex) {
			msg.put("msg", "删除失败:" + ex.getMessage());
		}
		return msg;
	}
	
	/**
	 * 表格导入
	 * @return
	 */
	@RequestMapping("/importUser")
	@ResponseBody
	public Map<String,Object> importCourse(@RequestParam("file") MultipartFile multipartFile){
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			InputStream inputStream = multipartFile.getInputStream();
			System.out.println(multipartFile.getOriginalFilename());
			List<FUser> importCourses = WorkUtils.importFUser(inputStream);
			int flag = fuserService.importUser(importCourses);
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
