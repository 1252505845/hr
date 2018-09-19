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
width: 813px;
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
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">

function updateField(sel, id){
	//alert(id);
	var nid = "#position" + id;
	var sel2 = nid.toString()+" option:gt(0)";
	
	if(sel.value==0){
		$(sel2).remove();
		return;
	}
	
	$.ajax({
		url:"queryPosition",
		type:"post",
		dataType:"json",
		data:{
			deptId:sel.value
		},
		success:function(data){
			$(sel2).remove();
			$.each(data, function(index, item){	
				var opt = "<option value='"+ item.pid +"'>"+ item.posName +"</option>";
                $(nid).append(opt);
			});
		}
	});
	
}



</script>

</head>
<body>
    <h1>管理员增加员工</h1>
    <div><a href="empManage">返回</a></div>
    <div class="a">
         <div>简历ID</div>  
          <div>姓名</div>  
           <div>应聘的岗位</div> 
          <div style="width:250px; ">安排的岗位</div> 
            <div>薪资</div> 
           <div>操作</div> 
    </div> 
    
        <c:forEach items="${resumeList}" var="resume">
	        <form action="addEmpTrue" method="post">
		        <div class="a">
		        	<div><input type="text" name="rid" value="${resume.rid}" readonly="readonly"/></div>
		        	<div><input type="text" name="name" value="${resume.name}" readonly="readonly"/></div>
		        	<div><input type="text" name="job"  value="${resume.job}" readonly="readonly"/></div>
		        	<div style="width:250px; ">
				        	<select id="dept-${resume.rid}" name="deptId" style="height:30px;" onchange="updateField(this, ${resume.rid})">
				    			<option value="0">请选择部门</option>
				    			   <c:forEach items="${deptList}" var="dept">
				    					<option value="${dept.deptId}">${dept.deptName}</option>
				    				</c:forEach>
				    					
			    					</select>
			    					<select id="position${resume.rid}" name="pid" style="height:30px;">
			    						<option value="0">请选择职位</option>
			    					</select>
	    					</div>
	    					<div>
	    				<select name="salay" style="height:30px;width: 100px;">
    							<option>3000</option>
    							<option>5000</option>
    							<option>8000</option>
    							<option>10000</option>
    							<option>15000</option>
    						</select> 	
	    				</div>
	    					
		        	<div><input type="submit" value="添加为员工" style="height: 30px;"/></div>
		        </div>
		         <input type="hidden" id="uid" name="uid" value="${resume.uid}" />
		         <input type="hidden" id="rid" name="rid" value="${resume.rid}" />
		      </form>
        
     </c:forEach>
</body>
</html>