<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>莱莱CMS管理系统</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script  src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>

    <script type="text/javascript">
        $(function () {
            //导航切换
            $(".menuson li").click(function () {
                $(".menuson li.active").removeClass("active")
                $(this).addClass("active");
            });

            $('.title').click(function () {
                var $ul = $(this).next('ul');
                $('dd').find('ul').slideUp();
                if ($ul.is(':visible')) {
                    $(this).next('ul').slideUp();
                } else {
                    $(this).next('ul').slideDown();
                }
            });
        })
    </script>

</head>

<body style="background:#f0f9fd;">
    <div class="lefttop"><span></span>通讯录</div>
    <dl class="leftmenu">
        <dd>
            <div class="title">
                <span><img style="padding-top: 5px" src="images/leftico02.png" /></span>新闻类别管理
            </div>
            <ul class="menuson">
                <li><cite></cite><a href="newsTypeForm.jsp" target="rightFrame">添加新闻类别</a><i></i></li>
                <li><cite></cite><a href="newsTypeList.jsp" target="rightFrame">编辑新闻类别</a><i></i></li>

            </ul>
        </dd>
        <dd>
            <div class="title"><span><img style="padding-top: 5px" src="images/leftico03.png" /></span>新闻管理</div>
            <ul class="menuson">
                <li><cite></cite><a href="addNews.jsp" target="rightFrame">添加新闻</a><i></i></li>
                <li><cite></cite><a href="newstable.jsp" target="rightFrame">编辑新闻</a><i></i></li>

            </ul>
        </dd>
       
        <dd>
            <div class="title">
                <span><img style="padding-top: 5px" src="images/leftico01.png" /></span>用户管理
            </div>
            <ul class="menuson" id="menuson2">
                <li><cite></cite><a href="addUser.jsp" target="rightFrame">添加用户</a><i></i></li>
                <li><cite></cite><a href="redactUser.jsp" target="rightFrame">编辑用户</a><i></i></li>
                 <li><cite></cite><a href="userList.jsp" target="rightFrame">用户列表</a><i></i></li>
            </ul>
        </dd>
    </dl>

 
    
</body>
</html>
