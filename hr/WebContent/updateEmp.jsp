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

width:800px;
margin: auto;
}
.end{
color: blue;
font-size: 1.2em;
cursor:pointer;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#dept").change(function(){
		if($(this).val()==0){
			$("#position option:gt(0)").remove();
			return;
		}
		$.ajax({
			url:"queryPosition",
			type:"post",
			dataType:"json",
			data:{
				deptId:$(this).val()
			},
			success:function(data){
				$("#position option:gt(0)").remove();
				$.each(data, function(index, item){	
					var opt = "<option value='"+ item.pid +"'>"+ item.posName +"</option>";
                    $("#position").append(opt);
				});
			}
		});
		
	});
	
	
	  $("#end").click(function () {
		  $.ajax({
			  url:"updateEmployee",
			  type:"post",
			 dataType:"text",
			 data:{
				 phone:$("#phone").val(),
				 deptId:$("#dept").val(),
				 pid:$("#position").val()
				 
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
<div><h2>员工换岗</h2></div>
 <div><a href="toAdmin" style="color: black;">返回</a></div>

    <div class="big">
	    <div >
	        <span>员工编号：</span>
	        <input type="text" name="phone" id="phone" placeholder="请输入要员工的编号"/>
	     </div>
	     <div>
	         <span>要换的岗位:</span>
                  <select id="dept" name="deptId">
		    					<option value="0">请选择部门</option>
		    					<c:forEach items="${deptList}" var="dept">
		    						<option value="${dept.deptId}">${dept.deptName}</option>
		    					</c:forEach>
		    					
	    					</select>
	    					<select id="position" name="pid">
	    						<option value="0">请选择职位</option>
	    					</select>
	    	</div>				
            <div class="end" id="end">确认修改</div>
    </div>
</body>
</html>