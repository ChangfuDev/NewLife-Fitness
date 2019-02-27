<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>更新用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/layuiadmin/style/admin.css" media="all">
</head>
<body>
  <div class="layui-fluid">
    <div class="layui-card">
      <div class="layui-card-header">新增管理员</div>
      <div class="layui-card-body" style="padding: 15px;">
        <form class="layui-form" action="" lay-filter="updateuser-from" method="post" id="user-form">
          <div class="layui-form-item">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-block">
              <input type="hidden" name="id">
              <input type="text" name="dUserName" lay-verify="dUserName" autocomplete="off" placeholder="请输入用户名称" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">登录名称</label>
            <div class="layui-input-block">
              <input type="text" name="dLoginName" lay-verify="required|dLoginName" placeholder="请输入登录名称" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">登录密码</label>
            <div class="layui-input-block">
              <input type="text" name="dPassWord" lay-verify="required|pass" placeholder="请输入登录密码" autocomplete="off" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">手机号码</label>
              <div class="layui-input-inline">
                <input type="tel" name="dPhone" lay-verify="required|phone" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="text" name="dEmail" lay-verify="email" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
              <input type="radio" name="dSex" value="男" title="男" checked="">
              <input type="radio" name="dSex" value="女" title="女">
            </div>
          </div>
		<div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">管理员角色</label>
              <div class="layui-input-inline" >
                <select name="userRole" >
                	<option value="0">超级管理员</option>
                	<option value="1">普通管理员</option>
                </select>
              </div>
            </div>
          </div>
          <div class="layui-form-item layui-layout-admin">
            <div class="layui-input-block">
              <div class="layui-footer" style="left: 0;">
                <button class="layui-btn" lay-submit="" lay-filter="component-form-demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>

    
  <script src="${pageContext.request.contextPath }/layuiadmin/layui/layui.js"></script>  
  <script>
  layui.config({
    base: '${pageContext.request.contextPath }/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'form', 'laydate','layer'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,layer = layui.layer
    ,laydate = layui.laydate
    ,form = layui.form
    ,layer = layui.layer;
    
    form.render(null, 'component-form-group');

    laydate.render({
      elem: '#LAY-component-form-group-date'
    });
    
    /* 自定义验证规则 */
    form.verify({
    	dUserName: function(value){
        if(value.length < 2){
          return '用户名称至少得2个字符啊';
        }
      }
      ,dLoginName:function(value){
    	  if(value.length < 5){
              return '用户名称至少得5个字符啊';
            }
      }
      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
      ,content: function(value){
        layedit.sync(editIndex);
      }
    });
    
    /* 监听提交 */
    form.on('submit(updateuser-from)', function(data){
    	var user = $("#user-form").serialize();
    	console.log(user);
    	var id = $("input[name='id']").val();
    	$.ajax({
    		url:"${pageContext.request.contextPath}/manage/duser",
    		data:user,
    		type:"POST",
    		async:true, //开启异步
    		timeout:5000,
    		dataType:'json',
    		success:function(data){
    			if(data.msg === "新增成功"){
    	        	layer.msg(data.msg, {icon: 1});
            		var index = parent.layer.getFrameIndex(window.name);  
    				setTimeout(function(){
    					parent.layer.close(index);//关闭弹出层
    					parent.location.reload();//更新父级页面（提示：如果需要跳转到其它页面见下文）
    				}, 2000);	
    			}else{
    				layer.confirm(data.msg)
    					var index = parent.layer.getFrameIndex(window.name);  
					setTimeout(function(){
						parent.layer.close(index);//关闭弹出层
						parent.location.reload();//更新父级页面（提示：如果需要跳转到其它页面见下文）
					}, 2000);	
    					
    				}
    			}
    		})
    		return false;
    	})
    	
  });
  
  
  </script>
</body>
</html>
