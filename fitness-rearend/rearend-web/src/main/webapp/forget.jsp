<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>忘记密码 - layuiAdmin</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/layuiadmin/style/admin.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/layuiadmin/style/login.css" media="all">
</head>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
	<div class="layadmin-user-login-main">
		<div class="layadmin-user-login-box layadmin-user-login-header">
			<h2>身份验证</h2>
			<p>请根据提示进行</p>
		</div>
		<div class="layadmin-user-login-box layadmin-user-login-body layui-form">

			<script type="text/html" template>
          {{# if(layui.router().search.type === 'resetpass'){ }}
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
              <input type="password" name="password" id="LAY-user-login-password" lay-verify="pass" placeholder="新密码" class="layui-input">
            </div>
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-repass"></label>
              <input type="password" name="repass" id="LAY-user-login-repass" lay-verify="required" placeholder="确认密码" class="layui-input">
            </div>
            <div class="layui-form-item">
              <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-forget-resetpass">重置新密码</button>
            </div>
          {{# } else { }}
            <div class="layui-form-item">
              <label class="layadmin-user-login-icon layui-icon layui-icon-cellphone" for="LAY-user-login-cellphone"></label>
              <input type="text" name="cellphone" id="LAY-user-login-cellphone" lay-verify="phone" placeholder="请输入注册时的手机号" class="layui-input">
            </div>
            <div class="layui-form-item">
              <div class="layui-row">
                <div class="layui-col-xs7">
                  <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
                  <input type="text" name="imgVercode" autocomplete="off" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码" class="layui-input">
                </div>
                <div class="layui-col-xs5">
                  <div style="margin-left: 10px;">
                    <img src="getGifCode.html" class="layadmin-user-login-codeimg" id="LAY-user-get-vercode">
                  </div>
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <div class="layui-row">
                <div class="layui-col-xs7">
                  <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-smscode"></label>
                  <input type="text" name="vercode" autocomplete="off" id="LAY-user-login-smscode" lay-verify="required" placeholder="短信验证码" class="layui-input">
                </div>
                <div class="layui-col-xs5">
                  <div style="margin-left: 10px;">
                    <button type="button" class="layui-btn layui-btn-primary layui-btn-fluid" id="LAY-user-getsmscode">获取验证码</button>
                  </div>
                </div>
              </div>
            </div>
            <div class="layui-form-item">
              <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-forget-submit">找回密码</button>
            </div>
          {{# } }}
        </script>

		</div>
	</div>

	<input type="hidden" value="" id="isSave_phone" />
	<div class="layui-trans layadmin-user-login-footer">
		<p class="layui-word-aux">© 2018 NewLife Fitness</p>
		<p class="layui-word-aux">版权所有</p>
	</div>
	
</div>

<script src="${pageContext.request.contextPath}/layuiadmin/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/resource/js/user/forget_unruly.js"></script>
</body>
</html>