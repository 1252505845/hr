<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.big{

width:800px;
margin: 100px auto;
}
.b{
overflow: auto;
}
.b>div{
float: left;
margin: 20px   50px;

}
a{
text-decoration:none;
display:block;
color: #2A569A;
font-size: 1.5em;
line-height: 50px;
}
#sub{
background-color: #FF5400;
font-size: 1.2em;
color: white;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#hid").hide();
	$("#invite").click(function () {
		$("#hid").show();
	});
	$("#sub").click(function () {
		$.ajax({
			url:"addtime",
			type:"post",
			dataType:"text",
		    data:{
		    	rid:$("#rid").val(),
		    	date:$("#date").val()
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
   <div class="big">
    			<table border="1"  cellspacing="0" class="table1">
    				<tr>
    					<td colspan="4"  align="center">个人简历</td>
    				</tr>
    				<tr>
    					<td >真实姓名</td>
    					<td >${resume.name}</td>
    				     <td >性别</td>
    				     <td >
    				       ${resume.sex}
    				        
    				     </td>
    				</tr>
    				<tr>
    					<td >年龄</td>
    					<td > ${resume.age}</td>
    					 <td>民族</td>
    				     <td>${resume.national}</td>
    					
    				</tr>
    				<tr>
    				  
    					<td>学校</td>
    					<td>${resume.school}</td>
    				     <td >学历</td>
    					<td >
    					 ${resume.education}
    					 
    					
    					</td>
    				</tr>
    				<tr>
    					 <td>专业</td>
    					<td>${resume.major}</td>
    				     <td>籍贯</td>
    				    <td>${resume.nativePlace}</td>   
    				</tr>
    				<tr>
    					<td >联系方式</td>
    					<td >${resume.phone}</td>
    				    <td >邮箱</td>
    					<td >${resume.mail}</td>
    				</tr>
    				<tr>
    					<td >应聘岗位</td>
    					<td >	
	    				${resume.job} 	
    					</td>
    					<td>政治面貌</td>
    					<td>
    					  ${resume.politicsStatus}
    						
    					</td>
    					
    				</tr>
    				
    				<tr>
    					<td >上份工作</td>
    					<td >${resume.lastWork}</td>
    				    <td>工作经验</td>
    				    <td>${resume.workExperience}</td>
    				</tr>
    				
    				<tr>
    					<td >期望薪资</td>
    					<td >
    					${resume.salaryExpectation}
    						
    						 
    					</td>
    					<td >兴趣爱好</td>            
    					<td >${resume.interest}</td>
    				</tr>
    			
    			</table>
    	     <div class="b">
    	         <div><a href="#" id="invite">邀请面试</a></div>
    	         <div><a href="adLookRes">返回</a></div>
    	     </div>
    	     
    	     <div id="hid">
    	     <div><input type="date" id="date" name="date"/></div>
	    	  <div>
	    	     <input type="hidden" id="rid" name="rid" value="${resume.rid}"/> 
	    	     <input type="hidden" id="uid" name="uid" value="${resume.uid}"/> 
	    	    <input type="submit" value="确认面试时间" id="sub"/>
    	     </div>
    	     </div>
    	  
    	</div>
</body>
</html>