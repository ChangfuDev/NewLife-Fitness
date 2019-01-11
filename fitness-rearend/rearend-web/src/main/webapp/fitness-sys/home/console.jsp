<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>主页</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md8">
				<div class="layui-row layui-col-space15">
					<div class="layui-col-md6">
						<div class="layui-card">
							<div class="layui-card-header">快捷方式</div>
							<div class="layui-card-body">
								<div class="layui-carousel layadmin-carousel layadmin-shortcut">
									<div carousel-item>
										<ul class="layui-row layui-col-space10">
											<li class="layui-col-xs3"><a lay-href="home/console.html"> <i class="layui-icon layui-icon-console"></i> <cite>控制台</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="home/homepage2.html"> <i class="layui-icon layui-icon-chart"></i> <cite>主页面</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="component/layer/list.html"> <i class="layui-icon layui-icon-template-1"></i> <cite>弹层</cite>
											</a></li>
											<li class="layui-col-xs3"><a layadmin-event="im"> <i class="layui-icon layui-icon-chat"></i> <cite>聊天</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="component/progress/index.html"> <i class="layui-icon layui-icon-find-fill"></i> <cite>进度条</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="app/workorder/list.html"> <i class="layui-icon layui-icon-survey"></i> <cite>工单</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="set/info.html"> <i class="layui-icon layui-icon-username"></i> <cite>个人信息</cite>
											</a></li>
											<li class="layui-col-xs3"><a lay-href="set/website.html"> <i class="layui-icon layui-icon-set"></i> <cite>SEO优化</cite>
											</a></li>
										</ul>
									</div>
								</div>

							</div>
						</div>
					</div>
					<div class="layui-col-md6">
						<div class="layui-card">
							<div class="layui-card-header">待办事项</div>
							<div class="layui-card-body">

								<div class="layui-carousel layadmin-carousel layadmin-backlog">
									<div carousel-item>
										<ul class="layui-row layui-col-space10">
											<li class="layui-col-xs6"><a lay-href="app/content/comment.html" class="layadmin-backlog-body">
													<h3>待审评论</h3>
													<p>
														<cite>66</cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a lay-href="app/forum/list.html" class="layadmin-backlog-body">
													<h3>待审帖子</h3>
													<p>
														<cite>12</cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a lay-href="template/goodslist.html" class="layadmin-backlog-body">
													<h3>待审商品</h3>
													<p>
														<cite>99</cite>
													</p>
											</a></li>
											<li class="layui-col-xs6"><a href="javascript:;" onclick="layer.tips('不跳转', this, {tips: 3});" class="layadmin-backlog-body">
													<h3>待发货</h3>
													<p>
														<cite>20</cite>
													</p>
											</a></li>
										</ul>
										<ul class="layui-row layui-col-space10">
											<li class="layui-col-xs6"><a href="javascript:;" class="layadmin-backlog-body">
													<h3>待审友情链接</h3>
													<p>
														<cite style="color: #FF5722;">5</cite>
													</p>
											</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="layui-col-md12">
						<div class="layui-card">
							<div class="layui-card-header">数据概览</div>
							<div class="layui-card-body">

								<div class="layui-carousel layadmin-carousel layadmin-dataview" data-anim="fade" lay-filter="LAY-index-dataview">
									<div carousel-item id="LAY-index-dataview">
										<div>
											<i class="layui-icon layui-icon-loading1 layadmin-loading"></i>
										</div>
										<div></div>
										<div></div>
									</div>
								</div>

							</div>
						</div>
						<div class="layui-card">
							<div class="layui-tab layui-tab-brief layadmin-latestData">
								<ul class="layui-tab-title">
									<li class="layui-this">订单记录</li>
									<li name="allAdvice">全部通知</li>
								</ul>
								<div class="layui-tab-content">
									<div class="layui-tab-item layui-show">
										<table id="LAY-index-topSearch"></table>
									</div>
									<div class="layui-tab-item">
										<table id="LAY-index-topCard"></table>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>



			<div class="layui-col-md4">

				<div class="layui-card">
					<div class="layui-card-header">
						通知概要 <span class="layui-badge">3</span> <i class="layui-icon layui-icon-tips" lay-tips="最新通知" lay-offset="5"></i>
					</div>
					<ul class="layui-timeline">
						<c:if test="${announce != null}">
							<c:forEach items="${announce}" var="item">
								<li class="layui-timeline-item"><i class="layui-icon layui-timeline-axis"></i>
									<section class="layui-timeline-content layui-text">
										<h3 class="layui-timeline-title">
											<fmt:formatDate value="${item.createDate}" pattern="yyyy-MM-dd HH:mm:ss " />
										</h3>
										<article>${item.codeContent}</article>
									</section></li>
							</c:forEach>
						</c:if>

						<li class="layui-timeline-item"><i class="layui-icon layui-anim layui-anim-rotate layui-anim-loop layui-timeline-axis"></i>
							<section class="layui-timeline-content layui-text">
								<header class="layui-timeline-title">
									<p class="layui-word-aux" style="text-decoration: none;">
										仅显示近三条通知 <i class="layui-icon layui-icon-tree"> </i>
									</p>
								</header>
							</section></li>
					</ul>
				</div>

				<div class="layui-card">
					<div class="layui-card-header">
						发送通知 <i class="layui-icon layui-icon-tips" lay-tips="只有超级管理员才有权限哦~" lay-offset="5"></i>
					</div>
					<div class="layui-card-body layui-text layadmin-text">
						<form class="layui-form layui-form-pane" action="">
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">填写内容</label>
								<div class="layui-input-block">
									<textarea placeholder="请输入内容" id="editContent" class="layui-textarea"></textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<c:if test="${login_user != null }">
									<c:choose>
										<c:when test="${login_user.userRole == 0}">
											<div>
												<button class="layui-btn layui-btn-fluid site-demo-layedit" lay-submit lay-filter=formAdvice>发送通知</button>
											</div>
										</c:when>
										<c:when test="${login_user.userRole == 1}">
											<div>
												<button class="layui-btn layui-btn-fluid layui-btn-disabled site-demo-layedit" disabled>发送通知</button>
											</div>
										</c:when>
										<c:otherwise>
											<div>
												<button class="layui-btn layui-btn-fluid layui-btn-disabled site-demo-layedit" disabled>发送通知</button>
											</div>
										</c:otherwise>
									</c:choose>
								</c:if>
							</div>
						</form>
					</div>
				</div>

				<div class="layui-card">
					<div class="layui-card-header">前台动态</div>
					<div class="layui-card-body">
						<div class="layui-carousel layadmin-carousel layadmin-news" data-autoplay="true" data-anim="fade" lay-filter="news">
							<div carousel-item>
								<div>
									<a href="#" target="_blank" class="layui-bg-red">NewLife-Fitness 首页</a>
								</div>
								<div>
									<a href="#" target="_blank" class="layui-bg-green">NewLife 讨论专区</a>
								</div>
								<div>
									<a href="#" target="_blank" class="layui-bg-blue">NewLife 课程区域</a>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="layui-card">
					<div class="layui-card-header">实时监控</div>
					<div class="layui-card-body layadmin-takerates">
						<div class="layui-progress" lay-showPercent="yes" lay-filter="cup">
							<h3>CPU使用率</h3>
							<div class="layui-progress-bar" lay-percent="0%"></div>
						</div>
						<div class="layui-progress" lay-showPercent="yes" lay-filter="usedMemory">
							<h3>已用内存</h3>
							<div class="layui-progress-bar layui-bg-green" lay-percent="0%"></div>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js?t=1"></script>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'console', "layedit", "jquery", "element", "form" ], function() {
			var layedit = layui.layedit, $ = layui.jquery, element = layui.element, form = layui.form;

			//判断当前浏览器是否支持WebSocket，实现双全工打开管道。
			var websocket = null;
			if ('WebSocket' in window) {
				websocket = new WebSocket("ws://localhost:8080/rearend-web/getInfo");

				//连接成功建立的回调方法
				websocket.onopen = function() {
					websocket.send("客户端链接成功");
				};

				//接收到消息的回调方法
				websocket.onmessage = function(event) {
					var data = JSON.parse(event.data);
					var used = Math.floor(((data.usedMemory / data.totalSize) * 100));
					element.progress('cup', data.cpu + '%');
					element.progress('usedMemory', used + '%');
				};

				//连接发生错误的回调方法
				websocket.onerror = function() {
					alert("WebSocket连接发生错误");
				};
				//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
				window.onbeforeunload = function() {
					websocket.close();
				};
			} else {
				alert('当前浏览器 Not support websocket，请使用高版本浏览器支持更多功能！');
			}

			// 自定义工具栏
			var index = layedit.build('editContent', {
				tool : [ 'strong', 'italic', 'underline', 'link', '|', 'left', 'center', 'right', 'face' ],
				height : 100
			});

			// 通知发送提交
			form.on('submit(formAdvice)', function() {
				var content = layedit.getContent(index); // 带代码的内容 
				var text = layedit.getText(index); // 纯文本的内容
				// 发送通知请求
				$.post("sendMessage.do", "content=" + content + "&text=" + text, function(data) {
					var val = JSON.parse(data);
					if (val.status === "fail") {
						layer.alert(val.msg, {
							icon : 5,
							anim : 5,
							time : 2000
						});
					} else {
						layer.msg(val.msg, {
							time : 1000,
							anim : 1
						});
					}
				}, "text");
				return false;
			});

		});
	</script>
</body>
</html>

