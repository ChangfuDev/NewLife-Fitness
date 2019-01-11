<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


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
					<li class="layui-nav-item layadmin-flexible" lay-unselect>
						<a href="javascript:;" title="收缩"  layadmin-event="flexible" title="侧边伸缩">
							<i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
						</a>
					</li>
					<li class="layui-nav-item layui-hide-xs" lay-unselect>
						<a href="http://www.layui.com/admin/" title="前台" target="_blank">
							<i class="layui-icon layui-icon-website"></i>
						</a>
					</li>
					<li class="layui-nav-item" lay-unselect >
						<a href="javascript:;" title="刷新" layadmin-event="refresh">
							<i class="layui-icon layui-icon-refresh-3"></i>
						</a>
					</li>
					<li class="layui-nav-item layui-hide-xs"  lay-unselect>
						<input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach" lay-action="template/search.html?keywords=">
					</li>
				</ul>
				<!-- 头部右边的导航栏 -->
				<ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">
					<!-- 消息提示 -->
					<li class="layui-nav-item" lay-unselect lay-tips="消息">
						<a lay-href="app/message/index.html" title="消息" layadmin-event="message" lay-text="消息中心">
							<i class="layui-icon layui-icon-notice"></i>
							<!-- 如果有新消息，则显示小圆点 -->
							<span class="layui-badge-dot"></span>
						</a>
					</li>

					<!-- 主题换肤 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="主题">
						<a href="javascript:;" title="主题" layadmin-event="theme">
							<i class="layui-icon layui-icon-theme"></i>
						</a>
					</li>

					<!-- 便签形式 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="便签">
						<a href="javascript:;" title="便签" layadmin-event="note">
							<i class="layui-icon layui-icon-note"></i>
						</a>
					</li>

					<!-- 全屏功能 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="全屏">
						<a href="javascript:;" title="全屏" layadmin-event="fullscreen">
							<i class="layui-icon layui-icon-screen-full"></i>
						</a>
					</li>

					<!-- 锁屏按钮 -->
					<li class="layui-nav-item layui-hide-xs" lay-unselect lay-tips="锁屏">
						<a href="javascript:;" id="closeScreen">
							<i class="layui-icon layui-icon-password"></i>
						</a>
					</li>

					<!-- 个人资料 -->
					<li class="layui-nav-item" lay-unselect>
						<a href="javascript:;">
						    <img src="${login_user.dImgUrl}" class="layui-nav-img" id="userHeadImg">
						    <cite>${login_user.dUserName}</cite>
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
						</dl>
					</li>

					<li class="layui-nav-item layui-hide-xs" lay-unselect>
						<a href="javascript:;">
							<i class="layui-icon layui-icon-more-vertical"></i>
						</a>
					</li>

					<li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
						<a href="javascript:;" layadmin-event="more">
							<i class="layui-icon layui-icon-more-vertical"></i>
						</a>
					</li>
				</ul>
			</div>


			<!-- 侧边菜单 -->
			<div class="layui-side layui-side-menu">
				<div class="layui-side-scroll">
					<div class="layui-logo" lay-href="home/console.html">
						<span>
							NewLife-Fitness
							<i class="layui-icon layui-icon-about"></i>
						</span>
					</div>

					<ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu" lay-filter="layadmin-system-side-menu">
						<li data-name="home" class="layui-nav-item layui-nav-itemed">
							<a href="javascript:;" lay-tips="主页" lay-direction="2">
								<i class="layui-icon layui-icon-home"></i>
								<cite>NewLife总览</cite>
							</a>
							<dl class="layui-nav-child">
								<dd data-name="console" class="layui-this">
									<a lay-href="home/console.html">控制台</a>
								</dd>
								<dd data-name="console">
									<a lay-href="home/homepage2.html">主页面</a>
								</dd>
							</dl>
						</li>
						<li data-name="component" class="layui-nav-item">
							<a href="javascript:;" lay-tips="组件" lay-direction="2">
								<i class="layui-icon layui-icon-component"></i>
								<cite>组件</cite>
							</a>
							<dl class="layui-nav-child">
								<dd data-name="grid">
									<a href="javascript:;">栅格</a>
									<dl class="layui-nav-child">
										<dd data-name="list">
											<a lay-href="component/grid/list.html">等比例列表排列</a>
										</dd>
										<dd data-name="mobile">
											<a lay-href="component/grid/mobile.html">按移动端排列</a>
										</dd>
										<dd data-name="mobile-pc">
											<a lay-href="component/grid/mobile-pc.html">移动桌面端组合</a>
										</dd>
										<dd data-name="all">
											<a lay-href="component/grid/all.html">全端复杂组合</a>
										</dd>
										<dd data-name="stack">
											<a lay-href="component/grid/stack.html">低于桌面堆叠排列</a>
										</dd>
										<dd data-name="speed-dial">
											<a lay-href="component/grid/speed-dial.html">九宫格</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="button">
									<a lay-href="component/button/index.html">按钮</a>
								</dd>
								<dd data-name="form">
									<a href="javascript:;">表单</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="component/form/element.html">表单元素</a>
										</dd>
										<dd>
											<a lay-href="component/form/group.html">表单组合</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="nav">
									<a lay-href="component/nav/index.html">导航</a>
								</dd>
								<dd data-name="tabs">
									<a lay-href="component/tabs/index.html">选项卡</a>
								</dd>
								<dd data-name="progress">
									<a lay-href="component/progress/index.html">进度条</a>
								</dd>
								<dd data-name="panel">
									<a lay-href="component/panel/index.html">面板</a>
								</dd>
								<dd data-name="badge">
									<a lay-href="component/badge/index.html">徽章</a>
								</dd>
								<dd data-name="timeline">
									<a lay-href="component/timeline/index.html">时间线</a>
								</dd>
								<dd data-name="anim">
									<a lay-href="component/anim/index.html">动画</a>
								</dd>
								<dd data-name="auxiliar">
									<a lay-href="component/auxiliar/index.html">辅助</a>
								</dd>
								<dd data-name="layer">
									<a href="javascript:;">
										通用弹层
										<span class="layui-nav-more"></span>
									</a>
									<dl class="layui-nav-child">
										<dd data-name="list">
											<a lay-href="component/layer/list.html" lay-text="layer 功能演示">功能演示</a>
										</dd>
										<dd data-name="special-demo">
											<a lay-href="component/layer/special-demo.html" lay-text="layer 特殊示例">特殊示例</a>
										</dd>
										<dd data-name="theme">
											<a lay-href="component/layer/theme.html" lay-text="layer 风格定制">风格定制</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="laydate">
									<a href="javascript:;">日期时间</a>
									<dl class="layui-nav-child">
										<dd data-name="demo1">
											<a lay-href="component/laydate/demo1.html" lay-text="layDate 功能演示一">功能演示一</a>
										</dd>
										<dd data-name="demo2">
											<a lay-href="component/laydate/demo2.html" lay-text="layDate 功能演示二">功能演示二</a>
										</dd>
										<dd data-name="theme">
											<a lay-href="component/laydate/theme.html" lay-text="layDate 设定主题">设定主题</a>
										</dd>
										<dd data-name="special-demo">
											<a lay-href="component/laydate/special-demo.html" lay-text="layDate 特殊示例">特殊示例</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="table-static">
									<a lay-href="component/table/static.html">静态表格</a>
								</dd>
								<dd data-name="table">
									<a href="javascript:;">数据表格</a>
									<dl class="layui-nav-child">
										<dd data-name="simple">
											<a lay-href="component/table/simple.html" lay-text="">简单数据表格</a>
										</dd>
										<dd data-name="auto">
											<a lay-href="component/table/auto.html" lay-text="">列宽自动分配</a>
										</dd>
										<dd data-name="data">
											<a lay-href="component/table/data.html" lay-text="">赋值已知数据</a>
										</dd>
										<dd data-name="tostatic">
											<a lay-href="component/table/tostatic.html" lay-text="">转化静态表格</a>
										</dd>
										<dd data-name="page">
											<a lay-href="component/table/page.html" lay-text="">开启分页</a>
										</dd>
										<dd data-name="resetPage">
											<a lay-href="component/table/resetPage.html" lay-text="">自定义分页</a>
										</dd>
										<dd data-name="toolbar">
											<a lay-href="component/table/toolbar.html" lay-text="">开启头部工具栏</a>
										</dd>
										<dd data-name="totalRow">
											<a lay-href="component/table/totalRow.html" lay-text="">开启合计行</a>
										</dd>
										<dd data-name="height">
											<a lay-href="component/table/height.html" lay-text="">高度最大适应</a>
										</dd>
										<dd data-name="checkbox">
											<a lay-href="component/table/checkbox.html" lay-text="">开启复选框</a>
										</dd>
										<dd data-name="radio">
											<a lay-href="component/table/radio.html" lay-text="">开启单选框</a>
										</dd>
										<dd data-name="cellEdit">
											<a lay-href="component/table/cellEdit.html" lay-text="">开启单元格编辑</a>
										</dd>
										<dd data-name="form">
											<a lay-href="component/table/form.html" lay-text="">加入表单元素</a>
										</dd>
										<dd data-name="style">
											<a lay-href="component/table/style.html" lay-text="">设置单元格样式</a>
										</dd>
										<dd data-name="fixed">
											<a lay-href="component/table/fixed.html" lay-text="">固定列</a>
										</dd>
										<dd data-name="operate">
											<a lay-href="component/table/operate.html" lay-text="">数据操作</a>
										</dd>
										<dd data-name="parseData">
											<a lay-href="component/table/parseData.html" lay-text="">解析任意数据格式</a>
										</dd>
										<dd data-name="onrow">
											<a lay-href="component/table/onrow.html" lay-text="">监听行事件</a>
										</dd>
										<dd data-name="reload">
											<a lay-href="component/table/reload.html" lay-text="">数据表格的重载</a>
										</dd>
										<dd data-name="initSort">
											<a lay-href="component/table/initSort.html" lay-text="">设置初始排序</a>
										</dd>
										<dd data-name="cellEvent">
											<a lay-href="component/table/cellEvent.html" lay-text="">监听单元格事件</a>
										</dd>
										<dd data-name="thead">
											<a lay-href="component/table/thead.html" lay-text="">复杂表头</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="laypage">
									<a href="javascript:;">分页</a>
									<dl class="layui-nav-child">
										<dd data-name="demo1">
											<a lay-href="component/laypage/demo1.html" lay-text="layPage 功能演示一">功能演示一</a>
										</dd>
										<dd data-name="demo2">
											<a lay-href="component/laypage/demo2.html" lay-text="layPage 功能演示二">功能演示二</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="upload">
									<a href="javascript:;">上传</a>
									<dl class="layui-nav-child">
										<dd data-name="demo1">
											<a lay-href="component/upload/demo1.html" lay-text="上传功能演示一">功能演示一</a>
										</dd>
										<dd data-name="demo2">
											<a lay-href="component/upload/demo2.html" lay-text="上传功能演示二">功能演示二</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="colorpicker">
									<a lay-href="component/colorpicker/index.html">颜色选择器</a>
								</dd>
								<dd data-name="slider">
									<a lay-href="component/slider/index.html">滑块组件</a>
								</dd>
								<dd data-name="rate">
									<a lay-href="component/rate/index.html">评分</a>
								</dd>
								<dd data-name="carousel">
									<a lay-href="component/carousel/index.html">轮播</a>
								</dd>
								<dd data-name="flow">
									<a lay-href="component/flow/index.html">流加载</a>
								</dd>
								<dd data-name="util">
									<a lay-href="component/util/index.html">工具</a>
								</dd>
								<dd data-name="code">
									<a lay-href="component/code/index.html">代码修饰</a>
								</dd>
							</dl>
						</li>
						<li data-name="template" class="layui-nav-item">
							<a href="javascript:;" lay-tips="页面" lay-direction="2">
								<i class="layui-icon layui-icon-template"></i>
								<cite>页面</cite>
							</a>
							<dl class="layui-nav-child">
								<dd>
									<a lay-href="template/personalpage.html">个人主页</a>
								</dd>
								<dd>
									<a lay-href="template/addresslist.html">通讯录</a>
								</dd>
								<dd>
									<a lay-href="template/caller.html">客户列表</a>
								</dd>
								<dd>
									<a lay-href="template/goodslist.html">商品列表</a>
								</dd>
								<dd>
									<a lay-href="template/msgboard.html">留言板</a>
								</dd>
								<dd>
									<a lay-href="template/search.html">搜索结果</a>
								</dd>
								<dd>
									<a href="user/reg.html" target="_blank">注册</a>
								</dd>
								<dd>
									<a href="user/login.html" target="_blank">登入</a>
								</dd>
								<dd>
									<a href="user/forget.html" target="_blank">忘记密码</a>
								</dd>
								<dd>
									<a lay-href="template/tips/404.html">404页面不存在</a>
								</dd>
								<dd>
									<a lay-href="template/tips/error.html">错误提示</a>
								</dd>
								<dd>
									<a lay-href="//www.baidu.com/">百度一下</a>
								</dd>
								<dd>
									<a lay-href="//www.layui.com/">layui官网</a>
								</dd>
								<dd>
									<a lay-href="//www.layui.com/admin/">layuiAdmin官网</a>
								</dd>
							</dl>
						</li>
						<li data-name="app" class="layui-nav-item">
							<a href="javascript:;" lay-tips="应用" lay-direction="2">
								<i class="layui-icon layui-icon-app"></i>
								<cite>应用</cite>
							</a>
							<dl class="layui-nav-child">

								<dd data-name="content">
									<a href="javascript:;">内容系统</a>
									<dl class="layui-nav-child">
										<dd data-name="list">
											<a lay-href="app/content/list.html">文章列表</a>
										</dd>
										<dd data-name="tags">
											<a lay-href="app/content/tags.html">分类管理</a>
										</dd>
										<dd data-name="comment">
											<a lay-href="app/content/comment.html">评论管理</a>
										</dd>
									</dl>
								</dd>
								<dd data-name="forum">
									<a href="javascript:;">社区系统</a>
									<dl class="layui-nav-child">
										<dd data-name="list">
											<a lay-href="app/forum/list.html">帖子列表</a>
										</dd>
										<dd data-name="replys">
											<a lay-href="app/forum/replys.html">回帖列表</a>
										</dd>
									</dl>
								</dd>
								<dd>
									<a lay-href="app/message/index.html">消息中心</a>
								</dd>
								<dd data-name="workorder">
									<a lay-href="app/workorder/list.html">工单系统</a>
								</dd>
							</dl>
						</li>
						<li data-name="senior" class="layui-nav-item">
							<a href="javascript:;" lay-tips="高级" lay-direction="2">
								<i class="layui-icon layui-icon-senior"></i>
								<cite>高级</cite>
							</a>
							<dl class="layui-nav-child">
								<dd>
									<a layadmin-event="im">LayIM 通讯系统</a>
								</dd>
								<dd data-name="echarts">
									<a href="javascript:;">Echarts集成</a>
									<dl class="layui-nav-child">
										<dd>
											<a lay-href="senior/echarts/line.html">折线图</a>
										</dd>
										<dd>
											<a lay-href="senior/echarts/bar.html">柱状图</a>
										</dd>
										<dd>
											<a lay-href="senior/echarts/map.html">地图</a>
										</dd>
									</dl>
								</dd>
							</dl>
						</li>
						<li data-name="user" class="layui-nav-item">
							<a href="javascript:;" lay-tips="用户" lay-direction="2">
								<i class="layui-icon layui-icon-user"></i>
								<cite>用户</cite>
							</a>
							<dl class="layui-nav-child">
								<dd>
									<a lay-href="user/user/list.html">用户管理</a>
								</dd>
								
								<dd>
									<a lay-href="user/administrators/list.html">教练管理</a>
								</dd>
								
								<dd>
									<a lay-href="user/administrators/role.html">后台管理员</a>
								</dd>
							</dl>
						</li>
						
						<li data-name="set" class="layui-nav-item">
							<a href="javascript:;" lay-tips="设置" lay-direction="2">
								<i class="layui-icon layui-icon-set"></i>
								<cite>设置</cite>
							</a>
							<dl class="layui-nav-child">
								<dd class="layui-nav-itemed">
									<a lay-href="set/website.html">系统设置</a>
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
							</dl>
						</li>
						
					</ul>
				</div>
			</div>

			<!-- 页面标签 -->
			<div class="layadmin-pagetabs" id="LAY_app_tabs">
				<div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
				<div class="layui-icon layadmin-tabs-control layui-icon-down">
					<ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
						<li class="layui-nav-item" lay-unselect>
							<a href="javascript:;"></a>
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
							</dl>
						</li>
					</ul>
				</div>
				<div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
					<ul class="layui-tab-title" id="LAY_app_tabsheader">
						<li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this">
							<i class="layui-icon layui-icon-home"></i>
						</li>
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
                     /* 
                        var data = JSON.parse(event.data);
                        var used = Math.floor(((data.usedMemory / data.totalSize) * 100));
                        element.progress('cup', data.cpu + '%');
                        element.progress('usedMemory', used + '%');
                     */
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