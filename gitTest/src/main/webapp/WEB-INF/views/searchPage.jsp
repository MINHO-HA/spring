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
	border: 1px solid black;
	margin: left;
	text-align: center;
}

#secondTable {
	margin: auto;
	border: 1px solid black;
	text-align: center;
}

#thirdTable {
	border: 1px solid black;
	text-align: center;
	margin: auto;
}
</style>
</head>
<body>
	<h1>검색결과 페이지</h1>
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
				</select></td>
				<td><input type="text" placeholder="검색어 입력" name="ITEM_NAME">
					<input type="submit" value="검색"></td>
			</tr>

		</table>
	</form>










	<h2>&lt;Result&gt;</h2>
	<table class="firstTable">
		<tr>
			<td>성별</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?GENDER_ID=1'" value="남성">
			</td>
			<td><input type="button"
				onclick="location.href='searchFilter?GENDER_ID=2'" value="여성">
			</td>
		</tr>
	</table>
	<br>
	<table class="firstTable">
		<tr>
			<td>연령대</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?AGE_ID=1'" value="10대">
			</td>
			<td><input type="button"
				onclick="location.href='searchFilter?AGE_ID=2'" value="20대">
			</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?AGE_ID=3'" value="30대">
			</td>
			<td><input type="button"
				onclick="location.href='searchFilter?AGE_ID=4'" value="40대">
			</td>

		</tr>
	</table>
	<br>
	<table class="firstTable">
		<tr>
			<td>피부타입</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=1'" value="악건성"></td>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=2'" value="건성"></td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=3'" value="중성">
			</td>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=4'" value="지성">
			</td>
		</tr>
		<tr>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=5'" value="악지성">
			</td>
			<td><input type="button"
				onclick="location.href='searchFilter?SKINTYPE_ID=6'" value="민감성">
			</td>
		</tr>
	</table>
	<br>

	<br>
	<br>

	<c:forEach var="searchKeyword" items="${searchKeyword }">
		<table id="thirdTable">
			<tr>
				<td><a href="viewItem?ITEM_ID=${searchKeyword.ITEM_ID }"><img
						src="./resources/img/1.jpg" alt="사진(클릭하면 상세페이지)"></a></td>
			</tr>
			<tr>
				<td>${searchKeyword.ITEM_NAME }</td>
			</tr>
		</table>
	</c:forEach>





</body>
</html>