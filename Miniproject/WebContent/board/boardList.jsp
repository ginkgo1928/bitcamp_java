<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:if test="${memId!=null}"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/boardList.css">
</head>
<body>
<h1 align="center">게시판</h1>
<c:if test="${boli!=null}">
<table border="1" align="center"  rules="rows" width="700" >
	<tr>
	<td width="100" align="center">
	<b>글번호</b>
	</td>
	
	<td width="150" align="left">
	<b>제목</b>

	</td>
	<td width="100" align="center" >
	<b>작성자</b>
	</td>
	<td width="100" align="center">
	<b>작성일</b>
	</td>
	
	<td width="50" align="center">
	<b>조회수</b>
	</td>
</tr>


<c:forEach var="boardDTO" items="${boli}">
<tr>
		<td width="50" align="center"> ${boardDTO.seq}</td>
		<td width="50" align="left">
		<a href="javascript:void(0)" id="subjectA" onclick="isLogin('${boardDTO.seq}','${pg}')">${boardDTO.subject}</a>
		</td>
		<td width="50" align="center">${boardDTO.id}</td>
		<td width="50" align="center">${boardDTO.logtime}</td>
		<td width="50" align="center">${boardDTO.hit}</td>		
</tr>
	</c:forEach>
</table>
<div style="float:left; width:700px; text-align:center;">
	${boardPaging.pagingHTML}
</div>
</c:if>
</body>

<script type="text/javascript">
function isLogin(seq,pg) {
	if("${memId}"=="")
		alert("먼저 로그인 하세요.")
	else
	location.href="/Miniproject/board/boardViewForm.do?seq="+seq+"&pg="+pg;
}
</script>
<html>