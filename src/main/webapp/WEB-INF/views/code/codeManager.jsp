<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Code</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container col-md-6" style="overflow:scroll; height:50%;">
	<table id="codeList" class="table">
		<thead class="thead-dark">
		<tr>
			<th>코드번호</th>
			<th>코드레벨</th>
			<th>상위코드</th>
			<th>코드이름</th>
			<th>사용여부</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="codes" items="${codes}">
		<tr>
			<td>${codes.cdno}</td>
			<td>${codes.cdlvl}</td>
			<td>${codes.upcd}</td>
			<td>${codes.cdname}</td>
			<c:choose>
			<c:when test="${codes.useyn eq 'Y'}">
			<td><input type="checkbox" id="useyn" checked="checked"/></td>
			</c:when>
			<c:otherwise>
			<td><input type="checkbox" id="useyn"/></td>
			</c:otherwise>
			</c:choose>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	<div class="container col-md-6" id="result">
		<h3>코드내용</h3>
		코드번호 : <br>
		코드레벨 : <br>
		상위코드 : <br>
		코드이름 : <br>
		사용여부 : 
		<input type="checkbox"/>
	</div>
	<div class="container col-md-6">
		<button id="buttonAdd">추가</button>
		<button id="buttonChange">수정</button>
		<button id="buttonSave">저장</button>
	</div>
</body>
<script>
	$("#buttonAdd").click(function() {

		let cdno = "";
		let cdlvl = `<br>코드레벨 : <input type=text id="cdlvl"><br>`;
		let upcd = `상위코드 : <input type=text id="upcd"><br>`;
		let cdname = `코드이름 : <input type=text id="cdname"><br>`;
		let useyn = `사용여부 : <input type=checkbox id="useyn" checked="checked"><br>`;
		
		let cdnoMax = $("#cdno").val();
		$.ajax({
			url:"${path}/code/getMaxCodeNo",
			type:'POST',
			data:cdnoMax,
			success:function(data)
			{
				console.log(data);
				cdno = data + "<br>";
				console.log("cdno : " + cdno);
			},
            error : function(error) {
                alert("error : " + error);
            }
		});

		console.log("cdno : " + cdno);
		let str = "<h3>코드내용</h3>" + cdno + cdlvl + upcd + cdname + useyn;
		$("#result").html(str);
	});
	
	$("#codeList tr").click(function() {
		let str = "";
		
		let tr = $(this);
		let td = tr.children();

		let cdno = td.eq(0).text();
		let cdlvl = td.eq(1).text();
		let upcd = td.eq(2).text();
		let cdname = td.eq(3).text();
		let useyn = td.eq(4).find('input[type="checkbox"]').is(':checked');
		
		str = "<h3>코드내용</h3>" + "코드번호 : " + cdno + "<br>코드레벨 : " + cdlvl + "<br>상위코드 : " + upcd + "<br>코드이름 : " + cdname;
		
		if(useyn) {
			str = str + "<br>사용여부 : " + "<input type='checkbox' checked='checked'/>"
		} else {
			str = str + "<br>사용여부 : " + "<input type='checkbox'/>"
		}
		
		$("#result").html(str);
	});
	
	/* $("#buttonAdd").click(function() {
		
	}); */
	
</script>
</html>
