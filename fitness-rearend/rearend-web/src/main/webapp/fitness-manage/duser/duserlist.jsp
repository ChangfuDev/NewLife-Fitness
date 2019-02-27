<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css"
	media="all">
<style type="text/css">
.layui-table-fixed-r td{height:58px!important;}
.layui-table-fixed-r th{height:58px!important;}
.layui-table img {
    max-width: 48px;min-height: 48px;
}


		.laytable-cell-3-wx_headimg ,
		.laytable-cell-1-wx_headimg,
		.laytable-cell-2-wx_headimg,
		.laytable-cell-3-wx_headimg,
		.laytable-cell-4-wx_headimg,
		.laytable-cell-5-wx_headimg,
		.laytable-cell-6-wx_headimg,
		.laytable-cell-7-wx_headimg,
		.laytable-cell-8-wx_headimg,
		.laytable-cell-9-wx_headimg,
		.laytable-cell-10-wx_headimg,
		.laytable-cell-11-wx_headimg,
		.laytable-cell-12-wx_headimg,
		.laytable-cell-13-wx_headimg,
		.laytable-cell-14-wx_headimg{
		    width: 48px!important;;padding:0px!important;height: 48px!important;;
		    line-height: 48px!important;;
		}

</style>
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
					<div class="layui-card-header">客戶管理</div>
					<div class="layui-card-body">
						<div class="test-table-reload-btn" style="margin-bottom: 10px;">
							用户名称：
							<div class="layui-inline layui-form">
								<input class="layui-input" name="dUserName"
									id="selectUserName" autocomplete="off">
							</div>
							管理员等级：
							<div class="layui-inline layui-form">
								<select name="userRole" lay-verify="" lay-filter="selectIsvip">
									<option value="">请选择--默认没有显示所有</option>
									<option value="0">超级管理员</option>
									<option value="1">普通管理员</option>
									<option value="2">禁用</option>
								</select>
							</div>
							<button class="layui-btn" data-type="reload">搜索</button>
						</div>
						<table class="layui-hide" id="test-table-reload" lay-filter="fuser"></table>


					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/html" id="adduser-toolbar">
		<div class="layui-btn-container">
   			<button class="layui-btn layui-btn-sm" lay-event="addUser">新增用户</button>
   			<button class="layui-btn layui-btn-sm" lay-event="importUser" id="import">导入数据</button>
 		</div>
    </script>
	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
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
		      ,toolbar: '#adduser-toolbar'
		      ,url: '/rearend-web/manage/findDUser'
		      ,cols: [[
		    	 {field:'id', title: 'id'}
		        ,{field:'dUserName', title: '用户名'}
		        ,{field:'dImgUrl', title: '头像',unresize: true,templet:'<div><img src="{{ d.dImgUrl}}"></div>'}
		        ,{field:'dLoginName', title: '登录用户名'}
		        ,{field:'dSex', title: '性别'}
		        ,{field:'dEmail', title: '邮箱'}
		        ,{field:'dPhone', title: '手机号'}
		        ,{field:'userRole', title: '用户角色'}
		        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
		      ]]
		      ,page: true
		    });
			
			//表格头部工具条事件
		    table.on('toolbar(fuser)',function(obj){
		    	if(obj.event=== 'addUser'){
		    		layer.open({
		    			title : '新增用户'
		    			,type : 2
		    			,maxmin : true
		    			,area : ['850px', '620px']
		    			,content : 'addduser.jsp'
		    		})
		    	}
		    });
			
			//表格操作事件
		    table.on('tool(fuser)',function(obj){
		    	var data = obj.data;
		    	if(obj.event === 'del'){
		    		layer.confirm('真的删除行么', function(index){
		    			$.ajax({
		    				url:"${pageContext.request.contextPath}/manage/duser/"+data.id,
		    				type:"DELETE",
		    				timeout:5000,
		    				async: false,
		    				success:function(data){
		    					if(data.msg === '删除成功'){
		    		    	        obj.del();
		    		    	        layer.close(index);
		    						layer.msg('刪除成功');
		    					}else{
		    						layer.msg('删除失败：'+data.msg);
		    					}
		    				}
		    			})
		    	      });
		    	}else if(obj.event === 'edit'){
		    		$.ajax({
		    			url:"${pageContext.request.contextPath}/manage/duser/"+data.id,
		    			type:"GET",
		    			timeout:5000,
		        		dataType:'json',
		        		success:function(data){
		        			if(data != null){
		        				layer.open({
		        					title : "更新管理员"
		        					,type : 2
		        					,maxmin : true
		        					,area : ['850px', '620px']
		        					,content : 'updateduser.jsp'
		        					,success : function(layero, index){
		        						 //得到iframe页的body内容
		        						 var body = layer.getChildFrame('body', index);
		        						 //向iframe表单刷新数据
		        						 body.find("input[name='id']").val(data.id)
		        						 body.find("input[name='dUserName']").val(data.dUserName)
		        						 body.find("input[name='dLoginName']").val(data.dLoginName)
		        						 body.find("input[name='dPhone']").val(data.dPhone)
		        						 body.find("input[name='dEmail']").val(data.dEmail)
		        						 body.find("input[name='dSex'][value=男]").attr("checked", data.dSex == '男' ? true : false)
		        						 body.find("input[name='dSex'][value=女]").attr("checked", data.dSex == '女' ? true : false)
		        						  body.find("select[name='userRole']").find("option[value='"+data.userRole+"']").attr("selected",true);
		        						 form.render();
		        					}
		        				})
		        			}
		        		}		    			
		    		})
		    	}
		    })
			

			var $ = layui.$, active = {
				reload : function() {
					//获取管理员昵称
					var dUserName = null;
					dUserName = $("input[name='dUserName']").val();
					//获取用户角色
					var userRole = null;
					userRole = $("select[name='userRole']").val();
					//执行重载
					table.reload('test-table-reload', {
						page : {
							curr : 1
						//重新从第 1 页开始
						},
						where : {
							dUserName : dUserName
							,userRole : userRole
						}
					});
				}
			};

			$('.test-table-reload-btn .layui-btn').on('click', function() {
				var type = $(this).data('type');
				active[type] ? active[type].call(this) : '';
			});
			//文件上传
			upload.render({
    		    elem: '#import'
    		    ,url: '${pageContext.request.contextPath}/manage/importUser'
    		    ,before: function(obj){
    		      //预读本地文件示例，不支持ie8
    		      obj.preview(function(index, file, result){
    		        $('#demo1').attr('src', result); //图片链接（base64）
    		      });
    		    }
    		    ,done: function(res){
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