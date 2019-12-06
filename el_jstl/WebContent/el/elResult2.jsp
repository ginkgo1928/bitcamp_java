<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="angel" uri="tld" %>
<!--형식이 없어서 파일로 만듬 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>자바클래스의 메소드를 이용하여 계산</h3>
<!--자바 sum이라는 메서드 호출   sum이 어디 있는지 모르니까 aaa를 따라와라 알려줌-->
${param['x'] } + ${param['y'] } = ${angel:sum(param['x'],param['y']) }<br>
${param['x'] } * ${param['y'] } = ${angel:mul(param['y'],param['y']) }<br>

</body>
</html>