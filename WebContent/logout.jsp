<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//Map m = (Map) application.getAttribute("courent");//获取全局对象
//String sess = session.getAttribute("lname").toString();
//m.remove(sess);
//session.removeAttribute("lname");
session.invalidate();//销毁

response.sendRedirect("login.jsp");
%>
</body>
</html>