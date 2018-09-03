<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	login Page
	<form action=login method="POST" id="frm">
		<label> 아이디 : <input type="text" name="MEM_ID"
			placeholder="아이디를 입력하세요" />
		</label> <br> <label> 비밀번호 : <input type="password" name="MEM_PW"
			placeholder="비밀번호를 입력하세요" />
		</label> <input type="submit" value="로그인">

	</form>
</body>
</html>