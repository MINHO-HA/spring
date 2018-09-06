<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>제품 상세 페이지</h2>

제품 아이디 : ${itemView.getITEM_ID() }<br>
제품 이름  : ${itemView.getITEM_NAME() }<br>
제품 브랜드 : ${itemView.getITEM_BRAND() }<br>
</body>
</html>