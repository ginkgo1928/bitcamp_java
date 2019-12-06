<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
function demotest() {
	document.getElementById("demot").innerHTML="Paragraph changed.";
}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>JavaScript 무엇을 할 수 있습니까?</h2>
<p id="demo">dispaly의 none로 값을 숨었다.</p>
<p id="demo1" style="display:none">이번에는 display로 block으로 숨견진 값 등장 </p>
<h1>A Web Page</h1>
<p id="demot">A Paragraph</p>
<button type="button" onclick="demotest()">Try it</button>
<button type="button" onclick="document.getElementById('demo').style.display='none'"> 숨음
</button>


<button type="button" onclick="document.getElementById('demo1').style.display='block'">등장 
</button>
</body>
</html>