<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL회원가입</title>
</head>
<body background="/MemberJSP/img/nnj.jpg">
<h1 align="center">JSTL 회원가입</h1>

<form name="memberjspform" method="post" action="../action/jstlWrite.jsp">
<table border="1" align="center">
	<tr>
		<th width="100">이름</th>
		<td><input type="text" name="name" placeholder="이름 입력"  style="width: 200px;"> </td>
	</tr> 
	
	<tr>
	<th width="100">아이디</th>
	<td><input type="text" name="id" placeholder="아이디 입력" style="width: 200px;"></td>		
	</tr>
	
	
	
	<tr>
		<th width="100">패스워드</th>
		<td><input type="password" name="pwd"></td>
	</tr>
	
	
	<tr>
		<td colspan = 3 align = "center"> 
		<input type = "submit" value = "등록">
		<input type = "reset" value = "취소">  
		<input type="button" value="목록 " onclick="location.href='../member/jstlList.jsp'">   
	</td>   
	</tr>    	
</table>
</form>
</body>
</html>