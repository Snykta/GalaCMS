<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Internship Sign In & Sign Up Form Responsive Widget,Login form widgets, Sign up Web forms , Login signup Responsive web form,Flat Pricing table,Flat Drop downs,Registration Forms,News letter Forms,Elements" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/snow.css" rel="stylesheet"/>
<link href="/GalaCMS/css/style2.css" rel="stylesheet"/>
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
<a href="login.jsp"  class="active">登录</a><a href="register.jsp">注册</a>
</div>
<h1>用户登陆
</h1>
<div class="main-agileits">
<!--form-stars-here-->
		<div class="form-w3-agile">
			<!-- <h2 class="sub-agileits-w3layouts">登录</h2> -->
			<form action="CheckLogin" method="post" autocomplete="off">
					<input type="text" name="users" placeholder="账号"  title="请输入4-6位大小写或数字与组合" pattern="[a-zA-Z0-9_-]{4,6}" required />
					<input type="password" name="pass" placeholder="密码" title="请输入6-16位密码" pattern="[\w_-]{6,16}" required />
					<input type="text" name="keys" placeholder="验证码" style="width: 130px;margin-left: -175px"  title="请输入4位的验证码" pattern="[a-zA-Z0-9_-]{4}" required>
					<img id="imgs" style="margin-left: 30px;position:relative;top:18px" src="/GalaCMS/Buffere" onclick="changImg()">
					<a href="javascript:void(0)" style="color: white;font-size: 13px;position:relative;top:13px" onclick="changImg()">看不清,换一张</a>
					<a href="#" class="forgot-w3layouts">忘记密码 ?</a>
				<div class="submit-w3l">
					<input type="submit" value="登录">
				</div>
				<p class="p-bottom-w3ls"><a href="register.jsp">点击注册</a>还没有账号？</p>
				<p class="p-bottom-w3ls"><a href="quickLogin.jsp">一键登录</a></p>
			</form>
		</div>
		</div>
	<div class="copyright w3-agile" style="margin-top: -20px">
		<p> © 莱莱CMS管理系统</a></p>
	</div>
<script type="text/javascript">
function changImg() {
	document.getElementById("imgs").src="/GalaCMS/Buffere?"+new Date().getTime();
}
</script>
</body>
</html>