<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.secondTable,tr,td {
	margin: auto;
	border: 1px solid black;
	text-align: center;
}
#a{
	text-align: center;
}
</style>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</head>
<body>
	<h1>리뷰 상세 페이지</h1>

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
		<table class="secondTable">
			<tr>
				<td>
					<select name="ITEM_CATEGORY">
						<option value="hair">헤어</option>
						<option value="skincare">스킨케어</option>
						<option value="cleansing">클렌징</option>
						<option value="perfume">향수</option>
					</select>
				</td>
				<td>
					<input type="text" placeholder="검색어 입력" name="ITEM_NAME">
					<input type="submit" value="검색">
				</td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<div id="a">
		<input type="button" onclick="location.href='raiseLike?REVIEW_ID=${viewReview.REVIEW_ID }&ITEM_ID=${viewReview.ITEM_ID }&MEM_ID=${sessionScope.session_id }&TARGET_MEM_ID=${reviewLists.MEM_ID }'" value="좋아요 버튼"> &nbsp;&nbsp; 
		<input type="button" value="뒤로가기" onclick="goBack()">
	</div>
	<br><br>
	<table class="secondTable">
		<tr>
			<td>
				제목 : ${viewReview.REVIEW_TITLE }
			</td>
			<td>
				작성자 : 	
						${memInfo.MEM_NAME } / 
				<c:choose>
					<c:when test="${memInfo.GENDER_ID == 1 }">
						남 / 
					</c:when>
					<c:when test="${memInfo.GENDER_ID == 2 }">
						여 / 
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${memInfo.MEM_AGE >= 0 and memInfo.MEM_AGE < 20}">
						10대 / 
					</c:when>
					<c:when test="${memInfo.MEM_AGE >= 20 and memInfo.MEM_AGE < 30}">
						20대 / 
					</c:when>
					<c:when test="${memInfo.MEM_AGE >= 30 and memInfo.MEM_AGE < 40}">
						30대 / 
					</c:when>
					<c:when test="${memInfo.MEM_AGE >= 40 and memInfo.MEM_AGE < 50}">
						40대 / 
					</c:when>
					<c:otherwise>
						50대 이상 / 
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${memInfo.SKINTYPE_ID == 1 }">
						악건성
					</c:when>
					<c:when test="${memInfo.SKINTYPE_ID == 2 }">
						건성
					</c:when>
					<c:when test="${memInfo.SKINTYPE_ID == 3 }">
						중성
					</c:when>
					<c:when test="${memInfo.SKINTYPE_ID == 4 }">
						지성
					</c:when>
					<c:when test="${memInfo.SKINTYPE_ID == 5 }">
						악지성
					</c:when>
					<c:when test="${memInfo.SKINTYPE_ID == 6 }">
						민강성
					</c:when>
				</c:choose>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				글내용 : ${viewReview.REVIEW_CONTENT }
			</td>
		</tr>
		<tr>
			<td colspan="2">
				별점 : ${viewReview.REVIEW_GRADE }
			</td>
		</tr>
	</table>		
</body>
</html>