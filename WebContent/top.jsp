<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
   <script  src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
    <script>
        $(function () {
            //顶部导航切换
            $(".nav li a").click(function () {
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })
        })
    </script>

</head>
<body style="background:url(images/topbg.gif) repeat-x;">

    <div class="topleft">
        <a href="main.jsp" target="_parent"><img src="images/logo.png" title="系统首页" /></a>
    </div>

    <ul class="nav">
        <li><a href="#" target="rightFrame" class="selected"><img src="images/icon01.png" title="工作台" /><h2>新闻类别管理</h2></a></li>
        <li><a href="#" target="rightFrame"><img src="images/icon02.png" title="模型管理" /><h2>新闻管理</h2></a></li>
        <li><a href="#" target="rightFrame"><img src="images/icon03.png" title="模块设计" /><h2>广告管理</h2></a></li>
        <li><a href="#" target="rightFrame"><img src="images/icon04.png" title="常用工具" /><h2>用户管理</h2></a></li>
        <li><a href="FileGuanLi.jsp" target="rightFrame"><img src="images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
        <li><a href="#" target="rightFrame"><img src="images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    </ul>

    <div class="topright">
        <ul>
            <li><span><a href="#"><img src="images/help.png" title="帮助" class="helpimg" /></a></span></li>
            <li><a href="#">关于</a></li>
            <li><a href="logout.jsp" target="_parent">退出</a></li>
        </ul>

        <div class="user">
            <span><%=session.getAttribute("lname") %></span>
            <i>消息</i>
            <b>5</b>
        </div>

    </div>
</body>
</html>