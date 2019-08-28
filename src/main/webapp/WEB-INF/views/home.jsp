<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
	<button class="btn-primary" onclick="fn_codeManager()">코드관리</button>
</body>
<script>
	function fn_codeManager()
	{
		location.href="<%=request.getContextPath()%>/code/codeManager";
	}
</script>
</html>
