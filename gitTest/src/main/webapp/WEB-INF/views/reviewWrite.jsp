<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function goBack() {
		window.history.back();
	}
</script>
<style>


#secondTable {
	margin: auto;
	border: 1px solid black;
	text-align: center;
}

</style>
</head>
<%
	request.getParameter("ITEM_ID");
%>
<body>
	<h1>리뷰 작성 페이지</h1>

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

	<form action="writeReviewForm" method="POST">
		<input type="submit" value="리뷰등록"> &nbsp;&nbsp; 
		<input type="button" value="뒤로가기" onclick="goBack()"> <br><br>
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<input type="hidden" name="ITEM_ID" value="<%=request.getParameter("ITEM_ID")%>"> 
		제목 : 
		<input type="text" name="REVIEW_TITLE"><br>
		<textarea rows="30" cols="50" name="REVIEW_CONTENT">글 내용을 작성하세요</textarea>
		<br> 
		별점 : 
		<select name="REVIEW_GRADE">
			<option value="1">1점</option>
			<option value="2">2점</option>
			<option value="3">3점</option>
			<option value="4">4점</option>
			<option value="5">5점</option>
		</select><br>
	</form>
</body>
</html>