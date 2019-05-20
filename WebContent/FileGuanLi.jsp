<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.cms.dao.NewsDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
</head>
<body>
<%
NewsDao nd = new NewsDao();
List lists = nd.Newslist();
pageContext.setAttribute("lists", lists);
%>
    <div class="place">
        <span>位置：</span>
        <ul class="placeul">
            <li><a href="#">首页</a></li>
            <li><a href="computer.html">文件管理</a></li>
            <li><a href="#">列表</a></li>
        </ul>
    </div>

    <table class="filetable">
        <thead>
            <tr>
                <th width="25%">名称</th>
                <th width="11%">修改日期</th>
                <th width="10%" style="position: relative;left: 40px">类型</th>
                <th width="6%" style="position: relative;left: 40px">大小</th>
                <th width="48%" style="position: relative;left: 60px">下载</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lists}" var="nlist">
        <c:set var="s1" value="${nlist.image }" scope="request" />
        <%File f = new File("E:\\apache-tomcat-9.0.11\\webapps\\test\\"+request.getAttribute("s1"));
        float filesize = (float)f.length()/1024;%>
            <tr>
                <td><img style="width: 30px;height: 20px;margin-top: 10px" src="http://192.168.1.105:8080/test/${nlist.image }" />${nlist.title }</td>
                <td>${nlist.date}</td>
                <td style="position: relative;left: 40px">图片</td>
                <td class="tdlast"><%=filesize %>&nbsp;KB</td>
                <td style="position: relative;left: 60px"><a href="/GalaCMS/Dowlond?name=${nlist.image }">下载</a></td>
            </tr>
              </c:forEach>
        </tbody>

    </table>
</body>
</html>
