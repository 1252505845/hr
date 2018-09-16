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
border:1px solid green;

width:1000px;
margin: auto;
overflow: auto;
}
.a1>div{
width: 40%;
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
<div><h3>你好     <span style="color: #EC7D16">${user.phone}</span> </h3></div>
    <div class="a1">
		      <div><a href="queryRes" >查看简历</a></div>
		       <div><a href="tolookRec">查看招聘信息</a></div>
		       <div><a href="index">退出</a></div>
    	 </div>
</body>
</html>