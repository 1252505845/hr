<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="empLookAllEmp">返回</a></div>
<div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<table border="1"  cellspacing="0">
   <tr>
        <td>员工的id</td>
        <td>员工名字</td>
         <td>部门</td>
        <td>职位</td>
        <td>年龄</td>
        <td>性别</td>
       
        <td>手机</td>
        <td>邮箱</td>
   </tr>

<c:forEach items="${empList}" var="emp">
     <tr>
       
        <td>${emp.empId}</td>
        
         <td>${emp.empName}</td>
         <td>${emp.deptName}</td>
         <td>${emp.posName}</td>
         
         <td>${emp.age}</td>
         <td>${emp.sex}</td>
         <td>${emp.telphone}</td>
         <td>${emp.mail}</td>
   </tr>
</c:forEach>
</table>

</body>
</html>