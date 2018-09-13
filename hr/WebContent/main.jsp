<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
width:200px;

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
</style>

<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
	$("#tb").hide();
	$("#look").click(function () {
		$("#tb").show();
	});
});
</script>
</head>
<body>

    <div><h3>你好     <span style="color: #EC7D16">${user.phone}</span> </h3></div>
    <div class="a">
         <div class="a1">
		      <div><a href="#" id="look">查看简历</a></div>
		       <div><a href="#">修改密码</a></div>
		       <div><a href="#">其他</a></div>
		       <div><a href="#">退出</a></div>
    	 </div>
    	<div class="a2" id="tb">
    			<table border="1"  cellspacing="0">
    				<tr>
    					<td colspan="4"  align="center">个人简历</td>
    				</tr>
    				<tr>
    					<td >真实姓名</td>
    					<td ><input tyep="text" placeholder="请输入你的姓名"/></td>
    				     <td >性别</td>
    				     <td >
    				     	<input type="radio" name="sex" style="width:10px"/>男
    				     	<input type="radio" name="sex" style="width:10px" checked/>女
    				     </td>
    				</tr>
    				<tr>
    					<td >年龄</td>
    					<td > <input type="number" name="age" min="1" max="200" placeholder="请输入年龄"/></td>
    					 <td>民族</td>
    				     <td><input type="text" placeholder="请输入你的民族"/></td>
    					
    				</tr>
    				<tr>
    				  
    					<td>学校</td>
    					<td><input type="text" placeholder="请输入你的学校"/></td>
    				     <td >学历</td>
    					<td >
    						<select>
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
    					<td><input type="text" placeholder="请输入你的专业"/></td>
    				     <td>籍贯</td>
    				    <td><input type="text" placeholder="请输入你的籍贯"/></td>   
    				</tr>
    				<tr>
    					<td >联系方式</td>
    					<td ><input type="text" placeholder="请输入你的联系方式" /></td>
    				    <td >邮箱</td>
    					<td ><input type="email" name="mail" placeholder="请输入你的邮箱"/></td>
    				</tr>
    				<tr>
    					<td >应聘职位</td>
    					<td >
	    					<select>
		    					<option>请选择部门</option>
	    					</select>
	    					<select>
	    						<option>请选择职位</option>
	    					</select>
	    					
    					</td>
    					<td>政治面貌</td>
    					<td>
    						<select>
    							<option>群众</option>
    							<option>团员</option>
    							<option>预备党员</option>
    							<option>党员</option>
    						</select>
    					</td>
    					
    				</tr>
    				
    				<tr>
    					<td >上份工作</td>
    					<td ><input type="text" placeholder="请输入工作名称"/></td>
    				    <td>工作经验</td>
    				    <td><input type="text" placeholder="请输入几年的工作经验"/></td>
    				</tr>
    				
    				<tr>
    					<td >期望薪资</td>
    					<td >
    						<select>
    							<option>3000以下</option>
    							<option>3000-5000</option>
    							<option>5000-8000</option>
    							<option>8000-10000</option>
    							<option>10000以上</option>
    						</select>
    					</td>
    					<td >兴趣爱好</td>
    					<td ><input type="text" placeholder="请输入你的爱好"/></td>
    				</tr>
    				
    			
    			</table>
    	    <div class="end"> 
    	        <div><input type="button" value="修改" style="width:100px" /></div>
    	          <div><input type="button" value="保存" style="width:100px" /></div>
    	
    	     </div>
    	</div>
    	
    	
    	
    </div>
   


     
    
</body>
</html>