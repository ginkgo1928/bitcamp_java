<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   


<!--request 생략가능-->
아이디 : ${id}는 사용 가능 합니다. 
<input type="button" value="사용" onclick="checkIdClose('${id}')"> 
<script src="../js/member.js"></script>
