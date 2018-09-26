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
<div><a href="Attendance">返回</a></div>
<div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<table border="1"  cellspacing="0">
    <tr>
         <td>日期</td>
         <td>上班打卡时间</td>
         <td>下班打卡时间</td>
         <td>是否迟到</td>
         <td>是否早退</td>
         <td>是否加班</td>
 
    </tr>
<c:forEach items="${attList}" var="att">
       <tr>
         <td><fmt:formatDate value="${att.today}" pattern="yyyy-MM-dd"/></td>
        
         <td> <fmt:formatDate value="${att.onTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
         <td> <fmt:formatDate value="${att.offTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
         <td><c:if test="${att.status==1}">
						否
					</c:if>
	         <c:if test="${att.status==2}">
							是
						</c:if>
	        <c:if test="${att.status==3}">
							迟到超过3小时
						</c:if>
		
         </td>
         <td><c:if test="${att.status222==1}">
						否
					</c:if>
	         <c:if test="${att.status222==2}">
							是
						</c:if>
	        <c:if test="${att.status222==3}">
							早退超过3小时
						</c:if>
		
         </td>
         <td><c:if test="${att.work==0}">
						否
					</c:if>
	         <c:if test="${att.work==1}">
							是
						</c:if>
	       
		
         </td>
        
    </tr>
</c:forEach>
</table>
</body>
</html>