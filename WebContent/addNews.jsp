<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script  src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
</head>
<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">新闻管理</a></li>
    <li><a href="#">添加新闻</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
   <form action="AddNews" method="post" enctype="multipart/form-data">
    <li><label>文章标题</label><input name="titles" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>关键字</label><input name="keys" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
    <li><label>是否审核</label><cite><input name="checks" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;<input name="checks" type="radio" value="0" />否</cite></li>
    <li><label>引用地址</label><input name="yin" type="text" class="dfinput" value="" /></li>
    <li><label>文章内容</label><textarea name="nei" cols="" rows="" class="textinput"></textarea></li>
     <li><label>缩略图</label><input type="file" name="files" id="" value="" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="btn" value="确认保存"/></li>
    </form>
    </ul>
    </div>
    
    
    
    
</body>
</html>
