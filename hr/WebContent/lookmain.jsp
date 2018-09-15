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
overflow:auto;

}
.a1{
overflow:auto;
}
.a>div{
float: left;
margin-right:  200px;
}
.a1>div{
border: 1px solid  #CF5202;
width:100px;
height:100px;
text-align:center;
line-height:100px;
font-size: 1.2em;
background-color: #3989FE;
font-weight: bolder;
}
input{
width:210px;
height: 100%;
}
a{
text-decoration:none;
color: #CF5202;
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


</style>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
	
	
	
	
});
</script>
</head>
<body>
  <h1>有简历的用户</h1>

    <div><h3>你好     <span style="color: #EC7D16">${user.phone}</span> </h3></div>
 
        
    	 <div class="a2" class="tb">
    			<table border="1"  cellspacing="0" class="table1">
    				<tr>
    					<td colspan="4"  align="center">个人简历</td>
    				</tr>
    				<tr>
    					<td >真实姓名</td>
    					<td ><input tyep="text" name="name" value="${resume.name}" placeholder="请输入你的姓名"/></td>
    				     <td >性别</td>
    				     <td >
    				        ${resume.sex}
    				     </td>
    				</tr>
    				<tr>
    					<td >年龄</td>
    					<td > <input type="number" name="age" min="1" max="200" value="${resume.age}" placeholder="请输入年龄"/></td>
    					 <td>民族</td>
    				     <td><input type="text" name="national" value="${resume.national}"  placeholder="请输入你的民族"/></td>
    					
    				</tr>
    				<tr>
    				  
    					<td>学校</td>
    					<td><input type="text" name="school" value="${resume.school}" placeholder="请输入你的学校"/></td>
    				     <td >学历</td>
    					<td >
    						
    					  ${resume.education}
    					</td>
    				</tr>
    				<tr>
    					 <td>专业</td>
    					<td><input type="text" name="major" value="${resume.major}" placeholder="请输入你的专业"/></td>
    				     <td>籍贯</td>
    				    <td><input type="text" name="nativePlace" value="${resume.nativePlace}" placeholder="请输入你的籍贯"/></td>   
    				</tr>
    				<tr>
    					<td >联系方式</td>
    					<td ><input type="text" name="phone" value="${resume.phone}" placeholder="请输入你的联系方式" /></td>
    				    <td >邮箱</td>
    					<td ><input type="email" name="mail" value="${resume.mail}" placeholder="请输入你的邮箱"/></td>
    				</tr>
    				<tr>
    					<td >应聘岗位</td>
    					<td >
	    					
	    					 <span>${resume.dept}</span> $&nbsp;<span>${resume.position}</span> 
	    					
    					</td>
    					<td>政治面貌</td>
    					<td>
    					
    						${resume.politicsStatus}
    					</td>
    					
    				</tr>
    				
    				<tr>
    					<td >上份工作</td>
    					<td ><input type="text" name="lastWork" value="${resume.lastWork}" placeholder="请输入工作名称"/></td>
    				    <td>工作经验</td>
    				    <td><input type="text" name="workExperience" value="${resume.workExperience}" placeholder="请输入几年的工作经验"/></td>
    				</tr>
    				
    				<tr>
    					<td >期望薪资</td>
    					<td >
    					
    						${resume.salaryExpectation}
    					</td>
    					<td >兴趣爱好</td>            
    					<td ><input type="text" name="interest" value="${resume.interest}" placeholder="请输入你的爱好"/></td>
    				</tr>
    				
    			
    			</table>
    	    <div class="end"> 
    	         <div><input type="submit" value="更新并保存" style="width:100px" /></div>
    	          
    	         <input type="reset" value="取消" style="width:100px"/>
    				 <div><a href="main" style="width:100px">返回</a></div>
    	     </div>
    	     
    	</div>
    	
    	
    	
 
   


     
    
</body>
</html>