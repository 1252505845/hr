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
width:1000px;

font-size: 1.2em;

margin: auto;
}
.big>div{
margin-bottom: 20px;
}
.b1{

width:800px;
overflow: auto;
}
.b1>div{
float: left;
margin-right: 20px;
}

a{
text-decoration:none;
display:block;
color: white;
font-size: 1.5em;
line-height: 50px;
}
.end{
width:200px;
height: 50px;
text-align:center;
background-color: #1479E1;
margin-left: 300px;
}
.a1{
overflow: auto;
}
.a1>div{

float: left;
margin-right: 300px;
}

</style>
</head>
<body>
<h1>游客看招聘信息</h1>
<div class="top">
   <div><a href="user" style="color: black;">返回</a></div>
</div>
<c:forEach items="${recruitList}" var="recruit" >
  <div class="big">
    <div class="a1">
            <div>${recruit.deptId} &nbsp; ${recruit.pid}</div>
            <div>${recruit.company}</div>
    </div>
      
      <div class="b1">
         <div style="color: red"><span>薪资: </span>${recruit.pay}</div>
         <div><span>工作地点: </span>${recruit.addr}</div>
         <div><span>工作经验: </span>${recruit.workExperience}</div>
         <div><span>学历: </span>${recruit.education}</div>
         
      </div>
      <div><fmt:formatDate value="${recruit.createTime}" pattern="yyyy-MM-dd"/></div>
      <div><span>岗位要求:</span>&nbsp; ${recruit.content}</div>
      <div class="end"><a href="#">申请职位</a></div>
     
      <hr>
  </div>

</c:forEach>

</body>
</html>