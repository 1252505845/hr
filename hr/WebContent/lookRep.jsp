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
<table border="1"  cellspacing="0">
   <tr>
        <td>奖惩的时间</td>
        <td>奖惩的员工id</td>
        <td>奖惩的员工名字</td>
        <td>奖惩的金额</td>
        <td>奖惩描述</td>
   </tr>

<c:forEach items="${repList}" var="rep">
     <tr>
       
        <td><fmt:formatDate value="${rep.repTime}" pattern="yyyy-MM-dd"/></td>
        
         <td>${rep.empId}</td>
         <td>${rep.empName}</td>
         <td>${rep.money}</td>
         <td>${rep.conn}</td>
   </tr>
</c:forEach>
</table>


</body>
</html>