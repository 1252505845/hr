<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
  $(function(){
	$("#cardNumber").blur(function() {
		$.ajax({
			url:"validateCard",
			type:"post",
			dataType:"text",
			data :{
				kind:$("input[name=kind]:checked").val(),
				cardNumber:$(this).val()
			},
			success:function(data){
				if(data!=""){
					alert(data);
				}
			}
			
		});
	});
});

</script>
</head>
<body>
<form action="showOrder">
<table border="1"  cellspacing="0">
		<tr>
			<td  colspan="2">基本信息</td>
		</tr>
		<tr>
			<td>姓名</td>
			<td ><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>寄送地址</td>
			<td><input type="text" name="addr"/></td>
		</tr>
		<tr>
			<td  colspan="3">信用卡信息</td>	
		</tr>
		
		<tr>
		     <td>种类</td>
			<td>
			<input type="radio" name="kind" value="1"/>Visa
			<br/>
			<input type="radio" name="kind" value="2"/>Master
			<br/>
			</td>
		</tr>
		
		<tr>
			<td>卡号</td>
			<td ><input type="text" name="cardNumber" id="cardNumber"/></td>
		</tr>
</table>
<div><input type="submit" value="继续"/></div>
</form>
</body>
</html>