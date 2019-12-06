<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<fmt:requestEncoding value="utf-8"/>
<sql:query var="rs" dataSource="jdbc/oracle">
	select * from usertable where id= '${param.id}'

</sql:query>  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<form name="" method="post" action="../action/jstlMoidfy.jsp">
<body>
<table border="1">

<%-- 	<c:forEach var="row" items="${rs.rowsByIndex}"> --%>
<c:forEach var="row" items="${rs.rows }">
	
	<tr>
	<td width="100">이름<input type="text" name="name" value="${row.name}" ></td>
	</tr>
	
	<tr>
	<td width="100">아이디<input type="text" name="id" value="${row.id}" readonly></td>
	</tr>
	
	
	<tr>
	<td width="100">패스워드 <input type="text"  name="pwd" value="${row.pwd}"></td>
	</tr>
	
	<tr> 
	<td colspan = 2 align = "center">
	<input type = "submit" value = "수정">
	<input type = "button" value = "삭제">  </td>
	</tr>
	</c:forEach>
</table>
</form>
</body>
</html>