<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${Boarddto!=null}" >

<h1 align="left"> ${Boarddto.subject}</h1>

<table border="1"  width="700" frame="hsides" rules="rows">
<tr>
	<th width="70" align="center">글번호</th>
	<th width="70" align="center">작성자</th>
	<th width="70" align="center">조회수</th>
</tr>


<tr>

	<td width="70" align="center"> ${Boarddto.seq}</td>
	<td width="70" align="center">${Boarddto.id}</td>
	<td width="70" align="center">${Boarddto.hit}</td>

</tr>


<tr>
	<td colspan="3" valign="top" width="700" height="500" >
	<pre style="white-space: pre-line; word-break: break-all;">${Boarddto.content}</pre>
	</td>
</tr>

</table>
	<td colspan = 3  height="200" valign="top"  align="left">
	<input type="button" value="목록" onclick="location.href='/Mvcboard/action/boardList.go?pg=${pg}'">
	<c:if test="${sessionScope.memId == boardDTO.id }">
	<input type = "button" value = "수정" onclick="BoadrModify('${Boarddto.seq}','${pg}')">
	<input type = "button" value = "삭제" >
	</c:if>
</c:if>	
</body>
<script type="text/javascript">
function BoadrModify(seq,pg) {
	location.href="/Mvcboard/board/boardModifyForm.go?seq="+seq+"&pg="+pg;
}
</script>
</html>