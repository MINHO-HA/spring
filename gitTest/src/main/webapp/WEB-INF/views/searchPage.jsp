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
	<h1>검색결과 페이지</h1>

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
	<h2>Result</h2>
	<h3>검색필터</h3>
	성별 :
	<br>
	<input type="button" onclick="location.href='searchFilter?GENDER_ID=1'"
		value="남성">
	<input type="button" onclick="location.href='searchFilter?GENDER_ID=2'"
		value="여성">
	<br>
	<br> 연령대 :
	<br>
	<input type="button" onclick="location.href='searchFilter?AGE_ID=1'"
		value="10대">
	<input type="button" onclick="location.href='searchFilter?AGE_ID=2'"
		value="20대">
	<br>
	<input type="button" onclick="location.href='searchFilter?AGE_ID=3'"
		value="30대">
	<input type="button" onclick="location.href='searchFilter?AGE_ID=4'"
		value="40대">
	<br>
	<br> 피부타입 :
	<br>
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=1'" value="악건성">
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=2'" value="건성">
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=3'" value="중성">
	<br>
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=4'" value="지성">
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=5'" value="악지성">
	<input type="button"
		onclick="location.href='searchFilter?SKINTYPE_ID=6'" value="민감성">
	<br>
	<br>


	<%-- 성별 :
	<c:choose>
		<c:when test="${personalInfo.getGENDER_ID() == 1 }">
			남
		</c:when>

		<c:when test="${personalInfo.getGENDER_ID() == 2 }">
			여
		</c:when>
	</c:choose>
	<br> 연령대 :
	<c:choose>
		<c:when
			test="${personalInfo.getMEM_AGE() >= 0 and personalInfo.getMEM_AGE() < 20}">
			10대
		</c:when>

		<c:when
			test="${personalInfo.getMEM_AGE() >= 20 and personalInfo.getMEM_AGE() < 30}">
			20대
		</c:when>

		<c:when
			test="${personalInfo.getMEM_AGE() >= 30 and personalInfo.getMEM_AGE() < 40}">
			30대
		</c:when>

		<c:when
			test="${personalInfo.getMEM_AGE() >= 40 and personalInfo.getMEM_AGE() < 50}">
			40대
		</c:when>

		<c:otherwise>
			그외 나이대
		</c:otherwise>
	</c:choose>
	<br> 피부타입 :
	<c:choose>
		<c:when test="${personalInfo.getSKINTYPE_ID() == 1 }">
			악건성
		</c:when>

		<c:when test="${personalInfo.getSKINTYPE_ID() == 2 }">
			건성
		</c:when>

		<c:when test="${personalInfo.getSKINTYPE_ID() == 3 }">
			중성
		</c:when>

		<c:when test="${personalInfo.getSKINTYPE_ID() == 4 }">
			지성
		</c:when>

		<c:when test="${personalInfo.getSKINTYPE_ID() == 5 }">
			악지성
		</c:when>

		<c:when test="${personalInfo.getSKINTYPE_ID() == 6 }">
			민강성
		</c:when>
	</c:choose> --%>

	<br>
	<br>
	<br>
	<br>
	<h3>검색한 상품</h3>

	<c:forEach var="searchKeyword" items="${searchKeyword }">
		<table>
			<tr>
				<td><a href="viewItem?ITEM_ID=${searchKeyword.ITEM_ID }"><img
						src="./resources/img/1.jpg" alt="사진(클릭하면 상세페이지)"></a></td>
			</tr>
			<tr>
				<td>${searchKeyword.ITEM_NAME }</td>
			</tr>
		</table>
	</c:forEach>

	<%-- <a href="viewItem?ITEM_ID=${searchKeyword.getITEM_ID() }"><img src="./resources/img/1.jpg" alt="사진(클릭하면 상세페이지)"></a>
	<br>
	제품 이름  : ${searchKeyword.getITEM_NAME() }<br>
	 --%>
	<%-- 제품 아이디 : ${searchKeyword.getITEM_ID() }<br>
	제품 브랜드 : ${searchKeyword.getITEM_BRAND() }<br> --%>


	<br>
	<br>
	<br>
	<br>
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