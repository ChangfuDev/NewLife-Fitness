package com.newlife.fitness.rearend.web.controller.dusermanage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.rearend.biz.DUserBiz;
import com.newlife.fitness.rearend.web.utils.md5tool.MD5Util;

@Controller
@RequestMapping("/manage")
public class DUserController {

	@Autowired
	private DUserBiz duserService;

	// 查询用户
	@RequestMapping("/findDUser")
	@ResponseBody
	public Object findFUser(
			@RequestParam(value="dUserName",required = false) String dUserName,
			@RequestParam(value="userRole",required = false) String userRole,
			@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		int count = duserService.getCount(dUserName,userRole);
		List<DUser> dusers = duserService.getDUsers(dUserName,userRole,page,limit);
		// 获取数据总条数
		Map<String, Object> msg = new HashMap<String, Object>();
		msg.put("code", 0);
		msg.put("msg", "");
		msg.put("count", count);
		msg.put("data", dusers);
		return msg;

	}

	// rest风格新增一个用户
	@RequestMapping(value = "/duser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addFUser(DUser user) {
		System.out.println(user);
		//获取加密后的密码
		String pass5 = MD5Util.md5Pass5(user.getdPassWord());
		//重新设置加密后的密码
		user.setdPassWord(pass5);
		Map<String, Object> msg = new HashMap<String, Object>();
		// 保存用户
		int flag = 0;
		try {
			flag = duserService.addDUser(user);
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
	@RequestMapping(value = "/duser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public DUser getUser(@PathVariable("id") int id) {
		// 获取用户
		DUser user = null;
		user = duserService.getFUser(id);
		return user;
	}

	// 执行更新方法前获取要更新的对象
	@ModelAttribute
	public void userMode(@PathVariable(value = "id", required = false) Integer id, Map<String, Object> map) {
		if (id != null) {
			DUser DUuser = duserService.getFUser(id);
			map.put("duser", DUuser);
		}
	}

	// rest风格更新用户
	@RequestMapping(value = "/duser/{id}", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, Object> updateUser(@ModelAttribute("duser") DUser user) {
		System.out.println(user);
		Map<String, Object> msg = new HashMap<String, Object>();
		System.out.println("==="+user);
		boolean flag = false;
		try {
			flag = duserService.modifyDUser(user);
			if (flag) {
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
	@RequestMapping(value = "/duser/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Map<String, Object> delUser(@PathVariable("id") Integer id) {
		int flag = 0;
		Map<String, Object> msg = new HashMap<String, Object>();
		flag = duserService.delDUser(id);
		try {
			
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
	

}
