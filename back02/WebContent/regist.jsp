<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등록/수정</title>
</head>
<body>
	<%
	
	%>
	<form action="person" method="POST">
		<input type="hidden" name="action" value="${ type }">
		<table>
			<tr>
				<td>사용자 번호 : </td>
				<td><input type="number" name="no" value="${ person.getNo() }" required></td>
			</tr>
			<tr>
				<td>이름 : </td>
				<td><input type="text" name="name" value="${ person.getName() }" required></td>
			</tr>
			<tr>
				<td>나이 : </td>
				<td><input type="number" min="0" name="age" value="${ person.getAge() }" required></td>
			</tr>
			<tr>
				<td>소개 글 : </td>
				<td><textarea name="msg" required>${ person.getMsg() }</textarea></td>
			</tr>
		</table>
		<c:choose>
			<c:when test="${ type == 'regist' }">
				<button type="submit">추가</button>
			</c:when>
			<c:otherwise>
				<button type="submit">완료</button>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>