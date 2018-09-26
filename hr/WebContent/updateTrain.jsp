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
<div><a href="trainManage" style="color: black;">返回</a></div>
    <form action="update" method="post">
	                 <div>培训名称:<input type="text" name="trainName" id="trainName"  placeholder="请输入要添加的培训名称"/></div>
	                  <div>培训时间:<input type="date" name="time" id="time"  /></div>
	                  <div> <select id="dept" name="deptId">
			    					<option value="0">请选择部门</option>
			    					<c:forEach items="${deptList}" var="dept">
			    						<option value="${dept.deptId}">${dept.deptName}</option>
			    					</c:forEach>
	                  </select></div>
	               <div class="b11" id="b11"><input type="submit" value="确认提交"/></div>
	               </form>

</body>
</html>