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
<div><h3>欢迎  管理员    <span style="color: #EC7D16">${admin.phone}</span> </h3></div>
<div class="a1">
   <div><a href="toAddRec">发布招聘信息</a></div>
   <div><a href="adlookRec">查看已发布的招聘信息</a></div>
   <div><a href="adLookRes">查看简历</a></div>
   <div><a href="adinterv">面试处理</a></div>
   <div><a href="toAdmin">退出</a></div>
  </div> 
</body>
</html>