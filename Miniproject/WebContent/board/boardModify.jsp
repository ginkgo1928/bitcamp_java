<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<script type="text/javascript">
window.onload=function(){
	alert("글이 수정되었습니다.");
	location.href="/Mvcboard/action/boardList.go?pg=${param.pg}";
}

</script>
</html>
