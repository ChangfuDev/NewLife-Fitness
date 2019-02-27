<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>新增用户</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css"
	media="all">
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-card">
			<div class="layui-card-header">Test</div>
			<div class="layui-card-body layui-form" style="padding: 15px;">
					<div class="layui-form-item">
						<label class="layui-form-label">课程名称</label>
						<div class="layui-input-block">
							<input type="hidden" name="id">
							<input type="text" name="cName" lay-verify="required|cName"
								autocomplete="off" class="layui-input" disabled>
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">是否VIP可看</label>
							<div class="layui-input-inline" disabled>
								<select name="cIsvip">
									<option value="是">是</option>
									<option value="否">否</option>
								</select>
							</div>
						</div>
					</div>
					<fieldset class="layui-elem-field layui-field-title">
  						<legend>视频列表</legend>
  							<div class="layui-field-box">
    							<table class="layui-hide" id="test-table-reload" lay-filter="course"></table>
  							</div>
					</fieldset>
			</div>
		</div>
	</div>
	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script>
  layui.config({
	    base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index', 'layer','table'], function(){
	    var $ = layui.jquery
	    ,layer = layui.layer
		,table = layui.table	    
	    
		var id = $("input[name='id']").val();
		
		//方法级渲染
	    table.render({
	      elem: '#test-table-reload'
	      ,height:480
	      ,cellMinWidth: 80
	      ,url: '/rearend-web/manage/getcoursevideos?cid='+id
	      ,cols: [[
	        {field:'id', title: 'id', sort: true, fixed: true}
	        ,{field:'title', title: '标题'}
	        ,{field:'videoUrl', title: '地址'}
	      ]]
	      ,page: true
	    });	  
	  });
  </script>
</body>
</html>
