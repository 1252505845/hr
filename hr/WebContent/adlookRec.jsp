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
.a1{
overflow: auto;
}
.a1>div{

float: left;
margin-right: 300px;
}
a{
text-decoration:none;
display:block;

font-size: 1.5em;
line-height: 50px;
}
</style>
</head>
<body>
<div><a href="toAdminrec">返回</a></div>
   <c:forEach items="${recruitList}" var="recruit" >
  <div class="big">
    <div class="a1">
            <div>${recruit.deptName} &nbsp; ${recruit.posName}</div>
            <div>${recruit.company}</div>
    </div>
      
      <div class="b1">
         <div style="color: red"><span>薪资: </span>${recruit.pay}</div>
         <div><span>工作地点: </span>${recruit.addr}</div>
         <div><span>工作经验: </span>${recruit.workExperience}</div>
         <div><span>学历: </span>${recruit.education}</div>
         
      </div>
      <div><span>发布时间: </span><fmt:formatDate value="${recruit.createTime}" pattern="yyyy-MM-dd"/></div>
      <div><span>岗位要求:</span>&nbsp; ${recruit.content}</div>
     
      <hr>
  </div>

</c:forEach>
</body>
</html>