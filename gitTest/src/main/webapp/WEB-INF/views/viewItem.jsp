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
	<h1>제품 상세 페이지</h1>

	<a href="./">logo(메인이동)</a>
	<c:choose>
		<c:when test="${not empty sessionScope.session_id }">
			<c:choose>
				<c:when test="${sessionScope.session_id eq 'admin'}">
		관리자님 환영합니다.
		</c:when>
				<c:otherwise>
					<a href="myPage">${sessionScope.session_id }</a> 님 환영해요~(아이디 클릭시 마이페이지로 이동)
		</c:otherwise>
			</c:choose>
			<input type="button" value="로그아웃" onclick="location.href='./logout'">
		</c:when>
	</c:choose>
	<br>
	<br>
	<h2>제품 상세 페이지</h2>
	<img src="#" alt="사진">
	<input type="button"
		onclick="location.href='markItem?ITEM_ID=${itemView.getITEM_ID() }&MEM_ID=${sessionScope.session_id }'"
		value="찜하기">
	<br> 제품 아이디 : ${itemView.getITEM_ID() }
	<br> 제품 이름 : ${itemView.getITEM_NAME() }
	<br> 제품 브랜드 : ${itemView.getITEM_BRAND() }
	<br>
	<br>
	<br>
	<br> 리뷰 :
	<br>
	<c:forEach var="reviewLists" items="${reviewLists }">
		리뷰내용 : 
		<a href=""> ${reviewLists.REVIEW_CONTENT }</a>
		<br>
		좋아요 갯수 : 	${reviewLists.REVIEW_LIKE }<br>
		<%-- <input type="button" onclick="location.href='raiseLike?REVIEW_ID=${reviewLists.REVIEW_ID }&ITEM_ID=${itemView.getITEM_ID() }'" value="좋아요 버튼"> --%>
		<input type="button"
			onclick="location.href='raiseLike?REVIEW_ID=${reviewLists.REVIEW_ID }&ITEM_ID=${itemView.getITEM_ID() }&MEM_ID=${sessionScope.session_id }&TARGET_MEM_ID=${reviewLists.MEM_ID }'"
			value="좋아요 버튼">
		<br>
		<br>
		<br>
	</c:forEach>




	<br>
	<br>
	<br>
	<br>
	<a href="reviewForm?ITEM_ID=${itemView.getITEM_ID() }">리뷰작성</a>
	<form action="searchItem" method="get">
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<select name="ITEM_CATEGORY">
			<option value="hair">헤어</option>
			<option value="skincare">스킨케어</option>
			<option value="cleansing">클렌징</option>
			<option value="perfume">향수</option>
		</select> <input type="text" placeholder="검색어 입력" name="ITEM_NAME"> <input
			type="submit" value="검색">

	</form>
</body>
</html>