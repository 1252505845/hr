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
			url:"queryPos222",
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
	
	
	
	
	
});
</script>
</head>

<body>
<div><a href="emp">返回</a></div>
<form action="lookemp" method="post">
  <div class="big">
	   
	     <div>
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
           <div><input type="submit" value="确认"/></div>
    </div>
    </form>
</body>
</html>