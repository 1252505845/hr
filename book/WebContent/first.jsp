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


</script>
</head>
<body>
<form action="book">
<div>step1:选择要购买的书籍</div>
<table  border="1"  cellspacing="0">
  <tr>
      <td colspan="3">书名</td>
      <td>购买</td>
  </tr>
  <c:forEach items="${bookList}" var="book">
  <tr>
      <td colspan="3">${book.bname}</td>
      <td><input type="checkbox"  name="bname" value="${book.bname}"/></td>
  </tr>
  
  </c:forEach>
  
</table>
<div><input type="submit" value="继续"/></div>

</form>


</body>
</html>