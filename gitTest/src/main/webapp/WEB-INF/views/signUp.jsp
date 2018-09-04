<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<form action="joinForm" method="POST" name="frm" id="frm">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="MEM_ID">
				</td>
				
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="MEM_PW"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="MEM_NAME"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="MEM_AGE"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="MEM_GENDER" value="male">남 <input
					type="radio" name="gender" value="female">여</td>
			</tr>
			<tr>
				<td>피부타입</td>
				<td><input type="text" name="MEM_SKINTYPE"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>
	
	<script>
		function idOverlap() {
			$.ajax({
				type : "post",
				url : "idOverlap",
				data : {"id" : frm.MEM_ID.value},
				dataType : "text",
				success : function(data) {
					if(data=="1")
						alert("사용가능");
					else
						alert("사용불가");
				},
				error : function(request, status, error) {
					alert("code : "+ request.status + "\n" + "message : " + request.responseText + "\n" + "error : " + request.error);
				}
			});			
		}
	</script>

</body>
</html>