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
.a{
width: 613px;
margin: auto;

overflow: auto;

}
.a>div{
float: left;
width: 100px;
border: 1px solid black;
font-size: 1.2em;


}
input{
width: 99%;
height: 23px;
line-height: 23px;
}
</style>
</head>
<body>
<div><a href="toAdmin">返回</a></div>
<div class="a">
         <div>时间</div>
         <div>员工ID</div>  
          <div>员工名字</div>  
           <div>操作</div> 
    </div> 
       
     
           <c:forEach items="${empList}" var="emp">
            
	        <form action="addPay" method="post">
	        
		        <div class="a">
		        <div> <input type="month" name="userdate" style="width: 100px;" /></div>
		        	<div><input type="text" name="empId" value="${emp.empId}" readonly="readonly"/></div>
		        	<div><input type="text" name="empName" value="${emp.empName}" readonly="readonly"/></div>
		        	
		        	<div><input type="submit" value="发放工资" style="height: 30px;"/></div>
		        </div>
		        </form>
        
     </c:forEach>
  

</body>
</html>