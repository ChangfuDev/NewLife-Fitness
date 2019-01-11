/**  
* @Title: forget.js  
* @Package resource/js/user  
* @Description: TODO
* @author 10153  
* @date 2019年1月2日  
* @version V1.0  
*/  
var baseHref = "http://"+location.host+"/rearend-web";
layui.config({
		base : baseHref+'/layuiadmin/' //静态资源所在路径
	}).extend({
		index : 'lib/index' //主入口模块
	}).use([ 'index', 'user' ], function() {
		var $ = layui.$, setter = layui.setter, admin = layui.admin, form = layui.form, router = layui.router();

		form.render();

		// 鼠标离开ajax验证是否是否存在管理员
		$("#LAY-user-login-cellphone").blur(function() {
			var validate_phone = $(this).val(); // 获取手机号值
			var isSave_phone = $("#isSave_phone").val(); // 保存状态防止恶意验证
			if (validate_phone !== isSave_phone) {
				$.post('validation', "phoneNum=" + validate_phone, function(data) { // 进行异步验证
					$("#isSave_phone").val(data.phone);
					if (data.status === "success") {
						$("#LAY-user-login-cellphone").css("border", "1.5px solid #5FB878").prev().css("color", "#FF5722");
						$("button").first().css("cursor", "").removeProp("disabled");
						form.render();
					} else {
						$("#LAY-user-login-cellphone").css("border-color", "").prev().css("color", "");
						layer.msg(data.msg, {
							time : 2000
						});
						$("button").first().css("cursor", "not-allowed").prop("disabled", true);
						form.render();
					}
				}, "json");
			}
		});

		// 更换图形验证码
		$('body').on('click', '#LAY-user-get-vercode', function() {
			var othis = $(this);
			this.src = 'getGifCode.html?time=' + new Date().getTime();
		});

		// 发送短信验证码
		admin.sendAuthCode({
			elem : '#LAY-user-getsmscode',
			elemPhone : '#LAY-user-login-cellphone',
			elemVercode : '#LAY-user-login-vercode',
			ajax : {
				url : "sendMessage", // 实际使用请改成服务端真实接口
				type: "post",
				success: function(data){
					if(data.code === 'logout'){
						$("#LAY-user-get-vercode").prop("src","getGifCode.html?time="+new Date().getTime());
						layer.alert(data.msg, {icon: 5,title: "发送状态"});
					}else{
						switch (data.msg) {
						case "OK":
							layer.msg('发送成功，请在手机查看填写验证码~');
							break;
						default:
							$("#LAY-user-get-vercode").prop("src","getGifCode.html?time="+new Date().getTime());
							layer.alert(data.msg, {icon: 5,title: "发送状态"});
							break;
						}
					}
				}
			}
		});

		//找回密码下一步
		form.on('submit(LAY-user-forget-submit)', function(obj) {
			var field = obj.field;
			$.ajax({
				url:"validation_forget",
				type:"get",
				data:field,
				dataType: "text",
				success:function(data){
					if(data==="fail"){
						$("#LAY-user-get-vercode").prop("src","getGifCode.html?time="+new Date().getTime());
						layer.alert("图形验证码失败，请重新填写！",{time:2000,anim:6,icon:5,title:"图形验证码"});
					}else if(data === "error"){
						$("#LAY-user-get-vercode").prop("src","getGifCode.html?time="+new Date().getTime());
						layer.alert("短信验证码失败，请重新填写！",{time:2000,anim:6,icon:2,title:"短信验证码"});
					}else{
						location.hash = '/type=resetpass';
				        location.reload();
					}
				}
			});
			//请求接口
			return false;
		});

		//重置密码
	   form.on('submit(LAY-user-forget-resetpass)', function(obj) {
			var field = obj.field;

			//确认密码
			if (field.password !== field.repass) {
				return layer.msg('两次密码输入不一致');
			}

			//请求接口
			$.ajax({
				url :'resetpassword', //实际使用请改成服务端真实接口
				data : field,
				type :"post",
				dataType:"text",
				success : function(data) {
					if(data === "success"){
						layer.msg('密码已成功重置', {
	                        offset : '15px',
	                        icon : 1,
	                        time : 1000
	                    }, function() {
	                        location.href = baseHref; //跳转到登入页
	                    });
					}else{
						layer.msg('密码重置失败，系统异常！', {
                            offset : '15px',
                            icon : 1,
                            time : 1000
                        }, function() {
                            location.href = baseHref; //跳转到登入页
                        });
					}
				}
			});
			return false;
		});
});