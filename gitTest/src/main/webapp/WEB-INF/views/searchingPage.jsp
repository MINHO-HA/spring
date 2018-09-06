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
	<h2>Result</h2>
	성별 :
	<c:choose>
		<c:when test="${personalInfo.getGENDER_ID() == 1 }">
			남
		</c:when>

		<c:when test="${personalInfo.getGENDER_ID() == 2 }">
			여
		</c:when>
	</c:choose>
	<br>
	
	연령대 : 
	<c:choose>
		<c:when test="${personalInfo.getMEM_AGE() >= 0 and personalInfo.getMEM_AGE() < 20}">
			10대
		</c:when>
		
		<c:when test="${personalInfo.getMEM_AGE() >= 20 and personalInfo.getMEM_AGE() < 30}">
			20대
		</c:when>
		
		<c:when test="${personalInfo.getMEM_AGE() >= 30 and personalInfo.getMEM_AGE() < 40}">
			30대
		</c:when>
		
		<c:when test="${personalInfo.getMEM_AGE() >= 40 and personalInfo.getMEM_AGE() < 50}">
			40대
		</c:when>
		
		<c:otherwise>
			그외 나이대
		</c:otherwise>
	</c:choose>
	<br>
	
	피부타입 : 
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
	</c:choose>
	
	<br>
	<br>
	<br>
	
	
	
	검색한 상품<br> 
	제품 아이디 : ${searchKeyword.getITEM_ID() }<br>
	제품 이름  : ${searchKeyword.getITEM_NAME() }<br>
	제품 브랜드 : ${searchKeyword.getITEM_BRAND() }<br>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>