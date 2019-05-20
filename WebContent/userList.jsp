<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cms.bean.*" %>
<%@ page import="com.cms.dao.*" %>
<%@ page import="java.util.List" %>
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
<li><a href="#">用户管理</a></li>
<li><a href="#">用户列表</a></li>
</ul>
</div>
    <div class="tools" style="margin-top: 10px;margin-left: 10px">
    
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="addUser.jsp">添加</a></li>
        <li class="click"><span><img src="images/t02.png" /></span><a href="redactUser.jsp">修改</a></li>
        <li><span><img src="images/t03.png" /></span><a href="#">删除</a></li>
        <li><span><img src="images/t04.png" /></span><a href="#">统计</a></li>
        </ul>
    </div>
<ul class="imglist">
<%
UserDao ud = new UserDao();
List<User> userLists = ud.getAllUsers();
pageContext.setAttribute("list", userLists);
%>
<c:forEach items="${list }" var="good">
	<li class="selected">
	<span style="margin-left: 61px">
	<img src="${pageContext.servletContext.contextPath}/images/i07.png"/>
	</span>
	<h2><a href="MesUser.jsp?mesg=<c:out value="${good.uuser}"></c:out>"><c:out value="${good.uuser}"></c:out></a></h2>
	<p><a href="MesUser.jsp?mesg=<c:out value="${good.uuser}"></c:out>">查看</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteUser.jsp?usera=<c:out value="${good.uuser}"></c:out>">删除</a></p>
	</li>
</c:forEach>


</ul>
   <div class="pagin">
    	<div class="message">共<i class="blue" style="display: inline;"><%=userLists.size() %></i>条记录，当前显示第&nbsp;<i class="blue" style="display: inline;">1&nbsp;</i>页</div>
        <ul class="paginList">
        <li class="paginItem"><a href="javascript:;"><span class="pagepre"></span></a></li>
        <li class="paginItem  current"><a href="javascript:;">1</a></li>
        <li class="paginItem"><a href="javascript:;">2</a></li>
        <li class="paginItem"><a href="javascript:;">3</a></li>
        <li class="paginItem"><a href="javascript:;">4</a></li>
        <li class="paginItem"><a href="javascript:;">5</a></li>
        <li class="paginItem more"><a href="javascript:;">...</a></li>
        <li class="paginItem"><a href="javascript:;">10</a></li>
        <li class="paginItem"><a href="javascript:;"><span class="pagenxt"></span></a></li>
        </ul>
    </div>

</body>
</html>