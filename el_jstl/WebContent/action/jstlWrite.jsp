<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql"  uri="http://java.sun.com/jsp/jstl/sql"%>    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>  
 
<fmt:requestEncoding value="utf-8"/>

<sql:update var ="su" dataSource="jdbc/oracle">
insert into usertable values('${param.name}','${param.id}','${param.pwd}')
</sql:update>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${su==1 }">등록성공</c:if>
<c:if test="${su!=1 }">등록실패</c:if>
<br><br>
<input type="button" value="목록" onclick="location.href='../member/jstlList.jsp'">

</body>
</html>