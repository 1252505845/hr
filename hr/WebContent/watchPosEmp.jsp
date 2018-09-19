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
.big{
width:300px;
margin: auto;
}
.a>div{
overflow: auto;
}
.b>div,.b1>div{
float: left;
}
.a1,.a2{

border: 1px solid black; 
}

</style>
</head>
<body>
    <div><a href="deptPost" style="color: black;">返回</a></div>
    <div class="big">
    <div>部门下的岗位和员工</div>
     <div class="msg"><c:if test="${not empty msg}">
   <c:out value="${msg}"/>
</c:if></div>
    <div class="a">
		    <div class="b">
		   
				    <c:forEach items="${posList}" var="position">
				   
				     <div class="a1">  ${position.posName}</div>
				    </c:forEach>
				    </div>
				    <hr>
		     <div class="b1">
				     <c:forEach items="${empList}" var="emp">
				      <div class="a2"> ${emp.empName}</div>
				    </c:forEach>
				    </div>
    </div>
    </div>
    
</body>
</html>