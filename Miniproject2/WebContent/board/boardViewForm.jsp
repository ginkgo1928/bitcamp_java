<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style type="text/css">
#subject {font-size: 30pt; font-weight: bold; }
</style>

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
	<td colspan="3" valign="top" width="200">
	<pre style="white-space: pre-line; word-break: break-all;">${Boarddto.content}</pre>
	</td>
</tr>

</table>
	<input type="button" value="목록" onclick="location.href='/Miniproject2/board/boardList.do?pg=${pg}'">
	<input type="button" value="답글" onclick="location.href='/Miniproject2/board/boardReplayForm.do?pseq=${Boarddto.seq}&pg=${pg}'">
	<c:if test="${sessionScope.memId == Boarddto.id}">
	<input type = "button" value ="수정" onclick="BoadrModify('${Boarddto.seq}','${pg}')">
	<input type = "button" value ="삭제" onclick="location.href='/Miniproject2/board/boardReplaydelete.do?seq=${Boarddto.seq}&pg=${pg}'">
	</c:if>
</c:if>	

<script type="text/javascript">
function BoadrModify(seq,pg) {
	location.href="/Miniproject2/board/boardModifyForm.do?seq="+seq+"&pg="+pg;
}
</script>
