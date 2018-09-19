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
<div><a href="toAdmin">返回</a></div>

   <div class="a1">
   <div><a href="addEmp">增加员工</a></div>
   <div><a href="updateEmp">员工换岗</a></div>
   <div><a href="delempl">删除员工</a></div>
   <div><a href="#"></a></div>
   <div><a href="toAdmin">退出</a></div>
  </div> 
</body>
</html>