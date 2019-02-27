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
      <div class="layui-card-header">新增教练</div>
      <div class="layui-card-body layui-form" style="padding: 15px;">
          <div class="layui-form-item">
            <label class="layui-form-label">教练名称</label>
            <div class="layui-input-block">
              <input type="text" name="tUsername" class="layui-input" disabled>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">登录名称</label>
            <div class="layui-input-block">
              <input type="text" name="tLoginname" class="layui-input" disabled>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
              <input type="radio" name="tSex" value="男" title="男" disabled>
              <input type="radio" name="tSex" value="女" title="女" disabled>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">年龄</label>
              <div class="layui-input-inline">
                <input type="tel" name="tAge" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">手机号码</label>
              <div class="layui-input-inline">
                <input type="tel" name="tPhone" class="layui-input" disabled>
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="text" name="tEmail" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">联系地址</label>
              <div class="layui-input-inline">
                <input type="tel" name="tAddress" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">是否是被预约</label>
              <div class="layui-input-inline" >
                <select name="tIsvip" disabled>
                	<option value="是">是</option>
                	<option value="否">否</option>
                </select>
              </div>
            </div>
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
  }).use(['index', 'form', 'laydate','layer'], function(){
    var $ = layui.$
    ,admin = layui.admin
    ,element = layui.element
    ,layer = layui.layer
    ,laydate = layui.laydate
    ,form = layui.form
    ,layer = layui.layer;
    
    form.render(null, 'component-form-group');
    form.render('select');
    laydate.render({
      elem: '#LAY-component-form-group-date'
    });
    
  });
  </script>
</body>
</html>
