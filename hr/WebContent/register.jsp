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
  .b2>input{
  width:100%;
  }
  .b3{
  
width:85%;
display:none;
  color:red;
  clear:left;
  
  text-align:center;
 
  }
  .c{
   
  width:90%;
  margin-left:150px;
  }
  .b>div{
  float:left;
  margin-left:10px;
  }
  .d{
  margin-top:20px;
  }
  .d>input{

  margin-left:150px;
  width:50%;
  height:50px;
  font-size:1.5em;
  }
  .check{
   background-color:#EA5800;
      color:white;
  }
   .msg{
  text-align: center;
 color:red;
 font-size: 1.2em;
  }
</style>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
  $(function () {
	$("#phone").blur(function () {
		$("#phoneTip").hide();
		$("#phone").css("border","none");
		var phone=$(this).val();
		if(phone.trim()==""){
			$("#phoneTip").text("账号不能为空");
			$("#phoneTip").show();
			return;
		}
		  var reg=/^1[3|5|7|8]\d{9}$/;
		 if(!reg.test(phone)){
			 $("#phone").css("border","none");
			 $("#phoneTip").text("请输入正确的手机号");
			 $("#phoneTip").show();
			 $("#phone").css("border-color","red");
			 return;
		 }
		 $.ajax({
			url:"checkPhone",
			 type:"post",
			 data:{
				 phone:$(this).val()
			 },
			 dataType:"text",
			 success:function(data){
				 if(data!=""){
			  $("#phone").css("border","none");
				$("#phoneTip").text("账号已存在");
				 $("#phoneTip").show();
				 $("#phone").css("border-color","red");
				 }
			 }
			 
		 });
		
	});
});

function check(){
		var reg=document.getElementById("reg");
		reg.style="";
		
			if(document.getElementById("gh").checked==true){
				reg.disabled="";
		        reg.style="background-color:#EA5800";
                   reg.style.color="white";
			
			}else{
		
			reg.disabled="disabled";
			reg.style="color:#888888";
			}
		}

		
 function checkPsw(){
 var psw =document.getElementById("psw");
  var pswTip=document.getElementById("pswTip");
  var reg=/^[0-9a-zA-Z]{6,20}$/;
  var res=reg.test(psw.value);
  psw.style="";
  pswTip.style.display="none";
  if(psw.value==""||res==false){
  pswTip.style.display="block";
  psw.style="border-color:red";
  }
  checkRPsw();
 }
 function checkRPsw(){
  var psw =document.getElementById("psw");
  var repeatPsw=document.getElementById("repeatPsw");
  var  RPswTip=document.getElementById("RPswTip");
  repeatPsw.style="";
  RPswTip.style.display="none";
  if(psw.value!=repeatPsw.value){
  repeatPsw.style="border-color:red";
  RPswTip.style.display="block";
  }
  
 }
		
		
</script>
</head>
<body>

<form action="regist" method="post">

<div class="big">
<div class="a1">用户注册</div>
<div class="b">
	<div class="b1">账号:</div>
	<div class="b2"><input type="text" id="phone"  name="phone" placeholder="请输入手机号"/></div>
	<div class="b3" id="phoneTip"></div>
</div>
<div class="b">
	<div class="b1">密码:</div>
	<div class="b2" ><input type="password" id="psw" onblur="checkPsw()" name="psw" placeholder="请输入密码"/></div>
    <div class="b3" id="pswTip">密码必须是6-20位数字字母组合</div>
</div>
<div class="b">
	<div class="b1">确认密码:</div>
	<div class="b2"><input type="password" id="repeatPsw" name="repeatPsw" onblur="checkRPsw()" placeholder="重复密码"/></div>
	<div class="b3" id="RPswTip">两次密码不相等</div>
</div>
<div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<div class="c"><input type="checkbox" id="gh" onclick="check()"/>我已阅读并同意相关服务条款和服务政策</div>
<div class="d"><input type="submit" value="立即注册" id="reg"  disabled="disabled"></div>
</div>
</form>
</body>
</html>