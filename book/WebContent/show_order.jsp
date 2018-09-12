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
	table{
		border:1px solid black;
	}
	td {
		border:1px solid black;
	}

</style>
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
<script type="text/javascript">
	

</script>

</head>
<body>
	<h2>Step3: </h2>
	<form action="saveOrder" method="post">
		<table>
			
			<tr>
				<td>姓名</td>
				<td>${order.user.name}</td>
			</tr>
			<tr>
				<td>寄送地址</td>
				<td>${order.user.addr}</td>
			</tr>
			<tr>
				<td colspan="2">信息</td>
			</tr>
			<tr>
				<td>种类</td>
				<td>
					<c:if test="${order.bc.kind==1}">
						Visa
					</c:if>
					<c:if test="${order.bc.kind==2}">
						Master
					</c:if>
				</td>
			</tr>
			<tr>
				<td>卡号</td>
				<td>${order.bc.cardNumber}</td>
			</tr>
			<tr>
				<td>订单项目</td>
				<td>
					<c:forEach items="${bnameList}" var="name">
						${name}</br>
					</c:forEach>
				</td>
			</tr>
			<tr>
			 <td colspan="2">
			 	<input type="submit" value="confirm"/>
			 </td>
			</tr>
		</table>
	</form>
</body>
</html>