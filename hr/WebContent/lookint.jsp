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

width:600px;
margin:100px auto;
}

.end>div{
float: left;
margin-top:10px;
margin-right: 50px;
font-size: 1.2em;
color: blue;
cursor:pointer;

}
.end2>div{
float: left;
margin-top:10px;
margin-right: 50px;
font-size: 1.2em;
color: blue;
cursor:pointer;

}
</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
   $(function () {
	   $("#end").hide();
	   $("#end2").hide();
	if($("#status").val()=="已通知面试"){
		$("#end").show();
	}
	   
	   $("#accpet").click(function(){
		   var s = $("#uid").val();
		   $.ajax({
			  url:"accpet",
			  type:"post",
			  dataType:"text",
			  data:{
			    	uid:s
			    
			    },
			    success:function(data){
					if(data!=null){
						alert(data);
					}
					
				}
		   });
	   });
	   
	   $("#reject").click(function(){
		   var s = $("#uid").val();
		   $.ajax({
			  url:"reject",
			  type:"post",
			  dataType:"text",
			  data:{
				  uid:s
			    
			    },
			    success:function(data){
					if(data!=null){
						alert(data);
					}
					
				}
		   });
	   });
	   
	   
	   if($("#offer").val()=="面试成功"){
			$("#end2").show();
		}
	   $("#accpet2").click(function(){
		   var s = $("#uid").val();
		   $.ajax({
			  url:"accpet2",
			  type:"post",
			  dataType:"text",
			  data:{
			    	uid:s
			    
			    },
			    success:function(data){
					if(data!=null){
						alert(data);
					}
					
				}
		   });
	   });
	   
	   $("#reject2").click(function(){
		   var s = $("#uid").val();
		   $.ajax({
			  url:"reject2",
			  type:"post",
			  dataType:"text",
			  data:{
				  uid:s
			    
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
     <div><a href="user" style="color: black;">返回</a></div>
       <div class="big">
       <table border="1"  cellspacing="0">
           <tr>
                <td colspan="4">简历反馈信息</td>
           </tr>
           <tr>
               <td>是否查看</td>
               <td>是否面试</td>
               <td>面试时间</td>
               <td>是否录用</td>
           </tr>
             <tr>
               <td><input type="text" value="${resume.sign}" id="sign"/></td>
                <td><input type="text" value="${resume.status}" id="status"/></td>
               
               <td><fmt:formatDate value="${resume.date}" pattern="yyyy-MM-dd"/></td>
                <td><input type="text" value="${resume.offer}" id="offer"/></td>
              
           </tr>
       </table>
        <input type="hidden" id="uid" name="uid" value="${resume.uid}"/>
        <div  class="end2" id="end2" >
              <div id="accpet2">接受录用</div>
               <div id="reject2">拒绝录用</div>
        </div>
        
       <div class="end" id="end">
       <div id="accpet">接受面试</div>
        <div id="reject">拒绝面试</div>
        </div>
        </div>
</body>
</html>