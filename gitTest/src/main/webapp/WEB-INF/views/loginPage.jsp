<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 페이지</h1>
	<hr>
	<form action="login" method="POST" id="frm">
		<label> 아이디 : <input type="text" name="MEM_ID"
			placeholder="아이디를 입력하세요" required="required" />
		</label> <br> <label> 비밀번호 : <input type="password" name="MEM_PW"
			placeholder="비밀번호를 입력하세요" required="required" />
		</label> <input type="submit" value="로그인"> <br> 처음이세요?<a
			href="signUp">가입하기</a>


	</form>
</body>
</html>