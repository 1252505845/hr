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
  <div><a href="deptPost" style="color: black;">返回</a></div>
  <div>
  <table border="1"  cellspacing="0">
      <tr>
           <td>部门id</td>
           <td>部门名称</td>
           <td>部门创建时间</td>
      </tr>
       <tr>
           <td>${dept.deptId}</td>
           <td>${dept.deptName}</td>
           <td><fmt:formatDate value="${dept.createTime}" pattern="yyyy-MM-dd"/></td>
      </tr>
  </table>
  </div>
  <div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
</body>
</html>