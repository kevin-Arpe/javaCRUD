<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="ssafy.com.person.dto.Person" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<c:choose>
		<c:when test="${ empty pList }">
			<h3>보여줄 리스트가 없습니다.</h3>
		</c:when>
		<c:otherwise>
			<table style="border: 1px solid white; text-align: center">
				<thead>
					<tr>
						<th style="width: 60px">No</th>
						<th style="width: 90px">이름</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${ pList }">
						<tr>
							<td>${ p.no }</td>
							<td><a href="person?action=info&no=${ p.getNo() }">${ p.name }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:otherwise>
	</c:choose>
	<input type="button" value="추가" onclick="location.href='person?action=registForm'">
</body>
</html>