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
<img src="#" alt="사진"><br>
제품 아이디 : ${itemView.getITEM_ID() }<br>
제품 이름  : ${itemView.getITEM_NAME() }<br>
제품 브랜드 : ${itemView.getITEM_BRAND() }<br>
리뷰 : <br>

<a href="writeReview?ITEM_ID=${itemView.getITEM_ID() }">리뷰작성</a>

</body>
</html>