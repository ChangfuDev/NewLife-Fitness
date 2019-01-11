package com.newlife.fitness.rearend.web.controller.setcontroller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.entity.Website;
import com.newlife.fitness.rearend.biz.DUserBiz;
import com.newlife.fitness.rearend.biz.WebSiteBiz;
import com.newlife.fitness.rearend.web.utils.GlobalConstant;
import com.newlife.fitness.rearend.web.utils.ServletTool;
import com.newlife.fitness.rearend.web.utils.cookietool.EditCookie;
import com.newlife.fitness.rearend.web.utils.md5tool.MD5Util;
import com.newlife.fitness.rearend.web.utils.sendsms.SendSMSTool;

/**
 * @ClassName: SetController
 * @Description: 用于设置操作的Controller，个人资料设置，密码设置，网站设置。
 * @author Unruly
 * @date 2019年1月6日
 */
@Controller
@RequestMapping("/fitness-admin/set/")
public class SetUserController {
	@Resource
	private DUserBiz dUserBiz;
	@Resource
	private WebSiteBiz websiteBiz;

	// ------------------------------------------ 设置真实视图
	/** 表示系统设置的真实视图 */
	private final String page_website = "fitness-sys/set/website";
	/** 个人资料设置的真实视图 */
	private final String page_info = "fitness-sys/set/info";
	/** 个人密码设置的真实视图 */
	private final String page_password = "fitness-sys/set/password";
	// ------------------------------------------ 设置真实视图

	// ------------------------------------------ 设置逻辑视图
	@RequestMapping("info.html")
	public String goInfo() {
		return page_info;
	}

	@RequestMapping("password.html")
	public String goPassword() {
		return page_password;
	}

	@RequestMapping("website.html")
	public String goWebsite(Model model) {
		Website website = websiteBiz.findWebsiteInfo();
		model.addAttribute("website",website);
		return page_website;
	}
	// ------------------------------------------ 设置逻辑视图

	// ------------------------------------------ 业务处理的方法
	/**
	 * 修改密码的方法 ajax，成功后清除Session、清除Cookie进行跳转。
	 * 
	 * @param oldPassword 旧密码
	 * @param password    新密码
	 * @param repassword  重复新密码
	 * @return 请求状态
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("setPassword.do")
	public String setPassword(@RequestParam String oldPassword, @RequestParam String password,
			@RequestParam String repassword) throws Exception {
		DUser user = (DUser) ServletTool.getSession().getAttribute(GlobalConstant.login_user);
		String status = GlobalConstant.error;
		int passLength = StringUtils.deleteWhitespace(password).length();
//		1.原密码验证
		if (!StringUtils.isBlank(oldPassword) && MD5Util.md5Pass5(oldPassword).equals(user.getdPassWord())) {
//			2.长度验证、密码相同验证
			if (passLength >= 6 || passLength <= 16 && StringUtils.deleteWhitespace(password).equals(repassword)) {
				DUser dUser = new DUser(user.getId(), MD5Util.md5Pass5(password), null);
				if (dUserBiz.modifyDUser(dUser)) {
					SendSMSTool.SendMessageAsAdvisor(user.getdPhone());
					EditCookie.del_Cookie(user.getdLoginName(), ServletTool.getRequest(), ServletTool.getResponse());
					ServletTool.getSession().removeAttribute(GlobalConstant.login_user);
					ServletTool.getSession().invalidate();
					status = GlobalConstant.success;
				}
			} else {
				status = GlobalConstant.fail;
			}
		}
		return status;
	}

	/**
	 * 用户头像文件上传设置 响应格式：{ "code": 0 ,"msg": "" ,"data": {
	 * "src":"http://cdn.layui.com/123.jpg" } }
	 * 因为每次部署项目都会清空，因此配置了Service.xml虚拟路径。
	 * 文件上传到webapps/imgUpload/下面 为实际地址；
	 * 实际访问为webapps/rearend-web/fileUpload；
	 * 容易搞混淆的就是，文件实际上传的路径（实际上传），和用户需要访问的路径（返回给页面，储存到数据库）。
	 * server.xml文件
	 * <Context docBase="F:\Tomcat8\wtpwebapps\imgUpload" path="/fileUpload" reloadable="true"/>
	 * docBase表示资源真实路径，path表示访问路径：localhost：8080/fileUpload；
	 * @param file 上传的文件
	 * @return Json
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping(value = "uploadUserImg.do", method=RequestMethod.POST)
	public Object uploadUserImg(@RequestParam MultipartFile file) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		HttpServletRequest req = ServletTool.getRequest();
		HttpSession session = req.getSession();
		map.put("code", 1);
		map.put("msg","文件上传失败，文件格式或者大小不合规。请重新上传！");
		map.put("data",null);
		// 创建文件上传路径，通过会话所在的服务器的真实路径；
		String servletPath = session.getServletContext().getRealPath("");
		// 截取webapp根路径将文件访问在，上传到服务器资源的实际位置webapps/imgUpload/
		String path = servletPath.substring(0, servletPath.indexOf("rearend-web"))+"imgUpload";
		if (!file.isEmpty()) {
			String suffix = FilenameUtils.getExtension(file.getOriginalFilename());
			// 简单的判断文件的大小和后缀
			if (!(file.getSize() > 1024*1024*2) && suffix.equals("jpg") || suffix.equals("png")|| suffix.equals("gif")) {
					// 将文件重新命名进行唯一标识 - 上传服务器
					String fileName = UUID.randomUUID().toString().replaceAll("-", "")+"."+suffix;
					File newfile = new File(path, fileName);
					if (!newfile.exists()) {
						newfile.mkdirs();
					}
					// 相当IO输出文件，只不过直接封装了。
					file.transferTo(newfile);
					// 设置用户访问的路径为项目根路径下的fileUpload
					// 端口：http://localhost:8080
					String webIp = req.getScheme()+":"+File.separator+File.separator+req.getServerName()+":"+req.getServerPort();
					// 实际访问：http://localhost:8080/fileUpload/文件名
					String userUsePath = webIp+File.separator+"fileUpload"+File.separator+fileName;
					// 进行DB保存文件路径；
					DUser dUser = (DUser)session.getAttribute(GlobalConstant.login_user);
					dUser.setdImgUrl(userUsePath);
					if(dUserBiz.modifyDUser(dUser)) {
						map.put("code", 0);
						map.put("msg","文件上传成功，请点击查看~");
						map.put("data",userUsePath);
						session.setAttribute(GlobalConstant.login_user,dUser);
					}
			}
		}
		return map;
	}
	
	/**
	 * 修改用户信息 
	 * @param dUser
	 * @return 返回修改状态
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "setInfo.do",method=RequestMethod.POST)
	public String updateDUser(DUser dUser) throws Exception {
		HttpSession session = ServletTool.getSession();
		DUser session_dUser = (DUser) session.getAttribute(GlobalConstant.login_user);
		session_dUser.setdUserName(dUser.getdUserName());
		session_dUser.setdSex(dUser.getdSex());
		session_dUser.setdMark(dUser.getdMark());
		session_dUser.setdPhone(dUser.getdPhone());
		session_dUser.setdEmail(dUser.getdEmail());
		if(dUserBiz.modifyDUser(session_dUser)) {;
			session.setAttribute(GlobalConstant.login_user, session_dUser);
			return GlobalConstant.success;
		}
		return GlobalConstant.error;
	}
	
	/**
	 * 修改网站信息 
	 * @param dUser
	 * @return 返回修改状态
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "setWebsite.do",method=RequestMethod.POST)
	public String updateWebsite(Website website) throws Exception {
		if(websiteBiz.updateWebsiteInfo(website)) {
			return GlobalConstant.success;	
		}
		return GlobalConstant.error;
	}
	

	// ------------------------------------------ 业务处理的方法 End
}
