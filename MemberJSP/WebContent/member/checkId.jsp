<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String id=request.getParameter("id");
	MemberjspDAO dao=MemberjspDAO.getInstance();
	boolean exist=dao.isExistId(id);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%if (exist){ %>
<form name="" method="get" action="checkId.jsp">
<%=id %> 이미 사용중인 아이디 입니다!
<br><br>
아이디<input type="text" name="id">
<input type="submit" value="중복체크">  
</form>
<% }else{ %>
<%=id %>는 사용가능 합니다.
<br><br>
<input type="button" value="사용" onclick="checkIdClose('<%=id%>')"> 
<% }%>


</body>
<script type="text/javascript" src="../js/memberjsp.js">
function checkIdClose () {
	opener.memberjspform.id.value="<%=id%>";
	window.close();
	opener.memberjspform.pwd.focus();
	}

</script>
</html>