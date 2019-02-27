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
				<form class="layui-form" action="" lay-filter="addcourse-from"
					method="post" id="course-form" >
					<div class="layui-form-item">
						<label class="layui-form-label">课程名称</label>
						<div class="layui-input-block">
							<input type="text" name="cName" lay-verify="required|cName"
								autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<label class="layui-form-label">是否VIP可看</label>
							<div class="layui-input-inline">
								<select name="cIsvip">
									<option value="是">是</option>
									<option value="否">否</option>
								</select>
							</div>
						</div>
					</div>
							<div style=" text-align: center;">
								<button class="layui-btn" lay-submit=""
									lay-filter="component-form-demo1"">保存</button>
							</div>
				</form>
				<div class="layui-upload">
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
	</div>
	<script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>
	<script>
  layui.config({
	    base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
	  }).extend({
	    index: 'lib/index' //主入口模块
	  }).use(['index', 'form', 'laydate','layer','upload'], function(){
	    var $ = layui.jquery
	    ,admin = layui.admin
	    ,element = layui.element
	    ,layer = layui.layer
	    ,laydate = layui.laydate
	    ,form = layui.form
		,upload = layui.upload	    
	    
	    /* 自定义验证规则 */
	    form.verify({
	    	cName: function(value){
	        if(value.length < 2){
	          return '教程名称至少得2个字符啊';
	        }
	      }
	    });
	    
	 	 /* 监听提交 */
	   form.on('submit(addcourse-from)', function(data){
	    	var user = $("#course-form").serialize();
	    	console.log(user)
	    	$.ajax({
	    		url:"${pageContext.request.contextPath}/manage/course",
	    		data : user,
	    		type:"POST",
	    		async:true, //开启异步
	    		timeout:5000,
	    		dataType:'json',
	    		success:function(data){
	    			if(data.msg === "添加成功"){
	    				layer.confirm('添加成功,请添加视频文件')
	    			}else{
	    				layer.confirm(data.msg+":勿要添加视频!",{
	    					ioc : 2
	    					,title : '提示'
	    					,btn : ['是','否']
	    				},function(index,layero){
	    					//继续添加
	    					layer.close(index);
	    					$("#train-form")[0].reset()
	    				},function(index){
	    					//否,关闭
	    					layer.close(index);
	    					//关闭弹出层
	    					var addUserIndex = parent.layer.getFrameIndex(window.name);
	    					parent.layer.close(index)
	    				})
	    			}
	    		}
	    	})
	    	return false;
	    });
	  
	  //多文件列表示例
	    var demoListView = $('#demoList')
	    ,uploadListIns = upload.render({
	      elem: '#testList'
	      ,url: '${pageContext.request.contextPath}/manage/uploadvideo'
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
