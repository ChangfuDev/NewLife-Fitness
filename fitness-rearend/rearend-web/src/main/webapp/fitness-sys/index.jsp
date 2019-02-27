<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>NewLife-Fitness后台管理系统</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
<script>
	/^http(s*):\/\//.test(location.href) || alert('请先部署到 localhost 下再访问');
</script>
</head>
<body class="layui-layout-body">
	<div id="LAY_app">
		<div class="layui-layout layui-layout-admin">
			<div class="layui-header">
				<!-- 头部区域 -->
				<ul class="layui-nav layui-layout-left">
					<li class="layui-nav-item layadmin-flexible" lay-unselect><a href="javascript:;" title="收缩" layadmin-event="flexible" title="侧边伸缩"> <i
							class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><a href="http://localhost:8080/frontend-web/page/index.jsp" title="前台" target="_blank"> <i class="layui-icon layui-icon-website"></i>
					</a></li>
					<li class="layui-nav-item" lay-unselect><a href="javascript:;" title="刷新" layadmin-event="refresh"> <i class="layui-icon layui-icon-refresh-3"></i>
					</a></li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect><input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search"
						layadmin-event="serach" lay-action="https://cn.bing.com/search?q="></li>
				</ul>
				<!-- 头部右边的导航栏 -->
				<ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

					<!-- 主题换肤 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="主题"><a href="javascript:;" title="主题" layadmin-event="theme"> <i class="layui-icon layui-icon-theme"></i>
					</a></li>

					<!-- 便签形式 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="便签"><a href="javascript:;" title="便签" layadmin-event="note"> <i class="layui-icon layui-icon-note"></i>
					</a></li>

					<!-- 全屏功能 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="全屏"><a href="javascript:;" title="全屏" layadmin-event="fullscreen"> <i
							class="layui-icon layui-icon-screen-full"></i>
					</a></li>

					<!-- 锁屏按钮 -->
					<li class="layui-nav-item" lay-unselect lay-tips="锁屏"><a href="javascript:;" id="closeScreen"> <i class="layui-icon layui-icon-password"></i>
					</a></li>

					<!-- 个人资料 -->
					<li class="layui-nav-item" lay-unselect><a href="javascript:;"> <img src="${login_user.dImgUrl}" class="layui-nav-img" id="userHeadImg"> <cite>${login_user.dUserName}</cite>
					</a>
						<dl class="layui-nav-child">
							<dd style="text-align: center;">
								<a lay-href="set/info.html">基本资料</a>
							</dd>
							<dd style="text-align: center;">
								<a lay-href="set/password.html">修改密码</a>
							</dd>
							<hr />
							<dd style="text-align: center;">
								<a href="loginOut.html">退出</a>
							</dd>
						</dl></li>

					<li class="layui-nav-item layui-hide-xs" lay-unselect><a href="javascript:;"> <i class="layui-icon layui-icon-more-vertical"></i>
					</a></li>

					<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect><a href="javascript:;" layadmin-event="more"> <i
							class="layui-icon layui-icon-more-vertical"></i>
					</a></li>
				</ul>
			</div>


			<!-- 侧边菜单 -->
			<div class="layui-side layui-side-menu">
				<div class="layui-side-scroll">

					<div class="layui-logo" lay-href="home/console.html">
						<span> NewLife-Fitness <i class="layui-icon layui-icon-about"></i>
						</span>
					</div>

					<ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
						<li data-name="home" class="layui-nav-item layui-nav-itemed layui-this"><a href="javascript:;" lay-href="home/console.html" lay-tips="主页" lay-direction="2"> <i
								class="layui-icon layui-icon-home"></i> <cite>数据总览</cite>
						</a></li>
						<li data-name="user-manage" class="layui-nav-item"><a href="javascript:;" lay-href="${pageContext.request.contextPath }/fitness-manage/user/userlist.jsp"> <i
								class="layui-icon layui-icon-user"></i> <cite>用户管理</cite>
						</a></li>
						<li data-name="template" class="layui-nav-item"><a href="javascript:;" lay-href="${pageContext.request.contextPath }/fitness-manage/train/trainlist.jsp"> <i
								class="layui-icon layui-icon-find-fill"></i> <cite>教练管理</cite>
						</a></li>
						<li data-name="template" class="layui-nav-item"><a href="javascript:;" lay-href="${pageContext.request.contextPath }/fitness-manage/course/courselist.jsp"> <i
								class="layui-icon layui-icon-survey"></i> <cite>課程管理</cite>
						</a></li>
						<c:if test="${login_user != null and login_user.userRole == 0}">
							<li data-name="user" class="layui-nav-item"><a href="javascript:;" lay-href="${pageContext.request.contextPath }/fitness-manage/duser/duserlist.jsp"> <i
									class="layui-icon layui-icon-rate-solid"></i> <cite>管理员</cite>
							</a></li>
						</c:if>
						<li data-name="set" class="layui-nav-item layui-nav-itemed"><a href="javascript:;" lay-tips="设置" lay-direction="2"> <i class="layui-icon layui-icon-set"></i> <cite>设置</cite>
						</a>
							<dl class="layui-nav-child">
								<dd class="layui-nav-itemed">
									<a lay-href="set/website.html">SEO优化</a>
								</dd>
								<dd class="layui-nav-itemed">
									<a href="javascript:;">我的设置</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="set/info.html">基本资料</a>
										</dd>
										<dd>
											<a lay-href="set/password.html">修改密码</a>
										</dd>
									</dl>
								</dd>
							</dl></li>

					</ul>
				</div>
			</div>

			<!-- 页面标签 -->
			<div class="layadmin-pagetabs" id="LAY_app_tabs">
				<div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-down">
					<ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
						<li class="layui-nav-item" lay-unselect><a href="javascript:;"></a>
							<dl class="layui-nav-child layui-anim-fadein">
								<dd layadmin-event="closeThisTabs">
									<a href="javascript:;">关闭当前标签页</a>
								</dd>
								<dd layadmin-event="closeOtherTabs">
									<a href="javascript:;">关闭其它标签页</a>
								</dd>
								<dd layadmin-event="closeAllTabs">
									<a href="javascript:;">关闭全部标签页</a>
								</dd>
							</dl></li>
					</ul>
				</div>
				<div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
					<ul class="layui-tab-title" id="LAY_app_tabsheader">
						<li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i class="layui-icon layui-icon-home"></i></li>
					</ul>
				</div>
			</div>


			<!-- 主体内容 -->
			<div class="layui-body" id="LAY_app_body">
				<div class="layadmin-tabsbody-item layui-show">
					<iframe src="home/console.html" frameborder="0" class="layadmin-iframe"></iframe>
				</div>
			</div>

			<!-- 辅助元素，一般用于移动设备下遮罩 -->
			<div class="layadmin-body-shade" layadmin-event="shade"></div>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'jquery', 'form', 'layer' ], function() {
			var $ = layui.$, form = layui.form, layer = layui.layer;

			//判断当前浏览器是否支持WebSocket，实现双全工打开管道。
			var websocket = null;
			if ('WebSocket' in window) {
				websocket = new WebSocket("ws://localhost:8080/rearend-web/getSystem");

				//连接成功建立的回调方法
				websocket.onopen = function() {
					websocket.send("客户端链接成功");
				};

				//接收到消息的回调方法
				websocket.onmessage = function(event) {
					console.log(event);
					// 通知回显
					layer.open({
						type : 1,
						title : "最新通告",
						offset : 't', //具体配置参考：offset参数项
						content : '<div style="padding: 20px 80px;">' + event.data + '</div>',
						btn : '确定',
						btnAlign : 'c', //按钮居中
						shade : 0, //不显示遮罩
						closeBtn : 0,
						yes : function() {
							layer.closeAll();
							window.location.reload();
						}
					});
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

			// 防止退出登录后网页还能回退的JS代码
			if (window.history && window.history.pushState) {
				$(window).on('popstate', function() {
					window.history.pushState('forward', null, '#');
					window.history.forward(1);
				});
				window.history.pushState('forward', null, '#');
				window.history.forward(1);
			}

			// 点击锁屏产生进行退出操作，解锁进行登录操作，次数上线，退出登录清除Cookie。
			$("#closeScreen").click(function() {
				// 声明一个点击时产生的全局的变量，用于判断解锁的次数。
				var number = 0;
				// 点击发送异步请求,销毁Session；
				$.post("closeScreen", null, function(data) {
					if (data === "success") {
						layer.alert('请勿使用，使用请解锁....', {
							skin : 'layui-layer-molv', //样式类名
							closeBtn : 0,
							anim : 1,
							icon : 4,
							title : '主人离开了~',
							btn : [ '解锁' ],
							btnAlign : 'c'
						}, function() { //  点击解锁按钮
							layer.prompt({
								title : '请输入密码，只有三次机会喔~',
								formType : 1,
								closeBtn : 0,
								maxlength : 140,
								btn : [ '确定' ],
								btnAlign : "c"
							}, function(pass, index) {
								number++;
								var value = "pass=" + pass + "&number=" + number;
								$.post("../openScreen", value, function(data) {
									if (data === "success") {
										number = 0;
										layer.closeAll();
										layer.msg("欢迎回来~");
									} else if (data === "error") {
										var ramain = 3 - number;
										layer.msg("密码输入错误，还剩" + ramain + "次机会。", {
											icon : 5,
											time : 2000,
											anim : 6
										});
									} else if (data === "fail") {
										location.href = "../login.html";
									}
								}, "text");
							});
						});
					}
					;
				}, "text");
			});

		});
	</script>
</body>
</html>