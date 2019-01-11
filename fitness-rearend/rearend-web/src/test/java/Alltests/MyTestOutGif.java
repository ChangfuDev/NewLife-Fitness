package Alltests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.newlife.fitness.entity.Announce;
import com.newlife.fitness.entity.DUser;
import com.newlife.fitness.entity.FUser;
import com.newlife.fitness.rearend.biz.AnnounceBiz;
import com.newlife.fitness.rearend.biz.DUserBiz;
import com.newlife.fitness.rearend.biz.FUserBiz;
import com.newlife.fitness.rearend.web.utils.captchatool.GifCaptcha;
import com.newlife.fitness.rearend.web.utils.captchatool.parent.Captcha;
import com.newlife.fitness.rearend.web.utils.md5tool.MD5Util;

public class MyTestOutGif {
	static ApplicationContext ctx = null;
	static {
		String[] resource = { "spring-dao.xml", "spring-biz.xml" };
		ctx = new ClassPathXmlApplicationContext(resource);
	}
	
	DUserBiz DUserBean = ctx.getBean(DUserBiz.class);
	FUserBiz FUserBean = ctx.getBean(FUserBiz.class);
	AnnounceBiz Anounce = ctx.getBean(AnnounceBiz.class);

	/**
	 * 测试Gif图
	 */
	@Test
	public void testOutgif() {
		Captcha captcha = new GifCaptcha(130, 80, 5);
		try {
			captcha.out(new FileOutputStream("e:/1.gif"));
			System.out.println(captcha.text());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入后台用户数据测试
	 * 
	 * @throws Exception
	 */
	@Test
	public void test_insert() throws Exception {
//		int result = bean.addDUser(new DUser(null,"1015392100@qq.com",null,"unruly",MD5Util.md5Pass5("123456"),"17673846003","男","李诺轩"));
//		System.out.println("===========:"+result);
		int result = DUserBean.addDUser(new DUser(null, "7838339333@qq.com", null, "object", MD5Util.md5Pass5("123456"),
				"18343535323", "女", "依然"));
		System.out.println("===========:" + result);
		int result1 = DUserBean.addDUser(new DUser(null, "1839292927@qq.com", null, "linux", MD5Util.md5Pass5("123456"),
				"17673646023", "男", "吴增平"));
		System.out.println("===========:" + result1);
		int result2 = DUserBean.addDUser(new DUser(null, "1992299923@qq.com", null, "bean", MD5Util.md5Pass5("123456"),
				"15673838903", "女", "刘亦菲"));
		System.out.println("===========:" + result2);
	}

	/**
	 * 插入前台用户测试数据
	 * @throws Exception 
	 * f_userName,(f_loginName（统一）admin),(f_password（统一）md5(123456)),（f_sex（随机）男-女），
	 * （f_age（随机）16-60），（f_isVip（随机）是-否）），（f_imgUrl（null）），
	 * （f_vipBegiTtime（2018-12-02 18:37:56）|| null），（'f_vipEndTime'（now）|| null）
	 */
	@Test
	public void test_fUserInsert() throws Exception {
		// 创建文件
		List<String> content = FileUtils.readLines(new File("e:/fuser10.txt"),"UTF-8");
		List<String[]> contentList = new ArrayList<>(16);
		// 将每行的内容通过“，”分隔返回一个String数组
		for (String str : content) {
			String [] split = str.split(",");
			// System.out.println(Arrays.toString(split));
			contentList.add(split);
		}
		// 将User赋值,准备插入数据
		SimpleDateFormat r = new SimpleDateFormat("yyyy-MM-dd");
		int i = 1;
		for (String[] str : contentList) {
			FUser user = new FUser();
			// 用户名、手机号、邮箱号、地址信息 通过读取文件获取
			user.setId(null);
			user.setfUserName(str[0]);
			user.setfPhone(str[1]);
			user.setfEmail(str[2]);
			user.setfAddress(str[3]);
			// 登录账号使用随机生成；
			// 密码固定加密，性别，年龄，是否为vip随机
			user.setfLoginName(RandomStringUtils.random(7, true, true).toLowerCase());
			user.setfPassword(MD5Util.md5Pass5("123456"));
			user.setfSex(RandomStringUtils.random(1,'男','女'));
			user.setfAge(RandomUtils.nextInt(16, 60));
			user.setfIsVip(RandomStringUtils.random(1,'是','否'));
			if(user.getfIsVip().equals("是")) {
				user.setfVipBegiTtime(r.parse("2017-8-16"));
				user.setfVipEndTime(r.parse("2018-8-16"));
			}else {
				user.setfVipBegiTtime(null);
				user.setfVipEndTime(null);
			}
			user.setfImgUrl(null);
			System.out.println("第"+i+"次 =======>"+FUserBean.addFUser(user));
			i++;
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void test_random() throws Exception {
		for (int i = 0; i < 100 ; i++) {
			System.out.println(RandomUtils.nextInt(16, 60));
			System.out.println(RandomStringUtils.random(1,'男','女'));
		}
		SimpleDateFormat r = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(r.parse("2017-8-16"));
	}

	@Test
	public void test_update() throws Exception {
		DUser user = new DUser();
		user.setdPassWord(MD5Util.md5Pass5("a123456"));
		user.setId(5);
		System.out.println("==============>" + DUserBean.modifyDUser(user));
	}
	
	@Test
	public void test_announce() throws Exception {
		/*List<Announce> findAllInfo = Anounce.findAllInfo();
		System.out.println(findAllInfo);*/
		Announce anounce = new Announce();
		anounce.setCreateDate(new Date());
		anounce.setCodeContent("通知");
		anounce.setContent("通知");
		anounce.setdUser(new DUser(1,null));
		System.out.println("=========>"+Anounce.addOneInfo(anounce));
	}
}
