<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
}
</style>
</head>
<body>
	<h1>개인정보 변경 페이지</h1>

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
	<br> ${sessionScope.session_id }님의 마이 페이지

	<br>

	<ul>
		<li style="font-weight: bold;">개인정보 수정</li>
		<li><a href="reviewsIWrote?MEM_ID=${sessionScope.session_id }">내가
				쓴 리뷰</a></li>
		<li><a
			href="reviewsILiked?TARGET_MEM_ID=${sessionScope.session_id }">좋아요
				한 리뷰</a></li>
		<li><a href="listsIMarked?MEM_ID=${sessionScope.session_id }">제품
				찜 목록</a></li>
	</ul>
	<br>
	<form action="modifyPersonalInfo?MEM_ID=${personalInfo.getMEM_ID() }"
		method="post">
		아이디 : ${personalInfo.getMEM_ID() }<br> 이름 : <input type="text"
			name="MEM_NAME" value=${personalInfo.getMEM_NAME() }><br>
		나이 : <input type="text" name="MEM_AGE"
			value=${personalInfo.getMEM_AGE() }><br> 이메일 : <input
			type="email" name="MEM_EMAIL" value=${personalInfo.getMEM_EMAIL() }><br>
		성별 :
		<c:choose>
			<c:when test="${personalInfo.getGENDER_ID() == 1 }">
				<input type="radio" name="GENDER_ID" value="1" checked="checked">남 
			<input type="radio" name="GENDER_ID" value="2">여
		</c:when>

			<c:when test="${personalInfo.getGENDER_ID() == 2 }">
				<input type="radio" name="GENDER_ID" value="1">남 
			<input type="radio" name="GENDER_ID" value="2" checked="checked">여
		</c:when>
		</c:choose>
		<br> 피부타입 :
		<c:choose>
			<c:when test="${personalInfo.getSKINTYPE_ID() == 1 }">
				<select name="SKINTYPE_ID">
					<option value="1" selected="selected">악건성</option>
					<option value="2">건성</option>
					<option value="3">중성</option>
					<option value="4">지성</option>
					<option value="5">악지성</option>
					<option value="6">민감성</option>
				</select>
			</c:when>

			<c:when test="${personalInfo.getSKINTYPE_ID() == 2 }">
				<select name="SKINTYPE_ID">
					<option value="1">악건성</option>
					<option value="2" selected="selected">건성</option>
					<option value="3">중성</option>
					<option value="4">지성</option>
					<option value="5">악지성</option>
					<option value="6">민감성</option>
				</select>
			</c:when>

			<c:when test="${personalInfo.getSKINTYPE_ID() == 3 }">
				<select name="SKINTYPE_ID">
					<option value="1">악건성</option>
					<option value="2">건성</option>
					<option value="3" selected="selected">중성</option>
					<option value="4">지성</option>
					<option value="5">악지성</option>
					<option value="6">민감성</option>
				</select>
			</c:when>

			<c:when test="${personalInfo.getSKINTYPE_ID() == 4 }">
				<select name="SKINTYPE_ID">
					<option value="1">악건성</option>
					<option value="2">건성</option>
					<option value="3">중성</option>
					<option value="4" selected="selected">지성</option>
					<option value="5">악지성</option>
					<option value="6">민감성</option>
				</select>
			</c:when>

			<c:when test="${personalInfo.getSKINTYPE_ID() == 5 }">
				<select name="SKINTYPE_ID">
					<option value="1">악건성</option>
					<option value="2">건성</option>
					<option value="3">중성</option>
					<option value="4">지성</option>
					<option value="5" selected="selected">악지성</option>
					<option value="6">민감성</option>
				</select>
			</c:when>

			<c:when test="${personalInfo.getSKINTYPE_ID() == 6 }">
				<select name="SKINTYPE_ID">
					<option value="1">악건성</option>
					<option value="2">건성</option>
					<option value="3">중성</option>
					<option value="4">지성</option>
					<option value="5">악지성</option>
					<option value="6" selected="selected">민감성</option>
				</select>
			</c:when>
		</c:choose>
		<br> 건강상태 : <input type="text" name="MEM_INFO"
			value=${personalInfo.getMEM_INFO() }> <br> <input
			type="submit" value="정보변경">
	</form>
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