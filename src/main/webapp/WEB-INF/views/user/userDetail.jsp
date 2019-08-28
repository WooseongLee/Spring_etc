<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>userDetail</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container col-md-6 mt-5">
	<form id="formDetail" action="${path}/user/userDetailEnd" method="post">
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th class="text-center" colspan="2">상세정보</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><b>*이름 : </b></td>
				<td><input type="text" name="name" placeholder="성명을 입력하세요" required>*은 필수 입력요소입니다</td>
			</tr>
			<tr>
				<td><b>*관계 : </b></td>
				<td>
					<select name="relCd">
						<c:forEach var="relCodeList" items="${relCodeList}">
						<option value="${relCodeList.CDNO}">${relCodeList.CDNAME}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td><b>*우편번호 : </b></td>
				<td><input type="text" name="addrCd" placeholder="우편번호" required></td>
			</tr>
			<tr>
				<td><b>*주소 : </b></td>
				<td><input type="text" name="addrName" placeholder="주소를 입력하세요" required></td>
			</tr>
			<tr>
				<td>휴대전화번호 : </td>
				<td><input type="text" name="mobile" placeholder="휴대전화" id="mobile">휴대전화와  집전화번호 둘 중 하나는 필수</td>
			</tr>
			<tr>
				<td>집전화번호 : </td>
				<td><input type="text" name="homeTel" placeholder="집번호" id="homeTel"></td>
			</tr>
			<tr>				<td><b>*사용여부 : </b></td>
				<td><input type="checkbox" name="useYn" id="useYn" checked value="Y" required><label for="useYn">사용</label></td>
			</tr>
			<tr>
				<td><input type="hidden" value="${userId}" name="userId" id="userId"></td>
				<td><button type="submit" class="btn btn-primary">저장</button> </td>
			</tr>
		</tbody>
	</table>
	</form>
	</div>
</body>
<script>

	$("#formDetail").submit(function(event) {
		var mobile=$("#mobile").val().trim();
		var homeTel=$("#homeTel").val().trim();
		/* let name=$("name").val().trim();
		let addrCd=$("#addrCd").val().trim();
		let addrName=$("#addrName").val().trim();
		let useYn=$("input:checkbox[id='useYn']").is(":checked") == true : false */
		
		/* if(name.length === 0) {
			event.preventDefault();
			alert("이름을 입력해주세요");
			return;
		}
		
		else if(addrCd.length === 0) {
			event.preventDefault();
			alert("우편번호를 입력해주세요");
			return;
		}
		
		else if(addrName.length === 0) {
			event.preventDefault();
			alert("주소를 입력해주세요");
		}
*/		
		if(mobile.length === 0 && homeTel.length === 0) {
			event.preventDefault();
			alert("휴대전화와  집전화번호 둘 중 하나는 필수 입력입니다.");
			$("#mobile").focus();
			return;
		}
		
		/* else if(!useYn) {
			event.preventDefault();
			alert("사용여부에 체크해주세요");
			return;
		} */
	});
</script>
</html>