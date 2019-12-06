<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%
String id="";
String name="";

id = (String)session.getAttribute("memId"); 
name = (String)session.getAttribute("memName");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">



<title>Insert title here</title>
</head>
<body background="/MemberJSP/img/jj2.jpg">
<h1>TOYSTORY</h1>

<%if(session.getAttribute("memId")==null){ %>

<a href="../member/writeForm.jsp"><b>회원가입</b></a>
<a href="../member/loginForm.jsp"><b>로그인</b></a>
<%}else{%>
<h3><%=name%>님 접속</h3>
<a href="../member/modifyForm.jsp?id=<%=id%>">
<b>회원정보수정</b></a>
<a href="../action/logout.jsp"><b>로그아웃</b></a>
<a href="../board/boardWriteForm.jsp"><b>글쓰기</b></a>

<%}%>


<a href="../action/boardList.jsp?pg=1"><b>목록</b></a>

</body>
</html>

