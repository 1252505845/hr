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
          <div>工资</div>  
          <div>复议内容</div>
           <div>操作</div> 
    </div> 
       
     
           <c:forEach items="${revList}" var="rev">
            
	        <form action="agree" method="post">
	        
		        <div class="a">
		        <div> <input type="text" name="date" 
		        value="<fmt:formatDate value='${rev.date}' pattern='yyyy-MM-dd '/>"
		         readonly="readonly" /></div>
		        	<div><input type="text" name="empId" value="${rev.empId}" readonly="readonly"/></div>
		        	<div><input type="text" name="money2" value="${rev.money}" readonly="readonly"/></div>
		        	<div><input type="text" name="conn" value="${rev.conn}" readonly="readonly"/></div>
		        
		        	<div><input type="submit" value="同意复议" style="height: 30px;"/></div>
		        </div>
		        </form>
        
     </c:forEach>
</body>
</html>