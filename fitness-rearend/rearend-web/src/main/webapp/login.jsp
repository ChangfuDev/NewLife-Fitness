<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NewLife后台管理系统</title>
<meta name=""/>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/login.css" media="all">
</head>
<body>
	<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

		<div class="layadmin-user-login-main">
			<div id="myHeader" class="layadmin-user-login-box layadmin-user-login-header">
				<h2>NewLife健身后台</h2>
				<p>后台登录页面</p>
			</div>

			<form id="myForm" class="layadmin-user-login-box layadmin-user-login-body layui-form" method="post">
				<div class="layui-form-item">
					<label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label> <input type="text" name="username"
						id="LAY-user-login-username" lay-verify="required" placeholder="用户名" class="layui-input">
				</div>

				<div class="layui-form-item">
					<label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label> <input type="password"
						name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码" class="layui-input">
				</div>

				<div class="layui-form-item">
					<div class="layui-row">
						<div class="layui-col-xs7">
							<label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label> <input type="text" name="vercode"
								autocomplete="off" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
						</div>
						<div class="layui-col-xs5">
							<div style="margin-left: 10px;">
								<img src="getGifCode.html" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
							</div>
						</div>
					</div>
				</div>

				<div class="layui-form-item" style="margin-bottom: 20px;" id="keepPassdiv">
					<input type="checkbox" name="keep_pass" id="keep_pass" lay-filter="keepPass" title="记住密码" lay-skin="primary" /> <a href="forget.html"
						class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码</a>
				</div>

				<div class="layui-form-item">
					<button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
				</div>
				<hr class="layui-bg-gray">
				<div class="layui-trans layui-form-item layadmin-user-login-other">
					<label>其他登录方式</label> <a href="javascript:;"><i class="layui-icon layui-icon-cellphone"></i></a> <a href="javascript:;"><i
						class="layui-icon layui-icon-login-qq"></i></a> <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
				</div>

			</form>
			<div class="layui-trans layadmin-user-login-footer">
				<p class="layui-word-aux">© 2018 NewLife Fitness</p>
				<p class="layui-word-aux">版权所有</p>
			</div>
		</div>


		<div class="ladmin-user-login-theme">
			<script type="text/html" template>
        <ul class="layui-anim layui-anim-up">
          <li data-theme=""><img src="{{ layui.setter.base }}style/res/bg-none.jpg"></li>
          <li data-theme="layuiadmin/style/res/311900.jpg"><img src="{{ layui.setter.base }}style/res/311900.jpg" width="64" height="43"></li>
          <li data-theme="#03152A" style="background-color: #03152A;"></li>
          <li data-theme="#2E241B" style="background-color: #2E241B;"></li>
          <li data-theme="#50314F" style="background-color: #50314F;"></li>
          <li data-theme="#344058" style="background-color: #344058;"></li>
          <li data-theme="#20222A" style="background-color: #20222A;"></li>
        </ul>
        </script>
		</div>
	</div>

	<script src="${pageContext.request.contextPath}/layuiadmin/layui/layui.js"></script>
	<script src="${pageContext.request.contextPath}/resource/js/user/login_unruly.js"></script>
</body>
</html>