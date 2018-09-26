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
<div><a href="toAdmin">返回</a></div>
   <table border="1"  cellspacing="0">
   <tr>
        <td>考勤的日期</td>
        <td>员工名字</td>
        <td>上班时间</td>
        <td>下班时间</td>
        <td>是否迟到</td>
        <td>是否早退</td>
        <td>是否加班</td>
   </tr>

<c:forEach items="${attList}" var="att">
     <tr>
       
        <td><fmt:formatDate value="${att.today}" pattern="yyyy-MM-dd"/></td>
         <td>${att.empName}</td>
         <td><fmt:formatDate value="${att.onTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
         </td>
         <td><fmt:formatDate value="${att.offTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
         </td>
         <td>
         <c:if test="${att.status==1}">
						正常上班
						
					</c:if>
					<c:if test="${att.status==2}">
						迟到
					</c:if>
					<c:if test="${att.status==3}">
						 迟到超过三小时旷工
					</c:if>
					</td>
	<td>
         <c:if test="${att.status222==1}">
						正常下班
						
					</c:if>
					<c:if test="${att.status222==2}">
						早退
					</c:if>
					<c:if test="${att.status222==3}">
						 早退超过三小时旷工
					</c:if>
					</td>		
	  <td>
         <c:if test="${att.work==0}">
						不加班
						
					</c:if>
					<c:if test="${att.work==1}">
						加班
					</c:if>
					
					</td>				
        
   </tr>
</c:forEach>
</table>
</body>
</html>