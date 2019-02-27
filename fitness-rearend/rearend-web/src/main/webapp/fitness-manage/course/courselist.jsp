<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>数据表格的重载 - 数据表格</title>
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

	<div class="layui-card layadmin-header">
		<div class="layui-breadcrumb" lay-filter="breadcrumb">
			<a lay-href="">主页</a> <a><cite>组件</cite></a> <a><cite>数据表格</cite></a>
			<a><cite>数据表格的重载</cite></a>
		</div>
	</div>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space15">
			<div class="layui-col-md12">
				<div class="layui-card">
					<div class="layui-card-header">课程管理</div>
					<div class="layui-card-body">
						<div class="test-table-reload-btn" style="margin-bottom: 10px;">
							教程名称：
							<div class="layui-inline layui-form">
								<input class="layui-input" name="cName"
									id="selectcName" autocomplete="off">
							</div>
							是否VIP可看：
							<div class="layui-inline layui-form">
								<select name="cIsvip" lay-verify="" lay-filter="selectIsvip">
									<option value="">请选择--默认没有显示所有</option>
									<option value="是">是</option>
									<option value="否">否</option>
								</select>
							</div>
							<button class="layui-btn" data-type="reload">搜索</button>
						</div>
						<table class="layui-hide" id="test-table-reload" lay-filter="course"></table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/html" id="addtrain-toolbar">
		<div class="layui-btn-container">
   			<button class="layui-btn layui-btn-sm" lay-event="addCourse">新增教程</button>
   			<button class="layui-btn layui-btn-sm" lay-event="importCourse" id="import">导入数据</button>
			
 		</div>
    </script>
	
	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  		<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script>
		layui.config({
			base : '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
		}).extend({
			index : 'lib/index' //主入口模块
		}).use([ 'index', 'table','form','layer','upload'], function() {
			//引用各个模块
			var table = layui.table;
			var form = layui.form;
			var layer = layui.layer;
			var upload = layui.upload;
			
			//方法级渲染
		    table.render({
		      elem: '#test-table-reload'
		      ,height:480
		      ,cellMinWidth: 80
		      ,toolbar: '#addtrain-toolbar'
		      ,url: '/rearend-web/manage/getcourses'
		      ,cols: [[
		        {checkbox: true, fixed: true}
		        ,{field:'id', title: 'id', sort: true, fixed: true}
		        ,{field:'cName', title: '课程名称'}
		        ,{field:'cIsvip', title: '是否vip可看'}
		        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
		      ]]
		      ,page: true
		    });
			
			//表格头部工具条事件
		    table.on('toolbar(course)',function(obj){
		    	if(obj.event=== 'addCourse'){
		    		layer.open({
		    			title : '新增课程'
		    			,type : 2
		    			,maxmin : true
		    			,area : ['850px', '620px']
		    			,content : 'addcourse.jsp'
		    		})	
		    	}
		    })
			
			//表格操作事件
		    table.on('tool(course)',function(obj){
		    	var data = obj.data;
		    	if(obj.event === 'del'){
		    		layer.confirm('真的删除行么', function(index){
		    			$.ajax({
		    				url:"${pageContext.request.contextPath}/manage/course/"+data.id,
		    				type:"DELETE",
		    				timeout:5000,
		    				async: false,
		    				success:function(data){
		    					if(data.msg === '删除成功'){
		    		    	        obj.del();
		    		    	        layer.close(index);
		    						layer.msg(data.msg);
		    					}else{
		    						layer.msg('删除失败：'+data.msg);
		    					}
		    				}
		    			})
		    	      });
		    	}else if(obj.event === 'edit'){
		    		$.ajax({
		    			url:"${pageContext.request.contextPath}/manage/course/"+data.id,
		    			type:"GET",
		    			timeout:5000,
		        		dataType:'json',
		        		success:function(data){
		        			if(data != null){
		        				layer.open({
		        					title : "查看课程"
		        					,type : 2
		        					,maxmin : true
		        					,area : ['850px', '620px']
		        					,content : 'updatecourse.jsp'
		        					,success : function(layero, index){
		        						 //得到iframe页的body内容
		        						 var body = layer.getChildFrame('body', index);
		        						 //向iframe表单刷新数据
		        						 body.find("input[name='id']").val(data.id)
		        						 body.find("input[name='cName']").val(data.cName)
		        						 body.find("select[name='cIsvip']").find("option[value='"+data.cIsvip+"']").attr("selected",true);
		        						 form.render();
		        					}
		        				})
		        			}
		        		}		    			
		    		})
		    	}else if(obj.event === 'detail'){
		    		$.ajax({
		    			url:"${pageContext.request.contextPath}/manage/course/"+data.id,
		    			type:"GET",
		    			timeout:5000,
		        		dataType:'json',
		        		success:function(data){
		        			if(data != null){
		        				layer.open({
		        					title : "查看课程"
		        					,type : 2
		        					,maxmin : true
		        					,area : ['850px', '620px']
		        					,content : 'seecourse.jsp'
		        					,success : function(layero, index){
		        						 //得到iframe页的body内容
		        						 var body = layer.getChildFrame('body', index);
		        						 //向iframe表单刷新数据
		        						 body.find("input[name='id']").val(data.id)
		        						 body.find("input[name='cName']").val(data.cName)
		        						 body.find("select[name='cIsvip']").find("option[value='"+data.cIsvip+"']").attr("selected",true);
		        						 form.render();
		        					}
		        				})
		        			}
		        		}		    			
		    		})
		    	}
		    })
			
			//获取是否是会员可看下拉框选中的值
			var cIsvip = null;
			form.on('select(selectIsvip)',function(data){
				cIsvip = data.elem.value;
			})
			var $ = layui.$, active = {
				reload : function() {
					var cName = $('#selectcName').val();
					//执行重载
					table.reload('test-table-reload', {
						page : {
							curr : 1
						//重新从第 1 页开始
						},
						where : {
							"cName" : cName
							,"cIsvip" : cIsvip
						}
					});
				}
			};

			$('.test-table-reload-btn .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			
			upload.render({
    		    elem: '#import'
    		    ,url: '${pageContext.request.contextPath}/manage/importCourse'
    		    ,before: function(obj){
    		      //预读本地文件示例，不支持ie8
    		      obj.preview(function(index, file, result){
    		        $('#demo1').attr('src', result); //图片链接（base64）
    		      });
    		    }
    		    ,done: function(res){
    		      //如果上传成功
    		      if(res.code == 0){
    		    	  return layer.msg(res.msg);
    		      }else{
    		    	  return layer.msg(res.msg);
    		      }
    		    }
    		    ,accept: 'file'
    		    ,error: function(){
    		      //演示失败状态，并实现重传
    		      var demoText = $('#demoText');
    		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
    		      demoText.find('.demo-reload').on('click', function(){
    		        uploadInst.upload();
    		      });
    		    }
    		  });
			
		});
	</script>
</body>
</html>