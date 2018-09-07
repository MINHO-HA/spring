<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
</head>
<%
	request.getParameter("ITEM_ID");
%>
<body>
	<h2>리뷰작성 페이지</h2>
	<form action="reviewWritingForm" method="POST">
		<input type="hidden" name="MEM_ID" value="${sessionScope.session_id }">
		<input type="hidden" name="ITEM_ID" value="<%=request.getParameter("ITEM_ID")%>"> 
		제목 :
		<input type="text" name="REVIEW_TITLE"><br> 글 내용 :<br>
		<textarea rows="50" cols="100" name="REVIEW_CONTENT">글 내용을 작성하세요</textarea>
		<br> 별점 : <select name="REVIEW_GRADE">
			<option value="1">1점</option>
			<option value="2">2점</option>
			<option value="3">3점</option>
			<option value="4">4점</option>
			<option value="5">5점</option>
		</select><br> <input type="submit" value="리뷰등록"> <input
			type="button" value="뒤로가기" onclick="goBack()">
	</form>
</body>
</html>