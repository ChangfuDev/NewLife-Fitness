package com.newlife.fitness.rearend.web.controller.trainmanage;

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

import com.newlife.fitness.entity.Train;
import com.newlife.fitness.rearend.biz.TrainService;
import com.newlife.fitness.rearend.web.utils.WorkUtils;

@Controller
@RequestMapping("/manage")
public class TrainController {
	@Autowired
	@Qualifier("trainService")
	public TrainService trainService;

	// 查询用户
	@RequestMapping("/findtrain")
	@ResponseBody
	public Object findTrain(@RequestParam(value = "tUserName", required = false) String tUserName,
			@RequestParam(value = "tSex", required = false) String tSex,
			@RequestParam(value = "tIsvip", required = false) String tIsvip,
			@RequestParam(value = "tAge", required = false) Integer tAge,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		// 获取数据总条数
		int count = trainService.getTraiCount(tUserName, tSex, tAge, tIsvip);
		// 获取数据
		List<Train> trains = trainService.getTrainByUserNameOrSexOrAgeOrIsVip(tUserName, tSex, tAge, tIsvip, page,
				limit);
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", count);
		msg.put("data", trains);
		return msg;
	}

	// rest风格新增一个用户
	@RequestMapping(value = "/train", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addFUser(Train train) {
		Map<String, Object> msg = new HashMap<String, Object>();
		// 保存用户
		int flag = 0;
		train.settIsvip("否");
		try {
			flag = trainService.saveTrain(train);
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
	@RequestMapping(value = "/train/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Train getTrain(@PathVariable("id") int id) {
		// 获取用户
		return trainService.getTrainById(id);
	}

	// 执行更新方法前获取要更新的对象
	@ModelAttribute
	public void trainMdoel(@PathVariable(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			Train train = trainService.getTrainById(id);
			map.put("train", train);
		}
	}

	// rest风格更新用户
	@RequestMapping(value = "/train/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateTrain(@ModelAttribute("train") Train train) {
		Map<String, Object> msg = new HashMap<String, Object>();
		int flag = 0;
		flag = trainService.modifTrain(train);
		try {

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

	@RequestMapping(value = "/train/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delUser(@PathVariable("id") int id) {
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			flag = trainService.delTrain(id);
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
	 * @throws IOException 
	 */
	@RequestMapping("/importTrain")
	@ResponseBody
	public Map<String,Object> importTrain(@RequestParam("file") MultipartFile multipartFile) throws IOException{
		Map<String, Object> msg = new HashMap<String, Object>();
		try {
			InputStream inputStream = multipartFile.getInputStream();
			System.out.println(multipartFile.getOriginalFilename());
			List<Train> importCourses = WorkUtils.importTrain(inputStream);
			int flag = trainService.importTrain(importCourses);
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
