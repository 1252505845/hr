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
width:800px;
margin: auto;

}

</style>
</head>
<body>
<div><a href="deptPost" style="color: black;">返回</a></div>
<div class="big">
<div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<table>
    <tr>
         <td>员工的名字</td>
         <td>员工的部门</td>
         <td>员工的职位</td>
         <td>员工的薪资</td>
        
    </tr>
<c:forEach items="${empList}" var="emp">
       <tr>
         <td>${emp.empName}</td>
         <td>${emp.deptName}</td>
         <td>${emp.posName}</td>
         <td>${emp.salary}</td>
        
    </tr>
</c:forEach>
</table>
</div>
</body>
</html>