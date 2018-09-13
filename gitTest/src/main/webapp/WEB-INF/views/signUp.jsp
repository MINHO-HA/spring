<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<h1>회원가입 페이지</h1>
	<hr>
	<form action="joinForm" method="POST">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="MEM_ID" placeholder="아이디 입력"
					required="required"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="MEM_PW" placeholder="비밀번호 입력"
					required="required"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="MEM_NAME" placeholder="이름 입력"
					required="required"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="MEM_AGE" placeholder="나이 입력"
					required="required"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="MEM_EMAIL" placeholder="이메일 입력"
					required="required"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td><input type="radio" name="GENDER_ID" value="1">남 <input
					type="radio" name="GENDER_ID" value="2">여</td>
			</tr>
			<tr>
				<td>피부타입</td>
				<td><select name="SKINTYPE_ID">
						<option value="1">악건성</option>
						<option value="2">건성</option>
						<option value="3">중성</option>
						<option value="4">지성</option>
						<option value="5">악지성</option>
						<option value="6">민감성</option>
				</select></td>
			</tr>
			<tr>
				<td>건강상태</td>
				<td><input type="text" name="MEM_INFO" placeholder="건강상태 입력"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입"></td>
			</tr>
		</table>
	</form>



</body>
</html>