<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set value="${pageContext.request.contextPath }" var="path"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>example</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="containerJoin">
		<form id="joinForm" action="${path}/user/joinEnd" method="post">
		아 이 디 : <input type="text" id="userId" name="userId" placeholder="아이디를 입력하세요"> <button type="button" class="btn-primary" id="checkId" name="checkId">중복확인</button> <br>
		# 비밀번호는 5자리 이상 10자리  이하여야 합니다. <br>
		비밀번호 : <input type="password" id="pwd" name="pwd" placeholder="비밀번호를 입력하세요"> <br>
		비밀번호 확인 : <input type="password" id="pwd_2" name="pwd_2" placeholder="비밀번호를 입력하세요"> <br>
		성명 : <input type="text" id="name" name="name" placeholder="성명을 입력하세요"> <br>
		<button type="submit" class="btn-primary m-3">저장</button>
	    </form>
	</div>
</body>
<script>
	var idFlag=false;
	var pwFlag=false;
	
	$("#pwd").blur(function(){
		var pw=$("#pwd").val().trim();
		if(pw.length<5||pw.length>10)
		{
			alert("5자리 이상 10자리 이하여야 합니다.");
			pwFlag=false;
		}
	});
	$("#pwd_2").blur(function(){
		var pw=$("#pwd").val().trim();
		var pw2=$("#pwd_2").val().trim();
		if(pw!=pw2)
		{
			alert("비밀번호 불일치");
			pwFlag=false;
		}
		else
		{
			pwFlag=true;
		}
		
	});
	
	$("#userId").change(function() { //중복확인 후 아이디를 변경했을떄 idFlag를 다시 false로 바꿔줄 함수.
		idFlag=false;
	})
	/* $("#userId").blur(function(){
		console.log(idFlag);
	}) */
	
	$("#checkId").on("click",function(){
		var userId=$("#userId").val().trim();
		if(userId.length<1)
		{
			alert("아이디를 입력하세요");
		}
		else
		{
			console.log('userId====>>' + userId);
			userId = "ID="+userId;
			$.ajax({
				url:"${path}/user/checkId",
				type:'POST',
				data:userId,
				success:function(data)
				{
					console.log(data);
					if(data=="Y")
					{
						alert("사용가능");
						idFlag=true;
					}
					else
					{
						alert("사용불가능");
						idFlag=false;
					}
				},
	            error : function(error) {
	                alert("error : " + error);
	            }
			});
		}
	});
	
	$("#joinForm").submit(function(event){
		let name=$("#name").val().trim();
		console.log("userId : " + userId);
		if(!idFlag) {
			event.preventDefault();
			alert("사용불가 아이디");
			$("#userId").focus();
			return;
		}
		else if(!pwFlag) {
			event.preventDefault();
			alert("사용불가 비밀번호");
			return;
		}
		else if(name==="") {
			event.preventDefault();
			alert("이름을 입력해주세요");
			return;
		}
	});
</script>
</html>