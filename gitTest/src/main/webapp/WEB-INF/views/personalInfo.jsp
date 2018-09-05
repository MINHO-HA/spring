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
<form action="modifyPersonalInfo?MEM_ID=${personalInfo.getMEM_ID() }" method="post">
아이디 : ${personalInfo.getMEM_ID() }<br>
이름 : <input type="text" name="MEM_NAME" value=${personalInfo.getMEM_NAME() }><br>
나이 : <input type="text" name="MEM_AGE" value=${personalInfo.getMEM_AGE() }><br>
이메일 : <input type="email" name="MEM_EMAIL" value=${personalInfo.getMEM_EMAIL() }><br>
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
<br>






피부타입 : 
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
<br>


건강상태 : <input type="text" name="MEM_STATE" value=${personalInfo.getMEM_STATE() }>

<br>
<input type="submit" value="정보변경">
</form>

</body>
</html>