<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<head>
	<title>Index</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="containerlogin">
		<form id="form_login" action="${path}/user/login" method="post">
			<input type="text" id="userId" name="userId" placeholder="아이디"></input><br>
            <input type="password" id="pwd" name="pwd" placeholder="비밀번호"></input><br>
            <button type="submit">로그인</button>
            <button type="button" id="userJoin">회원가입</button>
		</form>
	</div>
	
</body>
</html>
<script>
$("#form_login").submit(function(event) {
	
	var userId=$("#userId").val().trim();
	var pwd=$("#pwd").val().trim();
	
	if(userId.length<1) {
		event.preventDefault();
		alert("아이디를 입력하세요");
		$("#userId").focus();
		return;
	}
	
	else if(pwd.length<1) {
		event.preventDefault();
		alert("비밀번호를 입력하세요");
		$("#pwd").focus();
		return;
	}
});

$("#userJoin").on("click",function(){
	location.href="${path}/user/join";
});
</script>