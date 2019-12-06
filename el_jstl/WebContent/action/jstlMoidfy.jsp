<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<sql:update dataSource="jdbc/oracle" var="su">
update usertable set name='${param.name}',pwd='${param.pwd}' where id= '${param.id}'
</sql:update>

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
	alert("수정완료!");
	location.href="../member/jstlList.jsp";
}
</script>
</html>