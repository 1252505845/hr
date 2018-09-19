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
width:600px;
margin: auto;
}
.a{
cursor: pointer;
color: blue;
font-size: 1.2em;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#a").click(function () {
		 $.ajax({
			  url:"delEmp",
			  type:"post",
			 dataType:"text",
			 data:{
				 phone:$("#inp").val()
			 },
			 success:function(data){
				 if(data!=null){
					 alert(data);
				 }
			 }
			
		  });
	});
});


</script>
</head>
<body>
   <div><a href="empManage">返回</a></div>
   <div class="big">
       <div><input type="text" id="inp" name="phone" placeholder="请输入要删除员工的账号"/></div>
       <div class="a" id="a">确认</div>
   </div>
</body>
</html>