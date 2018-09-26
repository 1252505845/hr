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
border:1px solid  green;
overflow: auto;
}
.big>div{
margin-right:100px;
float: left;
}
a{
text-decoration:none;
color: #CF5202;
}
.a1{
width:100px;
}
.a1>div{
font-size: 1.2em;
text-align:center;
margin-right:20px;
margin-bottom:20px;
color:  #CF5202;
}
.b1,.b2 {
width: 800px;
}

.b1>div{
margin: 10px ;
}
.b11,.b22,.b33{
cursor: pointer;
color: blue;
font-size: 1.2em;
}

.p{
width: 613px;
margin: auto;

overflow: auto;

}
.p>div{
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

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function (){
	$("#b1").hide();
	$("#b2").hide();
	$("#b3").hide();
	$("#a1").click(function () {
		$("#b2").hide();
		$("#b3").hide();
		$("#b1").show();
		
	});
	$("#a2").click(function () {
		$("#b1").hide();
		$("#b3").hide();
		$("#b2").show();
		
	});
	
	$("#a3").click(function () {
		$("#b1").hide();
		$("#b2").hide();
		$("#b3").show();
		
	});
});

</script>
</head>
<body>
   <div><a href="toAdmin">返回</a></div>
   <div class="big">
    <div class="a1">
			   <div><a href="#" id="a1">增加培训</a></div>
			   <div><a href="#" id="a2">查看培训</a></div>
			   <div><a href="#" id="a3">删除培训</a></div>
			  
			  
	
	   </div>
	   
	   <div>
	            <!--增加培训  -->
	   			<div class="b1" id="b1">
	   			<div>添加培训</div>
	   			<form action="addTrain" method="post">
	                 <div>培训名称:<input style="width:150px;" type="text" name="trainName" id="trainName"  placeholder="请输入要添加的培训名称"/></div>
	                  <div>培训时间:<input  style="width:100px;" type="date" name="time" id="time"  /></div>
	                  <div> <select id="dept" name="deptId">
			    					<option value="0">请选择部门</option>
			    					<c:forEach items="${deptList}" var="dept">
			    						<option value="${dept.deptId}">${dept.deptName}</option>
			    					</c:forEach>
	                  </select></div>
	               <div class="b11" id="b11"><input  style="width:100px;" type="submit" value="确认提交"/></div>
	               </form>
               </div>
	     <!--查看培训  -->
	         <div class="b2" id="b2">
	         <div>所有的培训信息</div>
	        <div class="p">
	                 <div>培训的名称</div>
	                 <div>培训的部门</div>
	                 <div>培训的时间</div>
	                 <div>操作</div>
	             </div> 
	               <c:forEach items="${trainList}" var="train">
	               <form action="updateTrain" method="post">
	              <div class="p">
	              <div><input type="text" name="trainName" value="${train.trainName}" readonly="readonly"/></div>
		        	<div><input type="text" name="deptName" value="${train.deptName}" readonly="readonly"/></div>
		        	<div><input type="text" name="time"  value="<fmt:formatDate value="${train.time}" pattern="yyyy-MM-dd " />"  readonly="readonly"/></div>
	              <div><input type="submit" value="修改" style="height: 30px;"/></div>
	               </div>
	               </form>
	               </c:forEach>
	       
	         </div>
	    <!--查看培训  -->
	   <div class="b3" id="b3">
	         <div>所有的培训信息</div>
	        <div class="p">
	                 <div>培训的名称</div>
	                 <div>培训的部门</div>
	                 <div>培训的时间</div>
	                 <div>操作</div>
	             </div> 
	               <c:forEach items="${trainList}" var="train">
	               <form action="delTrain" method="post">
	              <div class="p">
	              <div><input type="text" name="trainName" value="${train.trainName}" readonly="readonly"/></div>
		        	<div><input type="text" name="deptName" value="${train.deptName}" readonly="readonly"/></div>
		        	<div><input type="text" name="time"  value="<fmt:formatDate value="${train.time}" pattern="yyyy-MM-dd " />"  readonly="readonly"/></div>
	              <input type="hidden" name="deptId"  value="${train.deptId}"/>
	              <div><input type="submit" value="删除" style="height: 30px;"/></div>
	               
	               </div>
	               </form>
	               </c:forEach>
	       
	         </div>
	   
	   </div>
   </div>
</body>
</html>