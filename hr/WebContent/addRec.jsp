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
	
});
</script>
</head>
<body>
<div><h3>欢迎  管理员    <span style="color: #EC7D16">${admin.phone}</span> </h3></div>
     <form action="addRec" method="post">
     <div class="big">
        <table border="1"  cellspacing="0" >
            <tr>
                <td colspan="4"  align="center">招聘信息表</td>
            </tr>
            <tr>
            	<td>单位</td>
            	<td><input type="text" placeholder="请输入公司名称" name="company"/></td>
            	<td>部门职位</td>
            	<td>
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
            </tr>
            <tr>
            	<td>地址</td>
            	<td><input type="text" name="addr" placeholder="请输入公司地址"/></td>
            	<td>薪资</td>
            	<td>
            		 <select name="pay">
    							<option>3000以下</option>
    							<option>3000-5000</option>
    							<option>5000-8000</option>
    							<option>8000-10000</option>
    							<option>10000以上</option>
    						</select> 
            	</td>
            </tr>
            <tr>
            	<td>学历</td>
            		<td><select name="education">
	    					  <option>初中及以下</option>
	    					   <option>博士</option>
	    					   <option>硕士</option>
	    					   <option>本科</option>
	    					   <option>大专</option>
	    					   <option>高中</option>
	    					   <option>初中及以下</option>
    					  </select>
    				</td>
    				 <td>工作经验</td>
    				 <td><input type="text" name="workExperience"  placeholder="要求几年的工作经验"/></td>
    				
            </tr>
            <tr>
               <td>岗位要求</td>
               <td colspan="3">
                       <input type="text" name="content" placeholder="岗位要求" style="width:99%">
               </td>
            
            </tr>
        </table>
        <div class="msg"><c:if test="${not empty msg}">
						   <c:out value="${msg}"/>
						</c:if></div>
						
    	    <div class="end"> 
    	        <div><input type="submit" value="更新并保存" style="width:150px" /></div>
    	          
    	         <div><input type="reset" value="取消" style="width:100px"/></div>
    	          <div class="return"><a href="toAdminrec" >返回</a></div>
           </div>
     </div>
     </form>
     
</body>
</html>