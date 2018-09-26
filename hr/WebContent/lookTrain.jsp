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

<div><a href="emp" style="color: black;">返回</a></div>
<table border="1"  cellspacing="0">
   <tr>
        <td>培训名称</td>
        <td>培训时间</td>
        
   </tr>

<c:forEach items="${trainList}" var="train">
     <tr>
        <td>${train.trainName}</td>
        <td><fmt:formatDate value="${train.time}" pattern="yyyy-MM-dd"/></td>
        
   </tr>
</c:forEach>
</table>
</body>
</html>