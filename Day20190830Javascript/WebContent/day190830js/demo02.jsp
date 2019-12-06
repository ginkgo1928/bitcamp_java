<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> My First Wep Page</h1>
<h2>My First Paragraph</h2>
<p>문서 로딩이 완료 된  후에<br>
document.write를 호출 하지 마세요.<br>
전체 문서를 덮습니다.
</p>
<p id="demo"></p>
<script>
document.getElementById("demo").innerHTML = 5 + 6;

document.write(5+6);


</script>
</body>
</html>