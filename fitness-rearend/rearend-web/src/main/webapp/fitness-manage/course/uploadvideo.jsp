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
		<div class="layui-upload">
			<input type="hidden" name="cid">
			<button type="button" class="layui-btn layui-btn-sm" id="testList">
				<i class="layui-icon">&#xe654;添加视频</i>
			</button>
			<div class="layui-upload-list">
				<table class="layui-table">
					<thead>
						<tr>
							<th>文件名</th>
							<th>大小</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody id="demoList"></tbody>
				</table>
			</div>
			<button type="button" class="layui-btn" id="testListAction">开始上传</button>
		</div>
	</div>
	</div>
	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script>
  layui.config({
	    base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index','layer','upload'], function(){
	    var $ = layui.jquery
	    ,admin = layui.admin
	    ,element = layui.element
	    ,layer = layui.layer
		,upload = layui.upload	    
	    
		var cid = $("input[name='cid']").val()//获取cid
		
	  //多文件伤上传列表
	    var demoListView = $('#demoList')
	    ,uploadListIns = upload.render({
	      elem: '#testList'
	      ,url: '${pageContext.request.contextPath}/manage/uploadvideo?cid='+cid
	      ,accept: 'file'
	      ,multiple: true
	      ,auto: false
	      ,bindAction: '#testListAction'
	      ,choose: function(obj){   
	        var files = obj.pushFile(); //将每次选择的文件追加到文件队列
	        //读取本地文件
	        obj.preview(function(index, file, result){
	          var tr = $(['<tr id="upload-'+ index +'">'
	            ,'<td>'+ file.name +'</td>'
	            ,'<td>'+ (file.size/1014).toFixed(1) +'kb</td>'
	            ,'<td>等待上传</td>'
	            ,'<td>'
	              ,'<button class="layui-btn layui-btn-xs demo-reload layui-hide">重传</button>'
	              ,'<button class="layui-btn layui-btn-xs layui-btn-danger demo-delete">删除</button>'
	            ,'</td>'
	          ,'</tr>'].join(''));
	          
	          //单个重传
	          tr.find('.demo-reload').on('click', function(){
	            obj.upload(index, file);
	          });
	          
	          //删除
	          tr.find('.demo-delete').on('click', function(){
	            delete files[index]; //删除对应的文件
	            tr.remove();
	            uploadListIns.config.elem.next()[0].value = ''; //清空 input file 值，以免删除后出现同名文件不可选
	          });
	          
	          demoListView.append(tr);
	        });
	      }
	      ,done: function(res, index, upload){
	        if(res.code == 0){ //上传成功
	        	layer.msg('上传成功', {icon: 1});
        		var index = parent.layer.getFrameIndex(window.name);  
				setTimeout(function(){
					parent.layer.close(index);//关闭弹出层
					parent.location.reload();//更新父级页面（提示：如果需要跳转到其它页面见下文）
				}, 2000);				
        	}
	      }
	      ,error: function(index, upload){
	        var tr = demoListView.find('tr#upload-'+ index)
	        ,tds = tr.children();
	        tds.eq(2).html('<span style="color: #FF5722;">上传失败</span>');
	        tds.eq(3).find('.demo-reload').removeClass('layui-hide'); //显示重传
	      }
	    });
	  });
  </script>
</body>
</html>
