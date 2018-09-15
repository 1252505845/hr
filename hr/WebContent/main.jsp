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


input{
width:210px;
height: 100%;
}
a{
text-decoration:none;
display:block;
color: white;
font-size: 1.5em;
height: 50px;

}
.end>div{

float:left;
margin-left: 100px;


}
.end>div>input {
	background-color:  #CF5202;
	height: 50px;
	color: white;
	font-size: 1.5em;
}

.return{
background-color:  #CF5202;
height: 50px;
width:100px;
text-align: center;

}
 td{
height: 30px;
font-size: 1.2em;
font-weight: bold;
}
 select{
width: 100px;
}
 select option{

width: 100%;
height: 100%;
}
 .msg{
  text-align: center;
 color:#ff4e00;
  }
  .user{

  width:100px;
  border:1px solid green;
  margin-right:50px;
	height: 50px;
	color: white;
	font-size: 1.5em;
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
					var opt = "<option value='"+ item.pid +"'>"+ item.pName +"</option>";
                    $("#position").append(opt);
				});
			}
		});
		
	});
	
});
</script>
</head>
<body>
  <h1>没有简历的用户</h1>
    <div><h3>你好     <span style="color: #EC7D16">${user.phone}</span> </h3></div>
   
    	 <form action="addResume" method="post">
    	<div class="big" >
    			<table border="1"  cellspacing="0" class="table1">
    				<tr>
    					<td colspan="4"  align="center">个人简历</td>
    				</tr>
    				<tr>
    					<td >真实姓名</td>
    					<td ><input tyep="text" name="name"  placeholder="请输入你的姓名"/></td>
    				     <td >性别</td>
    				     <td >
    				    
    				     	<input type="radio" name="sex" style="width:10px"/>男
    				     	<input type="radio" name="sex" style="width:10px" />女  
    				     </td>
    				</tr>
    				<tr>
    					<td >年龄</td>
    					<td > <input type="number" name="age" min="1" max="50"  placeholder="请输入年龄"/></td>
    					 <td>民族</td>
    				     <td><input type="text" name="national"   placeholder="请输入你的民族"/></td>
    					
    				</tr>
    				<tr>
    				  
    					<td>学校</td>
    					<td><input type="text" name="school"  placeholder="请输入你的学校"/></td>
    				     <td >学历</td>
    					<td >
    						<select name="education">
	    					   <option>学历</option>
	    					   <option>博士</option>
	    					   <option>硕士</option>
	    					   <option>本科</option>
	    					   <option>大专</option>
	    					   <option>高中</option>
	    					   <option>初中及以下</option>
    					  </select>
    					  
    					</td>
    				</tr>
    				<tr>
    					 <td>专业</td>
    					<td><input type="text" name="major"  placeholder="请输入你的专业"/></td>
    				     <td>籍贯</td>
    				    <td><input type="text" name="nativePlace" placeholder="请输入你的籍贯"/></td>   
    				</tr>
    				<tr>
    					<td >联系方式</td>
    					<td ><input type="text" name="phone"  placeholder="请输入你的联系方式" /></td>
    				    <td >邮箱</td>
    					<td ><input type="email" name="mail"  placeholder="请输入你的邮箱"/></td>
    				</tr>
    				<tr>
    					<td >应聘岗位</td>
    					<td >
	    				
	    					<select id="dept" name="deptId">
		    					<option value="0">请选择部门</option>
		    					<c:forEach items="${deptList}" var="dept">
		    						<option value="${dept.deptId}">${dept.deptName}</option>
		    					</c:forEach>
		    					
	    					</select>
	    					<select id="position" name="pid">
	    						<option value="0">请选择职位</option>
	    					</select>
	    				 
	    					
    					</td>
    					<td>政治面貌</td>
    					<td>
    					 <select name="politicsStatus">
    							<option>群众</option>
    							<option>团员</option>
    							<option>预备党员</option>
    							<option>党员</option>
    						</select>
    						
    					</td>
    					
    				</tr>
    				
    				<tr>
    					<td >上份工作</td>
    					<td ><input type="text" name="lastWork"  placeholder="请输入工作名称"/></td>
    				    <td>工作经验</td>
    				    <td><input type="text" name="workExperience"  placeholder="请输入几年的工作经验"/></td>
    				</tr>
    				
    				<tr>
    					<td >期望薪资</td>
    					<td >
    					 <select name="salaryExpectation">
    							<option>3000以下</option>
    							<option>3000-5000</option>
    							<option>5000-8000</option>
    							<option>8000-10000</option>
    							<option>10000以上</option>
    						</select> 
    						
    					</td>
    					<td >兴趣爱好</td>
    					<td ><input type="text" name="interest"  placeholder="请输入你的爱好"/></td>
    				</tr>
    				
    			
    			</table>
    			
    			<div class="msg"><c:if test="${not empty msg}">
						   <c:out value="${msg}"/>
						</c:if></div>
    	    <div class="end"> 
    	        <div><input type="submit" value="更新并保存" style="width:150px" /></div>
    	          
    	         <div><input type="reset" value="取消" style="width:100px"/></div>
    	          <div class="return"><a href="main" >返回</a></div>
    	     </div>
    	  
    	</div>
    	</form>
    	
    	
 
   


     
    
</body>
</html>