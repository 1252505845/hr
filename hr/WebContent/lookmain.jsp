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
line-height: 50px;
}
.end>div{

float:left;
margin-top:20px;
margin-left: 50px;


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
 margin-top:5px;
 margin-right: 150px;
 font-size: 1.5em;
  }
.star{
font-size:1.2em;
font-weight:bolder;
color: #E6BC12;
}
.top{
overflow:auto;

background-color:  #568BD3;
}
.top>div{
float: left;
margin-right: 150px;

}
</style>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>



<script type="text/javascript">

      function sex(rName,rValue){

        /*通过传递的元素名获取元素对象*/

        var rObj = document.getElementsByName(rName);

        /*获取到的对象是数组对象，逐一进行遍历，寻找值等于所获取数据值的子对象*/
        for(var i = 0;i < rObj.length;i++){
             if(rObj[i].value == rValue){

                 /*寻找到子对象后，对他进行如下操作就可以实现后台数据显示到单选钮中*/

                 rObj[i].checked =  "checked";
         }
      }
    }
</script>
<script type="text/javascript">
$(function () {
	sex('sex','${resume.sex}');
	
     var flag=$("#edu").val();
     //根据值让option选中     
     if(flag=="博士"){
    	 //$("eduSelect option [value='"+flag+"']").prop("selected","selected");
    	 $('#eduSelect')[0].selectedIndex = 0; 
     }else if(flag=="硕士"){
    	 //$("#eduSelect option [value='"+flag+"']").prop("selected","selected");
    	 $('#eduSelect')[0].selectedIndex = 1;	
     }else if(flag=="本科"){
    	 //$("eduSelect option [value='"+flag+"']").prop("selected","selected");
    	  $('#eduSelect')[0].selectedIndex = 2;
    	 
     }else if(flag=="大专"){
    	 $('#eduSelect')[0].selectedIndex = 3;
    	 //$("eduSelect option [value='"+flag+"']").prop("selected","selected");
    	 
     }else if(flag=="高中"){
    	 //$("eduSelect option [value='"+flag+"']").prop("selected","selected");
    	  $('#eduSelect')[0].selectedIndex = 4; 
     }else if(flag=="初中及以下"){
    	// $("eduSelect option [value='"+flag+"']").prop("selected","selected");
    	 $('#eduSelect')[0].selectedIndex = 5;
    	
     }
  
     var flag2=$("#polhid").val();
     if(flag2=="群众"){
    	 $('#polSelect')[0].selectedIndex = 0;
     }else if(flag2=="团员"){
    	 $('#polSelect')[0].selectedIndex = 1; 	 
     }else if(flag2=="预备党员"){
    	 $('#polSelect')[0].selectedIndex = 2;
    	
     } else if(flag2=="党员"){
    	 $('#polSelect')[0].selectedIndex = 3;

     }
     
     var flag3=$("#salhid").val();
     if(flag3=="3000以下"){
    	 $('#salSelect')[0].selectedIndex = 0;	
     } else if(flag3=="3000-5000"){
    	 $('#salSelect')[0].selectedIndex = 1;	 
     }else if(flag3=="5000-8000"){
    	 $('#salSelect')[0].selectedIndex = 2;
    	
     }else if(flag3=="8000-10000"){
    	 $('#salSelect')[0].selectedIndex = 3;
 
     }else if(flag3=="10000以上"){
    	 $('#salSelect')[0].selectedIndex = 4;
    
     }
     
     
});
</script>
</head>
<body>
  <div class="top">
      <div><a href="user">首页</a></div>
      <div><a href="queryRes">查看简历</a></div>
      <div><a href="tolookRec">查看招聘信息</a></div>
      <div><a href="index">退出</a></div>
  
  </div>

    <div><h3>你好     <span style="color: #EC7D16">${user.phone}</span> </h3></div>
 
        <form action="updateResume" method="post">
    	 <div class="big">
    			<table border="1"  cellspacing="0" class="table1">
    				<tr>
    					<td colspan="4"  align="center">个人简历</td>
    				</tr>
    				<tr>
    					<td ><span class="star">*</span>真实姓名</td>
    					<td ><input tyep="text" name="name" value="${resume.name}" placeholder="请输入你的姓名"/></td>
    				     <td ><span class="star">*</span>性别</td>
    				     <td >
    				       
    				        <input type="radio" name="sex" value="男" style="width:10px"/>男
    				     	<input type="radio" name="sex"  value="女"  style="width:10px" />女
    				     </td>
    				</tr>
    				<tr>
    					<td ><span class="star">*</span>年龄</td>
    					<td > <input type="number" name="age" min="1" max="200" value="${resume.age}" placeholder="请输入年龄"/></td>
    					 <td><span class="star">*</span>民族</td>
    				     <td><input type="text" name="national" value="${resume.national}"  placeholder="请输入你的民族"/></td>
    					
    				</tr>
    				<tr>
    				  
    					<td><span class="star">*</span>学校</td>
    					<td><input type="text" name="school" value="${resume.school}" placeholder="请输入你的学校"/></td>
    				     <td ><span class="star">*</span>学历</td>
    					<td >
    					  <input type="hidden" id="edu" value="${resume.education}" />	
    					 
    					  <select id="eduSelect" name="education">
    					   
	    					   <option value="博士">博士</option>
	    					   <option value="硕士">硕士</option>
	    					   <option value="本科">本科</option>
	    					   <option value="大专">大专</option>
	    					   <option value="高中">高中</option>
	    					 <option value="初中及以下">初中及以下</option>
    					  </select>
    					</td>
    				</tr>
    				<tr>
    					 <td><span class="star">*</span>专业</td>
    					<td><input type="text" name="major" value="${resume.major}" placeholder="请输入你的专业"/></td>
    				     <td><span class="star">*</span>籍贯</td>
    				    <td><input type="text" name="nativePlace" value="${resume.nativePlace}" placeholder="请输入你的籍贯"/></td>   
    				</tr>
    				<tr>
    					<td ><span class="star">*</span>联系方式</td>
    					<td ><input type="text" name="phone" value="${resume.phone}" placeholder="请输入你的联系方式" /></td>
    				    <td ><span class="star">*</span>邮箱</td>
    					<td ><input type="email" name="mail" value="${resume.mail}" placeholder="请输入你的邮箱"/></td>
    				</tr>
    				<tr>
    					<td ><span class="star">*</span>应聘岗位</td>
    					<td >
	    					
	    				<input type="text" name="job" value="${resume.job}" placeholder="请输入你要应聘的岗位"/> 
	    					
    					</td>
    					<td><span class="star">*</span>政治面貌</td>
    					<td>
    					  <input type="hidden" id="polhid" value="${resume.politicsStatus}" />	
    						<!--${resume.politicsStatus}  -->
    						 <select id="polSelect" name="politicsStatus">
    							<option value="群众">群众</option>
    							<option value="团员">团员</option>
    							<option value="预备党员">预备党员</option>
    							<option value="党员">党员</option>
    						</select>
    					</td>
    					
    				</tr>
    				
    				<tr>
    					<td >上份工作</td>
    					<td ><input type="text" name="lastWork" value="${resume.lastWork}" placeholder="请输入工作名称"/></td>
    				    <td><span class="star">*</span>工作经验</td>
    				    <td><input type="text" name="workExperience" value="${resume.workExperience}" placeholder="请输入几年的工作经验"/></td>
    				</tr>
    				
    				<tr>
    					<td ><span class="star">*</span>期望薪资</td>
    					<td >
    					 <input type="hidden" id="salhid" value="${resume.salaryExpectation}" />
    						
    						 <select id="salSelect" name="salaryExpectation">
    							<option value="3000以下">3000以下</option>
    							<option value="3000-5000">3000-5000</option>
    							<option value="5000-8000">5000-8000</option>
    							<option value="8000-10000">8000-10000</option>
    							<option value="10000以上">10000以上</option>
    						</select> 
    					</td>
    					<td >兴趣爱好</td>            
    					<td ><input type="text" name="interest" value="${resume.interest}" placeholder="请输入你的爱好"/></td>
    				</tr>
    				
    			
    			</table>
    			<div class="msg"><c:if test="${not empty msg}">
						   <c:out value="${msg}"/>
						</c:if></div>
						<div style="color: red">黄色标记为必填项</div>
    	    <div class="end"> 
    	         <div><input type="submit" value="更新并保存" style="width:150px" /></div>
    	          
    	         <div><input type="reset" value="取消" style="width:100px"/></div>
    	         <div style="background-color: #CF5202;"><a href="del">删除简历</a></div>
    	          <div class="return"><a href="user" >返回</a></div>
    	     </div>
    	     
    	</div>
    	</form>
    
    
</body>
</html>