<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>网站SEO设置</title>
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
					<div class="layui-card-header">网站设置（SEO优化）</div>
					<div class="layui-card-body" pad15>

						<div class="layui-form" wid100 lay-filter="">
							<input type="hidden" name="id" value="${website.id}" class="layui-input">
							<div class="layui-form-item">
								<label class="layui-form-label">网站名称</label>
								<div class="layui-input-block">
									<input type="text" name="domainName" value="${website.domainName}" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">缓存时间</label>
								<div class="layui-input-inline" style="width: 80px;">
									<input type="text" name="catchTime" lay-verify="number" value="${website.catchTime}" class="layui-input">
								</div>
								<div class="layui-input-inline layui-input-company">分钟</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>

							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">首页标题</label>
								<div class="layui-input-block">
									<textarea name="title" class="layui-textarea">${website.title}</textarea>
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">META关键词</label>
								<div class="layui-input-block">
									<textarea name="keyword" class="layui-textarea" placeholder="多个关键词用英文状态 , 号分割">${website.keyword}</textarea>
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">META描述</label>
								<div class="layui-input-block">
									<textarea name="description" class="layui-textarea">${website.description}</textarea>
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label">版权信息</label>
								<div class="layui-input-block">
									<textarea name="copyright" class="layui-textarea">${website.copyright}</textarea>
								</div>
							</div>
							<div class="layui-form-item">
								<div class="layui-input-block">
									<button class="layui-btn" lay-submit lay-filter="set_website">确认保存</button>
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