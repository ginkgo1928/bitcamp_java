<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드</title>
</head>
<body background="/MemberJSP/img/toy3.jpg">
<form name="fileform" enctype="multipart/form-data" method="post" action="fileUpLoad.jsp">
<table border="1"cellspacing="0" cellpadding="5" >

<h1>파일업로드</h1>

<tr>

	<th> 제목</th>
	<td><input type="text" name="subject" id="subject" size=50> </td>
</tr>

<tr>
	<th>내용</th>
	<td><textarea name ="content" id="content" rows="15" cols="50"></textarea>
</tr>
<tr>
	<td colspan="2">
	<input type="file" name="upload1"  size="70" >
</tr>
	
	
	
<tr>
	<td colspan="2">
	<input type="file" name="upload2"  size="70" >
	</td>
</tr>
	
<tr>
		<td colspan="2" align="center">
		<input type="submit" value="파일업로드"> 
		<input type="reset" value="다시작성">
	
	</td>
</tr>
</table>
</form>
</body>
</html>
<!-- C:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps 실제 폴더위치-->