<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 .big{
  width:600px;
 border:1px solid #A3BCE4;
  margin: 100px auto;
  }
  .a1{
  overflow:auto;
  font-size:1.5em;
  font-weight:bolder;
color:#2F73BE;
  margin:50px;
  text-align:center;
  }
  .b{
 
  width:95%;
  overflow:auto;
  margin-bottom:20px;
  height:50px;
  }
  .b1{
  border:1px solid #DDDDDD;
  width:30%;
  color:#2F73BE;
  text-align:center;
  }
  .b2{
  width:40%;
  }
  .b3{
  width:20%;
  color:red;
  display:none;
  }
  .b2>input{
  width:100%;
  }
  .b>div{
  float:left;
  margin-left:10px;
  }
   .c{
  margin-top:20px;
  }
  .c>input{
  margin-left:150px;
  width:50%;
  height:50px;
  font-size:1.5em;
  background-color:#EA5800;
  color:white;
  }
 
  .d{
  width:200px;
  
  margin:50px 350px;
  }
  .d>a{
  text-decoration : none; 
  }
  .msg{
  text-align: center;
 color:#ff4e00;
  }

</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#loginBtn").click(function(){
		var name = $("#name").val();
		var password = $("#psw").val();
		if(name.trim()!="" && password.trim()!=""){
			$("#loginForm").submit();
		}else{
			alert("用户名或密码不能为空");
		}
	});
});






  function checkName(){
  var tips=document.getElementById("nameTips");
  var name = document.getElementById("name");
   //先把样式恢复
	name.style="";
  tips.style.display="none";
  if(name.value==""){
	name.style="border-color:red";
	tips.style.display="inline";
  }
  }
  
  function checkPsw(){
  var tips=document.getElementById("pswTips");
  var psw = document.getElementById("psw");
   //先把样式恢复
	psw.style="";
  tips.style.display="none";
  if(psw.value==""){
	psw.style="border-color:red";
	tips.style.display="inline";
  }
  }
  
  
</script>
</head>
<body>
<form id="loginForm" action="login" method="post">
    <div class="big">
<div class="a1">用户登陆</div>
<div class="b">
	<div class="b1">账号:</div>
	<div class="b2"><input type="text" placeholder="请输入手机号" name="phone" id="name" onblur="checkName()"/></div>
	<div class="b3"  id="nameTips">帐号不能为空</div>
</div>
<div class="b">
	<div class="b1">密码:</div>
	<div class="b2" ><input type="password" placeholder="请输入密码" name="psw" id="psw" onblur="checkPsw()"/></div>
	<div class="b3" id="pswTips">密码不能为空</div>
</div>
 <div class="msg"><c:if test="${not empty message}">
   <c:out value="${message}"/>
</c:if></div>

<div class="c"><input type="button" id="loginBtn" value="登陆" ></div>

<div class="d">还没有帐号？<a href="reg">免费注册</a></div>
</div>
</form>


</body>
</html>