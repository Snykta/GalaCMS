<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cms.dao.*" %>
<%@ page import="com.cms.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        li{
            list-style: none;
            line-height: 50px;
            color: #8B008B;
            font-size: 18px;
            display: inline;
        }
        ul{
            margin-left: 100px;
            margin-top: 30px;
        }
        span{
            font-size: 14px;
            color: #009f95;
            font-weight: bold;
        }
        a{
            text-decoration: none;
            color: white;
            background: #009f95;
            width: 70px;
            height: 30px;
            text-align: center;
            line-height: 30px;
            border-radius: 50%;
            display: block;
            margin-top: 20px;
        }
        a:hover{
            background: #df5799;
        }
    </style>
</head>
<body>
<%
	String mesg = request.getParameter("mesg");
	UserDao ud = new UserDao();
	User u = ud.MesUser(mesg);
%>
<p style="margin-left: 20px;margin-top: 10px"><a href="userList.jsp">返&nbsp;&nbsp;&nbsp;&nbsp;回</a></p>
<ul>
    <li>昵称：</li><span><%=u.getUname() %></span><br>
    <li>账号：</li><span><%=u.getUuser() %></span><br>
    <li>密码：</li><span><%=u.getUpassword() %></span><br>
    <li>超管：</li><span><%=u.getSupers() %></span><br>
    <li>邮箱：</li><span><%=u.getEmil() %></span><br>
    <li>备注：</li><span><%=u.getComment() %></span><br>
    <li>注册时间：</li><span><%=u.getUtime() %></span><br>
</ul>
</body>
</html>