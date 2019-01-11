/**
 * @Title: login_unruly.js
 * @Package resource/js/user
 * @Description: TODO
 * @author 10153
 * @date 2018年12月28日
 * @version V1.0
 */
/*
 * Layui底层主要： 1.config({})表示配置一些全局的参数 2.extend({})表示继承的主要模块 3.use({}) 表示使用的模块，比如，此页面使用了index、user模块
 * 
 * Layui表单： 具体看文档 form.render()；表示渲染，每次ajax请求，需要主动渲染，否则页面无效果。
 */

var baseHref = "http://"+location.host+"/rearend-web";
layui.config({
	base : baseHref+'/layuiadmin/' // 静态资源所在路径
}).extend({
	index : 'lib/index' // 主入口模块
}).use([ 'index', 'user' ], function() {
	var $ = layui.$, setter = layui.setter, admin = layui.admin, form = layui.form, router = layui.router(), search = router.search;

	form.render();
	// 防止退出登录后网页还能回退的JS代码
	if (window.history && window.history.pushState) {
		$(window).on('popstate',function(){
			window.history.pushState('forward',null,'#');
			window.history.forward(1);
			self.location="login.html"; //如查需要跳转页面就用它
		});
		window.history.pushState('forward',null,'#');
		window.history.forward(1);
	}
	
	form.on('checkbox(keepPass)', function(data){
		
		layer.tips('请勿在公共场合记住密码，下次不勾选将会自动取消记住密码。', data.othis, {
			  tips: [4, '#FF5722']
		});
	});     
	
	// 更换图形验证码
	$('body').on('click', '#LAY-user-get-vercode', function() {
		var othis = $(this);
		this.src = 'getGifCode.html?time=' + new Date().getTime();
	});

	// 点击更换主题的方法
	$("ul>li").each(function() {
		$(this).on("click", function() {
			var data = $(this).data("theme");
			if (data.length > 10) {
				$("#myForm").fadeOut(1000);
				$("#myHeader").fadeOut(1000);
				$("body").css({
					'background' : "url('" + data + "') no-repeat fixed",
					'background-size' : 'cover'
				}).fadeOut(10).fadeIn(1500, function() {
					$("#myHeader").css({
						'background-color' : 'white',
						'border-radius' : '8px 8px 8px 8px',
						'box-shadow' : '0px 3px rgba(210, 210, 210, 0.7)'
					}).fadeIn(700);
					$("#myForm").css({
						'background-color' : 'white',
						'border-radius' : '8px 8px 8px 8px',
						'box-shadow' : '0px 3px rgba(210, 210, 210, 0.7)',
						'margin-top' : '5px'
					}).fadeIn(700);
				});
			} else {
				if (data != "") {
					$("body").css('background-image', "");
					$("#myForm").fadeOut(1000);
					$("#myHeader").fadeOut(1000);
					$("body").css('background-color', data).fadeOut(10).fadeIn(1000, function() {
						$("#myHeader").css({
							'background-color' : 'white',
							'border-radius' : '6px 6px 0px 0px',
							'box-shadow' : '-7px 7px rgba(210, 210, 210, 0.8)'
						}).fadeIn(700);
						$("#myForm").css({
							'background-color' : 'white',
							'border-radius' : '0px 0px 6px 6px',
							'box-shadow' : '-7px 7px rgba(210, 210, 210, 0.8)',
							'margin-top' : '0px'
						}).fadeIn(700);
					});
				} else {
					$("body").css('background-image', "");
					$("#myForm").fadeOut(1000);
					$("#myHeader").fadeOut(1000);
					$("body").css('background-color', data).fadeOut(10).fadeIn(1000, function() {
						$("#myHeader").css({
							'background-color' : data,
							'border-radius' : '',
							'box-shadow' : ''
						}).fadeIn(1000);
						$("#myForm").css({
							'background-color' : data,
							'border-radius' : '',
							'box-shadow' : ''
						}).fadeIn(1000);
					});
				}
			}
		});
	});

	// 进行ajax请求，看看是否有进行记住密码。
	$.ajax({
		url : 'getCookie',
		data : '',
		type : 'post',
		dataType : 'json',
		success : function(data) {
			if (data.msg == "success") {
				$("#keep_pass").prop("checked", true);
				$("#LAY-user-login-username").val(data.username);
				$("#LAY-user-login-password").val(data.password);
				form.render(); // 表单全部渲染
			} else {
				$("#keep_pass").removeAttr("checked");
				form.render(); // 表单全部渲染
			}
		}
	});

	// 提交登录
	form.on('submit(LAY-user-login-submit)', function(obj) {
		$.ajax({
			url : 'dologin', // 服务端接口；
			data : obj.field, // 请求的参数；
			type : "post", // 请求的方式；
			success : function(res) {
				if (res === "success") {
					layer.msg('登录成功 ~ 欢迎回来', { // 登入成功的提示与跳转
						offset : '15px',
						icon : 1,
						time : 1000,
						anim : 2
					}, function() {
						location.href = 'fitness-admin/index.html'; // 后台主页
					});
				} else if (res === "fail") {
					$("#LAY-user-get-vercode").attr('src', 'getGifCode.html?time=' + new Date().getTime());
					layer.msg('请填写正确的验证码~', {
						icon : 0,
						anim : 6,
						time : 800
					});
				} else if (res === "error") {
					$("#LAY-user-get-vercode").attr('src', 'getGifCode.html?time=' + new Date().getTime());
					layer.msg('账号或者密码不正确，请重新输入', {
						icon : 5,
						anim : 6,
						time : 800
					});
				};
				
			},
			dataType : "text"
		}); // -- ajax end
		return false;
	}); // -- form end
});