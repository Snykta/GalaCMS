<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cms.dao.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
</head>
<body>
<%
	String uname = request.getParameter("usera");
	UserDao u = new UserDao();
	int a =u.deleteUser(uname);
	if(a>0){
		out.println("<script>alert('删除成功！');window.location.href='userList.jsp';</script>");
	}else{
		out.println("<script>alert('删除失败！');window.location.href='userList.jsp';</script>");
	}
%>
</body>
</html>