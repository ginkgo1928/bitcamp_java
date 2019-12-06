<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<link rel="stylesheet" href="../css/boardList.css">
<c:if test="${memId!=null}" />
<h1 align="center">게시판</h1>
<c:if test="${boli!=null}">
	<table border="1" align="center" rules="rows" width="700">
		<tr>
			<td width="100" align="center"><b>글번호</b></td>
			<td width="150" align="left"><b>제목</b></td>
			<td width="100" align="center"><b>작성자</b></td>
			<td width="100" align="center"><b>작성일</b></td>
			<td width="50" align="center"><b>조회수</b></td>
		</tr>

		<c:forEach var="boardDTO" items="${boli}">
			<tr>
			
				<td width="50" align="center">${boardDTO.seq}</td>
				<td width="50" align="left">
			<c:forEach var="i" begin="1" end="${boardDTO.lev}" step="1">
				&emsp;
			</c:forEach>
				<c:if test="${boardDTO.pseq!=0}">
				<img src="../img/reply.gif">
				</c:if>
				<a href="javascript:void(0)" id="subjectA" onclick="isLogin('${boardDTO.seq}','${pg}')">
				${boardDTO.subject}
				</a></td>
				<td width="50" align="center">${boardDTO.id}</td>
				<td width="50" align="center">${boardDTO.logtime}</td>
				<td width="50" align="center">${boardDTO.hit}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>

<form name="" method="post" action="/Miniproject2/board/boardSearch.do">
<div style="text-align:center;">
<input type="hidden" name="pg" value="1">
<select name="searchOption" id="searchOption" style="width:80px;">
<option value="subject">제목
<option value="id">아이디
</select>
<input type="text" name="keyword" value="${keyword}" placeholder="검색어 입력">
<input type="submit" value="검색">
</div>

<div style="float: left; width: 500px; text-align: center;">
	${boardPaging.pagingHTML}
</div>
</form>

<script type="text/javascript">
function isLogin(seq,pg) {
	if("${memId}"=="")
		alert("먼저 로그인 하세요.")
	else
	location.href="/Miniproject2/board/boardViewForm.do?seq="+seq+"&pg="+pg;
}
window.onload=function(){
	if('${searchOption}'=='subject' || '${searchOption}'=='id')
		document.getElementById('searchOption').value = '${searchOption}';
}

function boardSearch(pg){
	location.href="/miniproject/board/boardSearch.do?pg="+pg
			+"&searchOption=${searchOption}"
			+"&keyword="+encodeURIComponent("${keyword}");
}
</script>


