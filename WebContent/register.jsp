<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cms.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/snow.css" rel="stylesheet" type="text/css" media="all" />
<link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<body>
<div class="snow-container">
			  <div class="snow foreground"></div>
			  <div class="snow foreground layered"></div>
			  <div class="snow middleground"></div>
			  <div class="snow middleground layered"></div>
			  <div class="snow background"></div>
			  <div class="snow background layered"></div>
			</div>

<div class="top-buttons-agileinfo">
<a href="login.jsp">登录</a><a href="register.jsp" class="active">注册</a>
</div>
<h1 style="margin-top: -60px">用户注册</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<!-- <h2 class="sub-agileits-w3layouts">注册</h2> -->
			<form style="margin-top: -20px" action="CheckRegister" method="post" autocomplete="off">
				<input type="text" name="Username" placeholder="昵称"  title="请输入中文昵称" pattern="[\u4E00-\u9FA5]{1,6}" required  />
					<input type="text" name="User1" placeholder="账号"  title="请输入4-6位大小写或数字与组合" pattern="[a-zA-Z0-9_-]{4,6}" required  />
					
					<input type="text" id="eaml" name="emils" placeholder="邮箱"  title="请输入邮箱号码" pattern="[1-9]\d{7,10}@qq\.com" required  />
					<input type="text" name="keys" placeholder="验证码" style="width: 100px;position: relative;left:-219px;margin-top: -20px"  title="请输入4位的验证码" pattern="[a-zA-Z0-9_-]{4}" required>
					<div class="submit-w3l">
					<input type="button" id="fayan" value="发送验证码"/>
				    </div>
				    
					<input type="password" id="pa1" name="Password" placeholder="密码" title="请输入6-16位密码" pattern="[\w_-]{6,16}" required />
					<input type="password" id="pa2" name="Password2" placeholder="确认密码" title="请输入6-16位密码" pattern="[\w_-]{6,16}" required  />
				<div class="submit-w3l">
					<input type="submit" value="注册" onclick="pu2()"/>
				</div>
			</form>
		</div>
		</div>
	<div class="copyright w3-agile" style="margin-top: -45px">
		<p>© 莱莱CMS管理系统</a></p>
	</div>
	<script type="text/javascript">
	function pu2() {
		var pal = false;
		var pass1 = $('#pa1').val();
		var pass2 = $('#pa2').val();
		if(pass1==pass2){
			pal = true;
		}else{
			alert("密码不一致");
		}
		return pal;
	}
	var ding = 60;
	var timer = null;
	$('#fayan').click(function() {
		if($('#eaml').val().trim().length==0){
			alert("请先输入邮箱!");
		}else{
			$('#fayan').css({
				"background":"#A3A3A3",
				"color":"#515151"})
			$('#fayan').attr('disabled',true);
			timer = setInterval("f()",1000);
			$.ajax({
	    	    url : "/GalaCMS/CheckRegister",
	    	    type : "get",
	    	    data : {
	                "youxiang" : $("#eaml").val(),
	            },
	    	    success : function (s) {
	    	  }
	       })
	    
		}
		
	})
	
	 function f() {
        $('#fayan').attr("value",--ding+"秒后获取");
        if(ding==50){
        	$('#fayan').css({
				"background":"#fff",
				"color":"#000"})
            $('#fayan').attr('disabled',false);
            $('#fayan').attr("value","获取验证码");
            clearInterval(timer);
            ding = 60;
        }
    }
	
	</script>
</body>
</html>