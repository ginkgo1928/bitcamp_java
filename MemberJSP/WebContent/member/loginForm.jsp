<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form name="loginform" method="post" action="../action/loginjsp.jsp">
<img src="../img/eoe.png" width="350" height="350" onclick="checkLogin()" style="cursor: pointer;">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id"></td>
	</tr>
	
	
	<tr>
	<th>패스워드</th>
	
	
	<td><input type="password" name="pwd"></td>
	
	</tr>
	
	
	
	<tr>
		<td colspan=2 align="center">
		<input type="button" value="로그인 " onclick="javascript:checkLogin()"> 
		<input type="button" value="회원가입" onclick="location.href ='writeForm.jsp'"></td>
	</tr>
</table>
</form>
<script src="../js/memberjsp.js" type="text/javascript"></script>
</body>
</html>