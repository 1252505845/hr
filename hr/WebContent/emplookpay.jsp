<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="emp">返回</a></div>
<div>请选择要查看那一月的工资</div>
<form action="empPay" method="post">
 <div> <input type="month" name="userdate" style="width: 100px;" /></div>
    <div><input type="submit" value="确认"/></div>
</form>

</body>
</html>