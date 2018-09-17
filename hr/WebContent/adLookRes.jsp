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
<h2>管理员查看简历</h2>
<div><a href="toAdminrec">返回</a></div>
   <div class="a">
         <div>简历ID</div>  
          <div>应聘者</div>  
           <div>查看状态</div> 
          <div>面试状态</div>  
           <div>操作</div> 
    </div> 
       
     <form action="adseeRes" method="post">
           <c:forEach items="${resumeList}" var="resume">
        
	        <div class="a">
	        	<div><input type="text" name="uid" value="${resume.uid}" readonly="readonly"/></div>
	        	<div><input type="text" name="name" value="${resume.name}" readonly="readonly"/></div>
	        	<div><input type="text" name="sign"  value="${resume.sign}" readonly="readonly"/></div>
	        	<div><input type="text" name="status"  value="${resume.status}" readonly="readonly"/></div>
	        	<div><input type="submit" value="查看" style="height: 30px;"/></div>
	        </div>
        
     </c:forEach>
  </form>
   


</body>
</html>