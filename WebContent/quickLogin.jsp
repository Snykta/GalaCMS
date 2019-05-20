<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
</head>
<body>
<%
	Cookie[] cok = request.getCookies();
	if(cok!=null){
		for(int i =0;i<cok.length;i++){
			if(cok[i].getName().equals("Qlcok")){
				Integer num = (Integer) application.getAttribute("count");//获取application对象的值
				if(num==null){
					application.setAttribute("count", 1);
				}else{
					application.setAttribute("count", 1+num);
				}
				response.sendRedirect("main.jsp");
			}else{
				out.println("<script>alert('身份信息失效，请重新登陆！');location.href='login.jsp';</script>");
			}
		}
	}
%>
</body>
</html>