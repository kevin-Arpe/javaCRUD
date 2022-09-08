<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
</head>
<body>
	<h2>메인화면</h2>
	<c:choose>
		<c:when test="${ empty username }">
			<c:redirect url="login.jsp" />
		</c:when>
		<c:otherwise>
			<span>${ username } 님 안녕하세요</span>
			<div style="display: flex">
				<form action="person" method="POST">
					<input type="hidden" name="action" value="logout">
					<input type="submit" value="로그아웃">
				</form>
				&nbsp;
				<form action="person" method="POST">
					<input type="hidden" name="action" value="list">
					<input type="submit" value="목록보기">
				</form>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>