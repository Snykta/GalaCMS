<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cms.dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<li><a href="#">编辑新闻类别</a></li>
</ul>
</div>


<%
NewsDao nd = new NewsDao();
List lists = nd.newsList();
pageContext.setAttribute("lists", lists);
%>


<div class="tools" style="margin-left: 20px;margin-top: 15px">
<ul class="toolbar">
<c:forEach items="${lists }" var="nlist">
<li style="margin-top: 5px"><span><img src="${pageContext.servletContext.contextPath}/images/t03.png"/></span>${nlist.news_type}</li>
<br>

</c:forEach>

</ul>

</div>


</body>
</html>