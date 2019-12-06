<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="boardModifyForm" method="post" action="/Mvcboard/action/boardModify.go">
<!--액션에 주소 값을 넣을 수 없다. post방식 이니까 -->
<input type="hidden" name="seq" value="${Boarddto.seq}"> 
<input type="hidden" name="pg" value="${pg}"> 

<h1>글 수정</h1>
<table border="1" align="left"  width="700" >	
<tr>
	<th width="80"> 제목</th>
	<td><input type="text" name="subject" id="subject" style="width: 500px;" value="${Boarddto.subject}"></td>
</tr>

<tr>
	<th width="80">내용</th>
	<td><textarea name ="content" id="content" style="width:500px; height:500px;">${Boarddto.content}</textarea>
</tr>
	
<tr>
		<td colspan="2" align="center">	
		
		<input type="button" value="수정" onclick="checkBoard()" > 
		<input type="reset" value="다시작성">
	</td>
</tr>
</table>
</form>
</body>
<script src="../js/boardjs.js" type="text/javascript"></script>
</html>