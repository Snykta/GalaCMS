<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page import="com.cms.util.*" %>
<%@ page import="com.cms.dao.*" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Iterator" %>
<%! String user,date;%>
<%
	UserDao u = new UserDao();
	String lname = session.getAttribute("lname").toString();//获取会话中保存的数据
	user = u.Userf(lname);//调用方法
	//Integer num = (Integer) application.getAttribute("count");
	String host = request.getHeader("Host");
	Map m = (Map) application.getAttribute("courent");//获取全局对象
	
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>莱莱CMS管理系统</title>
    <link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>

</head>

<body>


	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>
    
    <div class="mainindex">    
    
    <div class="welinfo">
    <span><img src="${pageContext.servletContext.contextPath}/images/sun.png" alt="天气" /></span>
    <b><span style="color: red;margin-left: 10px"><%=user%>：</span>欢迎您，欢迎使用莱莱CMS管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="${pageContext.servletContext.contextPath}/images/time.png" alt="时间" /></span>
    <i><span id="tme"></span></i> 
    </div>    
    
    <div class="welinfo">
    <span><img style="width: 30px;" src="${pageContext.servletContext.contextPath}/images/i07.png" alt="时间" /></span>
    <i>当前登陆人数：<%=m.size()%>人</i> 
    </div>  
    
    <div class="welinfo">
    <span><img style="width: 30px;" src="${pageContext.servletContext.contextPath}/images/c01.png" alt="主机信息" /></span>
    <i>主机信息：<%=host%></i> 
    </div> 
    
    <% Set s = m.keySet();
  Iterator< String> it = s.iterator();
  while(it.hasNext()) {
 	 String key = it.next();
 	 String value =(String) m.get(key);
 	 %>
 	<div class="welinfo">
    <span><img style="width: 30px;" src="${pageContext.servletContext.contextPath}/images/i09.png" alt="登陆人员" /></span>
    <i><%=value%> 上线</i> 
    </div> 
 <% }%>
    
    
    
    
    
    
    
    </div>
    <script>
    function  fthim() {
        var now = new Date();//创建时间对象
        var year = now.getFullYear();//获取年
        var month = now.getMonth();//获取月
        var adate = now.getDate();//获取天，
        var day = now.getDay();//获取星期
        var hour = now.getHours();//获取小时
        var minu = now.getMinutes();//获取分钟吗
        var sec = now.getSeconds();//获取秒
        month = month+1;
        var arr_week = new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
        var week = arr_week[day];
        var time = year+"年"+month+"月"+adate+"日&nbsp;&nbsp;"+week+" "+hour+":"+minu+":"+sec;
        $('#tme').html("当前时间为："+time);

    }
        window.setInterval("fthim()",1000);
</script>

</body>
</html>
