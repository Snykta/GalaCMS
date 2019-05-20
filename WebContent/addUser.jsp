<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>莱莱CMS管理系统</title>
<link href="${pageContext.servletContext.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.servletContext.contextPath}/scripts/jquery.js"></script>
</head>
<body>
<div class="place">
<span>位置：</span>
<ul class="placeul">
<li><a href="#">首页</a></li>
<li><a href="#">用户管理</a></li>
<li><a href="#">添加用户</a></li>
</ul>
</div>
<div class="formbody">
<div class="formtitle"><span>基本信息</span></div>
<form action="AddUser" method="get" autocomplete="off">
<ul class="forminfo">
<li><label>昵称：</label><input id="name" onblur="checkName()" name="user_name" type="text" class="dfinput"/><i id="s1"></i></li>
<li><label>账号：</label><input id="userc" onblur="checkUser()" name="user_u" type="text" class="dfinput"/><i id="s2"></i></li>
<li><label>密码：</label><input id="zpasst" onblur="checkPasst()" name="user_pass" type="text" class="dfinput"/><i id="s3"></i></li>
<li><label>确认密码：</label><input id="zpass" onblur="checkPass()" name="user_pass2" type="text" class="dfinput"/><i id="s4"></i></li>
<li><label>邮箱：</label><input id="emilse" onblur="checkEmil()" name="user_emil" type="text" class="dfinput"/><i id="s5"></i></li>
<li><label>是否为超管：</label><cite><input name="superFlag" type="radio" value="1" checked="checked"/>是&nbsp;&nbsp;&nbsp;<input name="superFlag" type="radio" value="0" />否</cite></li>
<li><label>备注：</label><textarea name="comment" type="text" cols="" rows="" class="textinput"></textarea></li>
<li><label>&nbsp;</label><input value="确认添加" type="submit" class="btn" onclick="return check1()"/></li>
</ul>
</form>
</div>
<script type="text/javascript">
function checkName() {
	 var check = false;
    var name = $('#name').val().trim();
    if (name.length == 0) {
        $('#s1').text('昵称不为空!');
        $('#s1').css("color", "red");
        check = false;
    } else {
        if (isName(name) == false) {
            $('#s1').text('昵称不合法!');
            $('#s1').css("color", "red");
            check = false;
        } else {
            $('#s1').text('昵称合法!');
            $('#s1').css("color", "#CD6600");
            check = true;
        }

    }
    return check;
};


function checkUser() {
	var check = false;
   var zUser = $('#userc').val().trim();
   if (zUser.length == 0) {
       $('#s2').text('账号不为空!');
       $('#s2').css("color", "red");
       check = false;
   } else {
       if (isUser(zUser) == false) {
           $('#s2').text('账号不合法!');
           $('#s2').css("color", "red");
           check = false;
       } else {
           $('#s2').text('账号合法!');
           $('#s2').css("color", "#CD6600");
           check = true;
       }

   }
   return check;
};


function checkPasst() {
	var check = false;
   var zpass = $('#zpasst').val().trim();
   if (zpass.length == 0) {
       $('#s3').text('密码不为空!');
       $('#s3').css("color", "red");
       check = false;
   } else {
       if (isUser(zpass) == false) {
           $('#s3').text('密码不合法!');
           $('#s3').css("color", "red");
           check = false;
       } else {
           $('#s3').text('密码合法!');
           $('#s3').css("color", "#CD6600");
           check = true;
       }

   }
   return check;
};

function checkPass() {
	var check = false;
   var zpass = $('#zpass').val().trim();
   var zpasst = $('#zpasst').val().trim();
   if (zpass.length == 0) {
       $('#s4').text('密码不为空!');
       $('#s4').css("color", "red");
       check = false;
   } else {
       if (isUser(zpass) == false) {
           $('#s4').text('密码不合法!');
           $('#s4').css("color", "red");
           check = false;
       } else {
          if(zpass!=zpasst){
        	  $('#s4').text('密码不一致!');
              $('#s4').css("color", "red");
              check = false;
          }else{
        	  $('#s4').text('二次密码验证通过!');
              $('#s4').css("color", "#CD6600");
              check = true;
          }
       }

   }
   return check;
};



function checkEmil() {
	var check = false;
   var emilse = $('#emilse').val().trim();
   if (emilse.length == 0) {
       $('#s5').text('邮箱不为空!');
       $('#s5').css("color", "red");
       check = false;
   } else {
       if (isEmil(emilse) == false) {
           $('#s5').text('邮箱不合法!');
           $('#s5').css("color", "red");
           check = false;
       } else {
           $('#s5').text('邮箱合法!');
           $('#s5').css("color", "#CD6600");
           check = true;
       }

   }
   return check;
};



function isName(str) {
   var pat = /^[\u4E00-\u9FA5]{1,6}$/;
   return pat.test(str);
}

function isUser(str) {
   var pat = /^[a-zA-Z0-9_-]{4,16}$/;
   return pat.test(str);
}

function isEmil(str) {
	   var pat = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9]{2,6}$/;
	   return pat.test(str);
	}


function check1() {
	var check = checkName() && checkUser() && checkPass() && checkPasst() && checkEmil();
	return check;
}


</script>
</body>
</html>