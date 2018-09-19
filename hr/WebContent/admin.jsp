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
<h1>管理员主页面</h1>
<div><h3>欢迎  管理员    <span style="color: #EC7D16">${admin.phone}</span> </h3></div>
    <div class="a1">
		      <div><a href="toAdminrec" >招聘管理</a></div>
		       <div><a href="deptPost">部门职位管理</a></div>
		       <div><a href="empManage">员工管理</a></div>
		       <div><a href="#">培训管理</a></div>
		       <div><a href="#">薪资管理</a></div>
		       <div><a href="#">奖惩管理</a></div>
		       <div><a href="#">考勤管理</a></div>
		       <div><a href="index">退出</a></div>
    	 </div>
</body>
</html>