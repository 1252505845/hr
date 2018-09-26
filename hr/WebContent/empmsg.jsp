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
<div><a href="emp">返回</a></div>
<div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<table border="1"  cellspacing="0">
   <tr>
        <td>员工Id</td>
      
        <td>姓名</td>
        <td>部门</td>
        <td>职位</td>
        
        <td>性别</td>
        <td>手机</td>
        <td>邮箱</td>
        <td>基本工资</td>
        <td>学历</td>
        <td>毕业院校</td>
        <td>专业</td>
        <td>籍贯</td>
        <td>民族</td>
        <td>政治面貌</td>
        <td>工作经验</td>
        <td>上一份工作</td>
       
        
   </tr>
   <tr>
       
        <td>${emp.empId}</td>
        <td>${emp.empName}</td>
        <td>${emp.deptName}</td>
        <td>${emp.posName}</td>
        <td>${emp.sex}</td>
        <td>${emp.telphone}</td>
        <td>${emp.mail}</td>
        <td>${emp.salary}</td>
        <td>${emp.education}</td>
        <td>${emp.school}</td>
        <td>${emp.major}</td>
        <td>${emp.nativePlace}</td>
        <td>${emp.national}</td>
        <td>${emp.politicsStatus}</td>
        <td>${emp.workExperience}</td>
        <td>${emp.lastWork}</td>
   
   </tr>
   
</table>

</body>
</html>