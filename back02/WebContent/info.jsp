<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세정보</title>
</head>
<body>
	<table>
		<tr>
			<td>사용자 번호 : </td>
			<td>${ person.getNo() }</td>
		</tr>
		<tr>
			<td>이름 : </td>
			<td>${ person.getName() }</td>
		</tr>
		<tr>
			<td>나이 : </td>
			<td>${ person.getAge() }</td>
		</tr>
		<tr>
			<td>소개 글 : </td>
			<td>${ person.getMsg() }</td>
		</tr>
	</table>
	<button type="button" onclick="location.href='person?action=updateForm&no=${ person.getNo() }'">수정</button>
	<button type="button" onclick="location.href='person?action=delete&no=${ person.getNo() }'">삭제</button>
	<button type="button" onclick="location.href='person?action=list'">리스트</button>
</body>
</html>