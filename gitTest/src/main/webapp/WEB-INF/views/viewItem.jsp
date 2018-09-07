<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>제품 상세 페이지</h2>
	<img src="#" alt="사진">
	<br> 제품 아이디 : ${itemView.getITEM_ID() }
	<br> 제품 이름 : ${itemView.getITEM_NAME() }
	<br> 제품 브랜드 : ${itemView.getITEM_BRAND() }
	<br> 리뷰 :
	<br><br><br>
	<c:forEach var="reviewLists" items="${reviewLists }">
		리뷰내용 : 
		<a href="">	${reviewLists.REVIEW_CONTENT }</a><br>
		좋아요 갯수 : 	${reviewLists.REVIEW_LIKE }<br>
		<input type="button" onclick="location.href=''" value="좋아요 버튼">
		<br><br><br>
	</c:forEach>





	<a href="writeReview?ITEM_ID=${itemView.getITEM_ID() }">리뷰작성</a>

</body>
</html>