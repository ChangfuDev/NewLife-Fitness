<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>设置我的资料</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">设置我的资料</div>
					<div class="layui-card-body" pad15>

						<div class="layui-form">
							<div class="layui-form-item">
								<label class="layui-form-label">我的角色</label>
								<div class="layui-input-inline">
									<c:choose>
										<c:when test="${login_user.userRole == 0}">
											<select>
												<option selected>超级管理员</option>
												<option disabled>普通管理员</option>
											</select>
										</c:when>
										<c:when test="${login_user.userRole == 1}">
											<select>
												<option disabled>超级管理员</option>
												<option selected>普通管理员</option>
											</select>
										</c:when>
									</c:choose>
								</div>
								<p class="layui-form-mid layui-word-aux">当前角色不可更改为其它角色</p>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">用户名</label>
								<div class="layui-input-inline">
									<input type="text" id="dLoginName" value="${login_user.dLoginName}" disabled class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux">不可修改。一般用于后台登入名</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">昵称</label>
								<div class="layui-input-inline">
									<input type="text" readonly id="dUserName" name="dUserName" value="${login_user.dUserName }" lay-verify="nickname" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">性别</label>
								<div class="layui-input-block">
									<c:choose>
										<c:when test="${login_user.dSex eq '男'}">
											<input type="radio"  name="dSex" value="男" title="男" checked>
											<input type="radio" name="dSex" value="女" title="女" disabled>
										</c:when>
										<c:when test="${login_user.dSex eq '女'}">
											<input type="radio" name="dSex" value="男" title="男" disabled>
											<input type="radio" name="dSex" value="女" title="女" checked>
										</c:when>
									</c:choose>
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">头像</label>
								<div class="layui-input-inline">
									<input name="avatar" type="hidden" lay-verify="required" id="LAY_avatarSrc" placeholder="图片地址" value="${login_user.dImgUrl}">
								</div>
								<div class="layui-input-inline layui-btn-container" style="width: auto;">
									<button type="button" class="layui-btn layui-btn-disabled" disabled id="LAY_avatarUpload">
										<i class="layui-icon">&#xe67c;</i>上传头像
									</button>
									<button class="layui-btn layui-btn-normal" layadmin-event="avartatPreview">查看头像</button>
								</div>
								<p class="layui-form-mid layui-word-aux">仅仅支持jpg、png、gif格式，大小不能超过2M。</p>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">手机</label>
								<div class="layui-input-inline">
									<input readonly type="text" name="dPhone" value="${login_user.dPhone }" lay-verify="phone" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">邮箱</label>
								<div class="layui-input-inline">
									<input readonly type="text" name="dEmail" value="${login_user.dEmail }" lay-verify="email" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">备注</label>
								<div class="layui-input-block">
									<textarea readonly name="dMark" placeholder="请输入内容" class="layui-textarea">${login_user.dMark }</textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button id="editBtn" class="layui-btn">点击编辑</button>
									<button class="layui-btn layui-btn-warm layui-hide" lay-submit lay-filter="setmyinfo">确认修改</button>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'set' ]);
	</script>
</body>
</html>