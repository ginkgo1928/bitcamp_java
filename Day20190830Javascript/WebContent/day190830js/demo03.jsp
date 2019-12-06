<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JavaScript계산</h2>
<p><b>JavaScript프로그램</b>은 컴퓨터에서
실행 할 <b>명령문</b>의 목록 입니다.
<p id="demo"></p>
<p id="demo1"></p>
<script>
var x,y,z;
x=5; y=6; 
z= x + y;
document.getElementById("demo").innerHTML="The value of z is"+z+
".";

document.getElementById("demo1").innerHTML=(x+y)*2;

</script>
</body>
</html>