<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.firstTable {
	margin: auto;
	border: 1px solid black;
	text-align: center;
}

#secondTable {
	margin: auto;
	border: 1px solid black;
	text-align: center;
}

#a {
	float: right;
}
</style>
</head>
<body>
	<h1>제품 상세 페이지</h1>
	<hr>
	<a href="./">LOGO</a>
	<c:choose>
		<c:when test="${not empty sessionScope.session_id }">
			<c:choose>

				<c:when test="${sessionScope.session_id eq 'admin'}">
					<div style="float: right;">관리자님 환영합니다.</div>
				</c:when>
				<c:otherwise>
					<div style="float: right;">
						<a href="myPage">${sessionScope.session_id }</a> 님 환영해요
					</div>
				</c:otherwise>
			</c:choose>
			<br>
			<div style="float: right;">
				<input type="button" value="로그아웃" onclick="location.href='./logout'">
			</div>
		</c:when>
	</c:choose>
	<br>
	<br>
	<form action="searchItem" method="get">

		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<table id="secondTable">
			<tr>
				<td><select name="ITEM_CATEGORY">
						<option value="hair">헤어</option>
						<option value="skincare">스킨케어</option>
						<option value="cleansing">클렌징</option>
						<option value="perfume">향수</option>
				</select>
				</td>
				<td><input type="text" placeholder="검색어 입력" name="ITEM_NAME">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>

	<div id="a">
		<input type="button" onclick="location.href='markItem?ITEM_ID=${itemView.getITEM_ID() }&MEM_ID=${sessionScope.session_id }'" value="찜하기">&nbsp;&nbsp;
		<input type="button" onclick="location.href='reviewForm?ITEM_ID=${itemView.getITEM_ID() }'" value="리뷰작성">
	</div>
	<h2>&lt;Product detail&gt;</h2>
	<table class="firstTable">
		<tr class="firstTable">
			<td class="firstTable">
			<img src="#" alt="사진">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			</td>
			<td class="firstTable">
				제품 아이디 : ${itemView.getITEM_ID() }<br>
				제품 이름 : ${itemView.getITEM_NAME() }<br> 
				제품 브랜드 : ${itemView.getITEM_BRAND() }<br>
			</td>
		</tr>
	</table>
	<br>
	<br>
	<br>
	<h2>&lt;review&gt;</h2>
	<c:forEach var="reviewLists" items="${reviewLists }">
		<table class="firstTable">
			<tr class="firstTable">
				<td class="firstTable">
				<a href="viewReview?REVIEW_ID=${reviewLists.REVIEW_ID }">${reviewLists.REVIEW_CONTENT }</a>
				</td>
				<td class="firstTable">좋아요 갯수 : ${reviewLists.REVIEW_LIKE }<br>
				<input type="button" onclick="location.href='raiseLike?REVIEW_ID=${reviewLists.REVIEW_ID }&ITEM_ID=${itemView.getITEM_ID() }&MEM_ID=${sessionScope.session_id }&TARGET_MEM_ID=${reviewLists.MEM_ID }'" value="좋아요 버튼">
				</td>
			</tr>
		</table>
	</c:forEach>
	
</body>
</html>