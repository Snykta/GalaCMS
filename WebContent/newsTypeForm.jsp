<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
</head>
<body>
<div class="place">
<span>位置：</span>
<ul class="placeul">
<li><a href="#">首页</a></li>
<li><a href="#">新闻类别管理</a></li>
<li><a href="#">添加新闻类别</a></li>
</ul>
</div>
<div class="formtitle">
<span>基本信息</span>
</div>
<form action="AddNews_type" method="post" autocomplete="off">
<ul class="forminfo">
<li><label>新闻类别</label><input type="text" name="newstype_type" class="dfinput"/><i></i></li>
<li><label>&nbsp;</label><input type="submit" value="确认保存" class="btn"/></li>
</ul>
</form>
</body>
</html>