<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<style>
	#container {
		width: 60%;
		margin: 0 auto;
		padding: 20px 10px;
	}
</style>
</head>
<body>
	<div id="container">
		<h2>로그인 페이지</h2>
		<form action="person" method="POST">
			<input type="hidden" name="action" value="login">
			아이디 : <input type="text" name="id"><br/>
			비밀번호 : <input type="password" name="password"><br/>
			<input type="submit" value="로그인">
		</form>
	</div>
</body>
</html>