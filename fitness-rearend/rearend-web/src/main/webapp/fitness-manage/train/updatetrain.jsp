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
      <div class="layui-card-header">更新教练</div>
      <div class="layui-card-body" style="padding: 15px;">
        <form class="layui-form" action="" lay-filter="updatetrain-from" method="post" id="train-form">
          <div class="layui-form-item">
            <label class="layui-form-label">教练名称</label>
            <div class="layui-input-block">
              <input type="hidden" name="id">
              <input type="text" name="tUsername" lay-verify="tUsername" autocomplete="off" placeholder="请输入用户名称" class="layui-input">
            </div>
          </div>
          <div class="layui-form-item">
            <label class="layui-form-label">登录名称</label>
            <div class="layui-input-block">
              <input type="text" name="tLoginname" lay-verify="required|tLoginname" placeholder="请输入登录名称" autocomplete="off" class="layui-input">
            </div>
          </div>
           <div class="layui-form-item">
            <label class="layui-form-label">登录密码</label>
            <div class="layui-input-block">
              <input type="text" name="tPassword" lay-verify="required|pass" placeholder="请输入登录密码" autocomplete="off" class="layui-input">
            </div>
          </div>
          
          <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">手机号码</label>
              <div class="layui-input-inline">
                <input type="tel" name="tPhone" lay-verify="required|phone" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">邮箱</label>
              <div class="layui-input-inline">
                <input type="text" name="tEmail" lay-verify="email" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
          <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">联系地址</label>
              <div class="layui-input-inline">
                <input type="tel" name="tAddress" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
          
          <div class="layui-form-item">
            <label class="layui-form-label">单选框</label>
            <div class="layui-input-block">
              <input type="radio" name="tSex" value="男" title="男" checked="">
              <input type="radio" name="tSex" value="女" title="女">
            </div>
          </div>
            <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">年龄</label>
              <div class="layui-input-inline">
                <input type="tel" name="tAge" lay-verify="required" autocomplete="off" class="layui-input">
              </div>
            </div>
          </div>
           <div class="layui-form-item">
          	 <div class="layui-inline">
              <label class="layui-form-label">是否被预约</label>
              <div class="layui-input-inline" >
                <select name="tIsvip">
                	<option value="是">是</option>
                	<option value="否">否</option>
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
    	tUserName: function(value){
        if(value.length < 2){
          return '用户名称至少得2个字符啊';
        }
      }
      ,tLoginname:function(value){
    	  if(value.length < 5){
              return '用户名称至少得5个字符啊';
            }
      }
      ,pass: [/(.+){6,12}$/, '密码必须6到12位']
      ,content: function(value){
        layedit.sync(editIndex);
      }
    });
    form.on('radio', function(data){
    	alert(data.value)
    	});
    
    
    /* 监听提交 */
    form.on('submit(updatetrain-from)', function(data){
    	var train = $("#train-form").serialize();
    	console.log(train);
    	var id = $("input[name='id']").val()
    	$.ajax({
    		url:"${pageContext.request.contextPath}/manage/train/"+id,
    		data:train,
    		type:"PUT",
    		async:true, //开启异步
    		timeout:5000,
    		dataType:'json',
    		success:function(data){
    			if(data.msg === "修改成功"){
    	        	layer.msg('修改成功', {icon: 1});
            		var index = parent.layer.getFrameIndex(window.name);  
    				setTimeout(function(){
    					parent.layer.close(index);//关闭弹出层
    					parent.location.reload();//更新父级页面（提示：如果需要跳转到其它页面见下文）
    				}, 2000);	
    			}else{
    				layer.confirm(data.msg,{
    					ioc : 2
    					,title : '提示'
    					,btn : ['是']
    				},function(index, layero){
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
