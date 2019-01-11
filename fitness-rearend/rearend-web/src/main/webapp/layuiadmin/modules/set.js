/**

 @Name：layuiAdmin（iframe版） 设置
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL
    
 */
 
layui.define(['form', 'upload'], function(exports){
  var $ = layui.$
  ,layer = layui.layer
  ,laytpl = layui.laytpl
  ,setter = layui.setter
  ,view = layui.view
  ,admin = layui.admin
  ,form = layui.form
  ,upload = layui.upload;

  var $body = $('body');
  
  //自定义验证
  form.verify({
    nickname: function(value, item){ //value：表单的值、item：表单的DOM对象
      if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
        return '用户名不能有特殊字符';
      }
      if(/(^\_)|(\__)|(\_+$)/.test(value)){
        return '用户名首尾不能出现下划线\'_\'';
      }
      if(/^\d+\d+\d$/.test(value)){
        return '用户名不能全为数字';
      }
    }
    
    //我们既支持上述函数式的方式，也支持下述数组的形式
    //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
    ,pass: [
      /^[\S]{6,16}$/
      ,'密码必须6到16位，且不能出现空格'
    ]
    
    //确认密码
    ,repass: function(value){
      if(value !== $('#LAY_password').val()){
        return '两次密码输入不一致';
      }
    }
  });
  
  //网站设置
  form.on('submit(set_website)', function(obj){
		layer.confirm('您确定保存要修改网站信息吗？', {
		    btn: ['确定','取消'] //按钮
		  }, function(){
			  $.post("setWebsite.do", obj.field, function(data) {
		    		if(data === "success"){
		    			layer.alert("修改成功~",{time:2000},function(){
		    				$(window.parent.location.reload());
		    			});
		    		}else{
		    			layer.alert("发生错误，修改失败，请稍候重试~",{time:2000,icon:5},function(){
		    				$(window.parent.location.reload());
		    			});
		    		}
		    	}, "text");
		  }, function(){
			  window.location.reload();
		});
    return false;
  });
  
  
  // 设置资料点击编辑，取消效果。
  $("#editBtn").on("click",function(){
	 $(":input").removeProp("readonly");
	 $(":radio,button,button:hidden").removeProp("disabled").removeClass("layui-btn-disabled").removeClass("layui-hide");
	 form.render();
  });
  
  //设置我的资料
  form.on('submit(setmyinfo)', function(obj){
	  layer.confirm('您确定保存要修改个人信息吗？', {
	    btn: ['肯定啊','算了算了'] //按钮
	  }, function(){
		  $.post("setInfo.do", obj.field, function(data) {
	    		if(data === "success"){
	    			layer.alert("修改成功~",{time:2000},function(){
	    				$(window.parent.location.reload());
	    			});
	    		}else{
	    			layer.alert("发生错误，修改失败，请稍候重试~",{time:2000,icon:5},function(){
	    				$(window.parent.location.reload());
	    			});
	    		}
	    	}, "text");
	  }, function(){
		  window.location.reload();
	  });
    return false;
  });

  //上传头像
  var avatarSrc = $('#LAY_avatarSrc');
  upload.render({
    url: 'uploadUserImg.do',
    elem: '#LAY_avatarUpload',
    type: "post",
    done: function(res){
      if(res.code == 0){
    	$(window.parent.document).find("#userHeadImg").attr("src",res.data);
    	layer.msg("头像上传成功,点击可查看新头像。",{time:2000});
        avatarSrc.val(res.data);
      } else {
        layer.msg(res.msg, {icon: 5});
      }
    }
  });
  
  
  //查看头像
  admin.events.avartatPreview = function(othis){
    var src = avatarSrc.val();
    layer.photos({
      area: ['500px'],
      photos: {
        "title": "查看头像", //相册标题
        "data": [{
          "src": src //原图地址
        }]
      }
      ,shade: 0.01
      ,closeBtn: 1
      ,anim: 5
    });
  };
  
  
  //设置密码
  form.on('submit(setmypass)', function(obj){
    var val = obj.field;
    // 发送ajax异步请求。
    $.post("setPassword.do",val,function(data){
    	if (data === "error") {
    		$("#oldPassword").focus();
    		$("#oldPassword").select();
    		layer.msg("修改密码错误，请检查正确的原密码。", {
    		  time:2000,
    		  anim: 6
    		});
		}else if(data === "fail"){
			layer.alert('密码必须为6-16之间，不能出现空格；并且两次密码必须一致请进行检查。', {
				  skin: 'layui-layer-molv', //样式类名
				  closeBtn: 0,
				  title:"修改结果提示",
				  anim:5,
				  icon:5
			});
		}else{
			layer.msg("修改成功！",{time:1000,anim: 1},function(){
				window.parent.location.href = "../../login.html";
			})
		}
    },"text");
    
    return false;
  });
  
  //对外暴露的接口
  exports('set', {});
});