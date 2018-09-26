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
.big{
width: 800px;
margin: auto;
}
</style>

</head>
<body>
  <div><a href="empManage">返回</a></div>
  <div class="big">
		       <div class="msg"><c:if test="${not empty msg}">
		   <c:out value="${msg}"/>
		</c:if></div>
    <div>
    <table border="1"  cellspacing="0">
       <tr>
          <td>员工名字</td>
          <td>部门</td>
          <td>职位</td>
          <td>工资</td>
          <td>电话</td>
          <td>性别</td>
          <td>学历</td>
          <td>学校</td>
          <td>专业</td>
          <td>年龄</td>
          <td>邮箱</td>
         
       </tr>
  
       <c:forEach items="${empList}"  var="emp">
         <tr>
             <td>${emp.empName}</td>
             <td>${emp.deptName}</td>
             <td>${emp.posName}</td>
             <td>${emp.salary}</td>
             <td>${emp.telphone}</td>
             <td>${emp.sex}</td>
             <td>${emp.education}</td>
             <td>${emp.school}</td>
             <td>${emp.major}</td>
             <td>${emp.age}</td>
             <td>${emp.mail}</td>
         </tr>
       
       </c:forEach>
      </table>
    </div>
    
    
  </div>
  
  
</body>
</html>