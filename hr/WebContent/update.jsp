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
       
       <div><a href="trainManage" style="color: black;">返回</a></div>
        <div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
</body>
</html>