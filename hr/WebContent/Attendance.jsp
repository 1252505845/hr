<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a{
text-decoration:none;
color: #CF5202;
}
.b{
width: 110px;
}
.b>div{
width: 100px;
background-color: #FEF3AD;
margin-bottom: 20px;
text-align: center;
}

</style>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function () {
			$("#onCard").click(function () {
				  $.ajax({
					  url:"on",
					  type:"post",
					 dataType:"text",
					 data:{
					 },
					 success:function(data){
						 if(data!=null){
							 alert(data);
						 }
					 }
					
				  });
			});

			$("#offCard").click(function () {
				  $.ajax({
					  url:"off",
					  type:"post",
					 dataType:"text",
					 data:{
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
<div><a href="emp">返回</a></div>
<div class="b">
    <div><a href="#" id="onCard">上班打卡</a></div>
    <div><a href="#" id="offCard">下班打卡</a></div>
    <div><a href="lookmyAtt">我的考勤信息</a></div>
</div>

</body>
</html>