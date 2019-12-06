<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="checkidfaliform" method="get" action="/mvcmember/member/checkId.do">
아이디 :${requestScope.id}는  이미 사용중 입니다.<br>
아이디  입력 : <input type="text" name="id">
<input type="submit" value="중복체크"> 
</form>
</body>
<script src="../js/member.js"></script>
</html>