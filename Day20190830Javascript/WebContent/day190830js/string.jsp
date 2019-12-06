<%@ page language="java" contentType="text/html; charset=UTF-8"
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
var userName=prompt("나의 영문이름은?","");

var upperName=userName.toUpperCase();
document.write(upperName,"<br/>");

var userTel=prompt("나의 연락처는","");

var result=userTel.substring(0,userTel-length-4)+"****";
document.write(result,"<br/>")


}

</script>
</html>