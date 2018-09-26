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
.b11,.b22,.b33,b211{
cursor: pointer;
color: blue;
font-size: 1.2em;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function (){
	 $("#dept2").change(function(){
			if($(this).val()==0){
				$("#position2 option:gt(0)").remove();
				return;
			}
			$.ajax({
				url:"quePosition",
				type:"post",
				dataType:"json",
				data:{
					deptId:$(this).val()
				},
				success:function(data){
					$("#position2 option:gt(0)").remove();
					$.each(data, function(index, item){	
						var opt = "<option value='"+ item.pid +"'>"+ item.posName +"</option>";
	                    $("#position2").append(opt);
					});
				}
			});
			
		});
	 $("#dept3").change(function(){
			if($(this).val()==0){
				$("#position3 option:gt(0)").remove();
				return;
			}
			$.ajax({
				url:"quePos",
				type:"post",
				dataType:"json",
				data:{
					deptId:$(this).val()
				},
				success:function(data){
					$("#position3 option:gt(0)").remove();
					$.each(data, function(index, item){	
						var opt = "<option value='"+ item.pid +"'>"+ item.posName +"</option>";
	                    $("#position3").append(opt);
					});
				}
			});
			
		});
	 
	$("#b1").hide();
	$("#b2").hide();
	 $("#b21").hide();
	 $("#b222").hide();
	 $("#b3").hide();
	 $("#b4").hide();
	 $("#b5").hide();
	 
	  $("#a1").click(function () {
		  $("#b2").hide();
		 $("#b21").hide();
		 $("#b222").hide();
		  $("#b3").hide();
		  $("#b4").hide();
		  $("#b5").hide();
		  $("#b1").show();
		});
	  $("#a2").click(function () {
		  $("#b1").hide();
		  $("#b3").hide();
		  $("#b222").hide();
		  $("#b21").hide();
		  $("#b4").hide();
		  $("#b5").hide();
		  $("#b2").show();
	});
	  $("#a21").click(function () {
		  $("#b1").hide();
		  $("#b3").hide();
		  $("#b222").hide();
		  $("#b2").hide();
		  $("#b4").hide();
		  $("#b5").hide();
		  $("#b21").show();
	});
	  $("#see").click(function () {
		  $("#b1").hide();
		  $("#b3").hide();
		  $("#b222").show();
		  $("#b2").hide();
		  $("#b4").hide();
		  $("#b5").hide();
		  $("#b21").hide();
	});
	  $("#a4").click(function () {
		  $("#b1").hide();
		  $("#b3").hide();
		  $("#b222").hide();
		  $("#b2").hide();
		  $("#b21").hide();
		  $("#b5").hide();
		  $("#b4").show();
	});
	  $("#a5").click(function () {
		  $("#b1").hide();
		  $("#b3").hide();
		  $("#b222").hide();
		  $("#b2").hide();
		  $("#b21").hide();
		  $("#b4").hide();
		  $("#b5").show();
	});
	  
	  $("#a3").click(function () {
		  $("#b1").hide();
		  $("#b2").hide();
		  $("#b21").hide();
		  $("#b222").hide();
		  $("#b4").hide();
		  $("#b5").hide();
		  $("#b3").show();
		  
		  $.ajax({
				url:"queryDept",
				type:"post",
				dataType:"json",
				data:{
					
				},
				success:function(data){
				
					$.each(data, function(index, item){	
						var opt = "<option value='"+ item.deptId +"'>"+ item.deptName +"</option>";
	                    $("#deptId").append(opt);
					});
				}
			});
	});
	  
	  
	  
	  
	 
	  
	  $("#b11").click(function () {
		  $.ajax({
			  url:"addDept",
			  type:"post",
			 dataType:"text",
			 data:{
				 
				 deptName:$("#deptName").val()
			 },
			 success:function(data){
				 if(data!=null){
					 alert(data);
				 }
			 }
			
		  });
	});
	  $("#b22").click(function () {
		  $.ajax({
			  url:"delDept",
			  type:"post",
			 dataType:"text",
			 data:{
				 deptName:$("#deptName2").val()
			 },
			 success:function(data){
				 if(data!=null){
					 alert(data);
				 }
			 }
			
		  });
	});
	  
	  
	  $("#b33").click(function () {
		  $.ajax({
			  url:"addPosition",
			  type:"post",
			 dataType:"text",
			 data:{
				 deptId:$("#deptId").val(),
				 posName:$("#posName").val()
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
    <div><a href="toAdmin">返回</a></div>
    <div class="big">
	    <div class="a1">
			   <div><a href="#" id="a1">增加部门</a></div>
			   <div><a href="#" id="a2">删除部门</a></div>
			   <div><a href="#" id="a21">查看部门</a></div>
			   <div><a href="#" id="see">查看部门的员工和职位</a></div>
			   <div><a href="#" id="a3">增加职位</a></div>
			   <div><a href="#" id="a4">查看职位的员工</a></div>
			   <div><a href="#" id="a5">删除职位</a></div>
			
			   
	   </div>
	   <div>
		  
	          <!--增加部门  -->
	   			<div class="b1" id="b1">
	                 <div>部门名称:<input type="text" name="deptName" id="deptName"  placeholder="请输入要添加的部门名称"/></div>
	               <div class="b11" id="b11">添加部门</div>
               </div>
               
               
               <!-- 删除部门 -->
				 <div class="b2" id="b2">
				      <div>部门名称:<input type="text" name="deptName" id="deptName2"  placeholder="请输入要删除的部门名称"/></div>
	               <div class="b22" id="b22">删除部门</div>
				  </div>
               <!-- 查看部门 -->
              <div class="b21" id="b21">
              <form action="watchDept" method="post">
                   <div>请选择要查看的部门</div>
	                 <select id="dept" name="deptId">
			    					<option value="0">请选择部门</option>
			    					<c:forEach items="${deptList}" var="dept">
			    						<option value="${dept.deptId}">${dept.deptName}</option>
			    					</c:forEach>
	                  </select>
	                 <div><input type="submit" value="确认"/> </div>
	                  </form>
	                  
              </div >
              <!-- 查看某部门的职位 和员工-->
              <div class="b222" id="b222">
                 <form action="addTrain" method="post">
                   <div>请选择要查看的部门</div>
	                 <select id="dept" name="deptId">
			    					<option value="0">请选择部门</option>
			    					<c:forEach items="${deptList}" var="dept">
			    						<option value="${dept.deptId}">${dept.deptName}</option>
			    					</c:forEach>
	                  </select>
	                 <div><input type="submit" value="确认"/> </div>
	                  </form>
              </div>
              
              
               <!-- 增加职位 -->
				 <div class="b3" id="b3">
				 <div><h3>增加职位</h3></div>
				     <div><span>请先选择部门</span>
					  <select id="deptId" name="deptId">
		    						<option value="0">请选择部门</option>
		    					</select>
		    					</div>
		    			<div><input type="text" name="posName" id="posName" placeholder="请输入要添加的职位名称"/></div>		
				     <div class="b33" id="b33">确定增加</div>
				  </div>
              
              
              
               <!-- 查看职位-->
				 <div class="b4" id="b4">
				 <div>查看该职位下的员工</div>
				 <form action="lookpos" method="post">
				      <select id="dept2" name="deptId">
		    					<option value="0">请选择部门</option>
		    					<c:forEach items="${deptList}" var="dept">
		    						<option value="${dept.deptId}">${dept.deptName}</option>
		    					</c:forEach>
		    					
	    					</select>
	    					<select id="position2" name="pid">
	    						<option value="0">请选择职位</option>
	    					</select>
	    					<div><input type="submit" id="b44" value="确认"/></div>
	    					</form>
				  </div>
				  
				  
				  <div class="b5" id="b5">
				      <div>选择要删除的职位</div>
				 <form action="delpos" method="post">
				      <select id="dept3" name="deptId">
		    					<option value="0">请选择部门</option>
		    					<c:forEach items="${deptList}" var="dept">
		    						<option value="${dept.deptId}">${dept.deptName}</option>
		    					</c:forEach>
		    					
	    					</select>
	    					<select id="position3" name="pid">
	    						<option value="0">请选择职位</option>
	    					</select>
	    					<div><input type="submit" id="b55" value="确认"/></div>
	    					</form>
				  
				  </div>
	   </div>
    
 
  
  </div>
</body>
</html>