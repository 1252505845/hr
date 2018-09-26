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
        <td>时间</td>
        <td>员工名字</td>
        <td>总工资</td>
        <td>基本工资</td>
        <td>绩效奖励</td>
        <td>加班奖励</td>
        <td>惩罚</td>
        <td>社保</td>
   </tr>

<c:forEach items="${payList}" var="payroll">
     <tr>
       
        <td><fmt:formatDate value="${payroll.time}" pattern="yyyy-MM"/></td>
         <td>${payroll.empName}</td>
         <td>${payroll.realitysal}
         </td>
         <td>${payroll.salary}
         </td>
         <td>${payroll.performance}
               </td>
         <td>${payroll.overtime}
               </td>
         <td>${payroll.rep}
               </td>
         <td>${payroll.social}
               </td>
	
   </tr>
</c:forEach>
</table>

</body>
</html>