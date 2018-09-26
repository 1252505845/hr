<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{
text-decoration:none;
color: #CF5202;
}
.a1{


width:1000px;
margin: auto ;
overflow: auto;
}
.a1>div{
width: 30%;
float: left;
height: 150px;
line-height:150px;
font-size: 3em;
background-color:#88DD4A;
text-align:center;
margin-right:20px;
margin-bottom:50px;
color:  #CF5202;
}

</style>
</head>
<body>
<h1>员工界面</h1>
<div><h3>欢迎      <span style="color: #EC7D16">${emp.phone}</span> </h3></div>
<div class="a1">
		      <div><a href="empmsg">个人信息</a></div>
		      
		       <div><a href="lookTrain">培训</a></div>
		       <div><a href="lookRep">奖惩</a></div>
		       <div><a href="Attendance">考勤打卡</a></div>
		       <div><a href="emplookpay">查看工资</a></div>
		       <div><a href="empLookAllEmp">查看员工</a></div>
		       <div><a href="index">退出</a></div>
    	 </div>
</body>
</html>