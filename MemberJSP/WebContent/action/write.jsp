<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@page import="memberjsp.bean.MemberjspDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	request.setCharacterEncoding("utf-8");
 %>
 
<jsp:useBean id="memberDTO" class="memberjsp.bean.MemberjspDTO"/>
<jsp:setProperty property="*" name="memberDTO"/>

<%
	MemberjspDAO memberDAO = MemberjspDAO.getInstance();
int su = memberDAO.write(memberDTO);
%>

<html>
<head>
<title>서버</title>
</head>
<body background="/MemberJSP/img/toy3.jpg">
<%if(su==1){ %>
	회원가입 되었습니다.
	<br><br>
	<input type='button' value='로그인' onclick="location.href='../member/loginForm.jsp'">
<%}else{ %>
	다시 작성해주세요
<%} %>
 
</body>
</html>