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
 .msg{
  text-align: center;
 color:#ff4e00;
  }
</style>
</head>
<body>
<div><a href="emplookpay">返回</a></div>
 <div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
<div>



<table border="1"  cellspacing="0">
   <tr>
        <td>时间</td>
      
        <td>总工资</td>
        <td>基本工资</td>
        <td>绩效奖励</td>
        <td>加班奖励</td>
        <td>惩罚</td>
        <td>社保</td>
   </tr>
   <tr>
        <td><fmt:formatDate value="${payroll.time}" pattern="yyyy-MM"/></td>
        
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
   
</table>
<form action="review" method="post">
<div><input type="text" name="conn" placeholder="请输入要复议的内容" /></div>
<div><input type="text" name="money2" placeholder="请输入金额" />
</div>

<div><input type="submit" value="提交复议"/></div>
</form>
</div>
</body>
</html>