<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>新增用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
</head>
<body>
   <div class="layui-fluid">
    <div class="layui-card">
      <div class="layui-card-header">Test</div>
      <div class="layui-card-body layui-form" style="padding: 15px;">
      	<form class="layui-form" action="" lay-filter="addtrain-from" method="post" id="train-form">
          <div class="layui-form-item">
            <label class="layui-form-label">ID</label>
            <div class="layui-input-block">
              <input type="text" name="id"  class="layui-input" >
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">课程名称</label>
            <div class="layui-input-block">
              <input type="text" name="cName" lay-verify="required|cName" placeholder="请输入课程名称" autocomplete="off" class="layui-input" >
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">是否VIP可看</label>
              <div class="layui-input-inline" >
                <select name="tIsvip" >
                	<option value="是">是</option>
                	<option value="否">否</option>
                </select>
              </div>
            </div>
          </div>
          </form>
      </div>
      <table class="layui-hide" id="test-table-reload" lay-filter="coursevideo"></table>
    </div>
  </div>
    <script type="text/html" id="course-video-toolbar">
		<div class="layui-btn-container">
   			<button class="layui-btn layui-btn-sm" lay-event="addCourseVideo">新增视频</button>
 		</div>
    </script>
    <script type="text/html" id="barDemo">
  		<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
    
  <script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['table', 'layer'], function(){
    var $ = layui.$
    ,layer = layui.layer
    ,table = layui.table;
    
	var id = $("input[name='id']").val();
    	table.render({
    		 elem:'#test-table-reload'
    		 ,height:480
    		 ,cellMinWidth:80
    		 ,toolbar:"#course-video-toolbar"
    		 ,url : "/rearend-web/manage/getcoursevideos?cid="+id
    		 ,cols: [[
		        {field:'id', title: 'id', sort: true, fixed: true}
		        ,{field:'title', title: '视频名称'}
		        ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
		      ]]
    		 ,page:true
    	});
    	
    	
    	/*监听删除*/
    	table.on('tool(coursevideo)',function(obj){
    		var data = obj.data;
    		if(obj.event === 'del'){
    	    	$.ajax({
    	    		url:"${pageContext.request.contextPath}/manage/course/courseVideo/"+data.id,
    	    		type:"POST",
    	    		async:true, //开启异步
    	    		timeout:5000,
    	    		dataType:'json',
    	    		success:function(data){
    	    			if(data.msg === "删除成功"){
    	    				layer.confirm(data.msg);
    	    			}else{
    	    				layer.confirm(data.msg)
    	    			}
    	    		}
    	    	})
    			obj.del();
	    	    layer.close(index);
				layer.msg('刪除成功');
    		}
    	});
    	
    	//表格头部工具条事件
	    table.on('toolbar(coursevideo)',function(obj){
	    	if(obj.event=== 'addCourseVideo'){
	    		layer.open({
	    			title : '新增视频'
	    			,type : 2
	    			,maxmin : true
	    			,area : ['600px', '400px']
	    			,content : 'uploadvideo.jsp'
	    				,success : function(layero, index){
   						 //得到iframe页的body内容
   						 var body = layer.getChildFrame('body', index);
   						 //向iframe表单刷新数据
   						 body.find("input[name='cid']").val(id)
   					}
	    		})
	    	}
	    });
    	
  });
  </script>
</body>
</html>
