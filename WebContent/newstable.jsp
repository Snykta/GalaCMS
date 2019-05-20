<%@page import="java.util.List"%>
<%@page import="com.cms.dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script  src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
<link rel="stylesheet" href="layui/css/layui.css">
<script  src="layui/layui.js"></script>
<style type="text/css">
.tools img{
margin-top: -10px
}
</style>
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
    <li><a href="#">新闻列表</a></li>
    </ul>
    </div> 
    <div class="rightinfo">
    <div class="tools">
    	<ul class="toolbar">
        <li class="click"><span><img src="images/t01.png" /></span><a href="addNews.jsp">添加</a></li>
        <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span><a href="javascript:;" id="a1">删除</a></li>
        <li><span><img src="images/t04.png" /></span>统计</li>
        </ul>
        <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul>
    </div>
    <table class="imgtable">
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th>标题</th>
    <th>关键字</th>
    <th>类型</th>
    <th>引用地址</th>
    <th>是否审核</th>
    <th>点击</th>
    <th><input id="check1" style="position: relative;right: 20px;" type="checkbox"></th>
    </tr>
    </thead>
    <tbody id="tbo1">


    </tbody>
    </table>
    <div id="test" style="position: absolute;left: 1000px"></div>
       
    
<script type="text/javascript">
var sums = "<%=lists.size() %>";
$(function() {
fun1(0);
});
var str = "";
function fun1(n) {
	$.ajax({
	    url : "/GalaCMS/FenYe",
	    type : "post",
	    data : {
	    	"num1":n
	    },
	    success : function (s) {
	    	var arry = JSON.parse(s);
	    	console.log(arry);
	    	newslists(arry);
	    	$('#tbo1').append(str);
	    	
	    }
	});
}


function newslists(lists) {
	for(var i in lists){
		
		str+="<tr>";
		str+=" <td class='imgtd'><img src='http://192.168.1.105:8080/test/"+lists[i].news_image+"' /></td>";
		str +="<td><a href='#'>"+lists[i].new_title+"</a><p>发布时间："+lists[i].news_date+"</p></td>";
		str+=" <td>"+lists[i].news_keyword+"<p>ID:"+lists[i].news_id+"</p></td>";
		str+="<td>"+lists[i].news_keyword+"</td>";
		str+="<td>"+lists[i].news_referaddress+"</td>";
		if(lists[i].news_check==1){
			str+="<td>已审核</td>";
		}else{
			str+="<td><i>未审核</i></td>";
		}
		str+="<td>"+lists[i].news_content+"</td>";
	    str+="<td><input style='margin-left: 15px' value='"+lists[i].news_id+"' type='checkbox'></td>"
	    str+="</tr>";
	}
}


	$('.imgtable tbody tr:odd').addClass('odd');
	$('#check1').click(function () {
		var $listc = $('input:checkbox');
		$listc.each(function (index, element) {
			if($listc.get(0).checked){
				$listc.get(index).checked=true;
			}else{
				$listc.get(index).checked=false;
			}
		});
	});
	
	var num = 0;
	$('#a1').click(function () {
		var arr = new Array();
		var $listc = $('#tbo1 input:checkbox');
		$listc.each(function (index, element) {
	           if($listc.get(index).checked){
	        	  arr[num++]=$(this).val();
	              //思路：把选中的值保存到数组中，或者json中，用ajax传到后台，后台遍历删除
	           }
	        });
		if(confirm("确定要删除选中的"+arr.length+"条数据吗？")){
			$.ajax({
			    url : "/GalaCMS/DeleteNews",
			    type : "post",
			    data : JSON.stringify(arr),
			    success : function (s) {
			    	if(s>0){
			    		location.href="newstable.jsp";
			    	}
			    }
			});
		}else{
			num = 0;
			return;
		}
	});
	
	
	layui.use('laypage', function(){
	    var laypage = layui.laypage;

	    //执行一个laypage实例
	    laypage.render({
	        elem: 'test' //注意，这里的 test1 是 ID，不用加 # 号
	        ,count: sums //数据总数，从服务端得到
	        ,limit :3
	        ,groups :2
	        ,jump: function(obj, first){
	            if(!first){
	            	fun1((obj.curr-1)*3);
	        		$('#tbo1').text('');
	        		str = "";
	            }
	        }
	    });
	});
	</script>
</body>
</html>
