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
      <div class="layui-card-header">新增用户</div>
      <div class="layui-card-body layui-form" style="padding: 15px;">
          <div class="layui-form-item">
            <label class="layui-form-label">用户名称</label>
            <div class="layui-input-block">
              <input type="text" name="fUserName" class="layui-input" disabled>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">登录名称</label>
            <div class="layui-input-block">
              <input type="text" name="fLoginname" class="layui-input" disabled>
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
              <input type="radio" name="fSex" value="男" title="男" disabled>
              <input type="radio" name="fSex" value="女" title="女" disabled>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">年龄</label>
              <div class="layui-input-inline">
                <input type="tel" name="fAge" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">手机号码</label>
              <div class="layui-input-inline">
                <input type="tel" name="fPhone" class="layui-input" disabled>
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="text" name="fEmail" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">联系地址</label>
              <div class="layui-input-inline">
                <input type="tel" name="fAddress" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">是否是VIP</label>
              <div class="layui-input-inline" >
                <select name="fIsvip" disabled>
                	<option value="是">是</option>
                	<option value="否">否</option>
                </select>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">VIP起始时间</label>
              <div class="layui-input-inline">
              	<input type="text" name="fVipbegittime" class="layui-input" disabled>
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">VIP结束时间</label>
              <div class="layui-input-inline">
              	<input type="text" name="fVipendtime" class="layui-input" disabled>
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
    
    /* 自定义验证规则 */
    form.verify({
    	fUserName: function(value){
        if(value.length < 2){
          return '用户名称至少得2个字符啊';
        }
      }
      ,fLoginname:function(value){
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
    	console.log(user)
    	var id = $("input[name='id']").val();
    	$.ajax({
    		url:"${pageContext.request.contextPath}/manage/user",
    		data : user,
    		type:"POST",
    		async:true, //开启异步
    		timeout:5000,
    		dataType:'json',
    		success:function(data){
    			if(data.msg === "添加成功"){
    				layer.confirm('是否继续添加?',{
    					ioc : 1
    					,title : '提示'
    					,btn : ['是','否']
    				},function(index,layero){
    					//继续添加
    					layer.close(index);
    					$("#user-form")[0].reset()
    				},function(index){
    					//否,关闭
    					layer.close(index);
    					//关闭弹出层
    					var addUserIndex = parent.layer.getFrameIndex(window.name);
    					parent.layer.close(index)
    				})
    			}else{
    				layer.confirm('新增失败:'+data.msg,{
    					ioc : 2
    					,title : '提示'
    					,btn : ['是','否']
    				},function(index,layero){
    					//继续添加
    					layer.close(index);
    					$("#user-form")[0].reset()
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
  });
  </script>
</body>
</html>
