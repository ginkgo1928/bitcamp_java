<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<span style="left;">
<img src="../img/zoom.png" onclick="bigimgjoom()"/>
</span>
<table border="1"  cellspacing="0" cellpadding="3">
<tr align="center">
	<th rowspan="4">
	<img src=../storage/${imgdto.image1} width="200" height="200"></th>
	<th width="100">상품명</th>
	<td width="150">${imgdto.imageName}</td>
	</tr>
	
	<tr align="center">
	<th>단가</th>
	<td><fmt:formatNumber value="${imgdto.imagePrice}" type="number"/></td>
	</tr>
	<tr>
	<th>개수</th><td>${imgdto.imageQty}개</td>
	</tr>
	
	<tr>
	<th>합계</th><td>
	<fmt:formatNumber value="${imgdto.imagePrice * imgdto.imageQty}" type="number"/>원</td>
</tr>

<tr>
	<td colspan="3" valign="top" width="200">
	<pre style="white-space: pre-line; word-break: break-all;">${imgdto.imageContent}</pre>
</td>
</tr>
</table>
<input type="button" value="목록" onclick="location.href='/Miniproject2/imgboard/imgboardList.do?pg=${pg}'">
<script type="text/javascript">
function bigimgjoom(){
	var newWindow=window.open("","","width=500 height=500");
	var img = newWindow.document.createElement("img");
	img.setAttribute("src","http://localhost:8090/Miniproject2/storage/${imgdto.image1}");
	img.setAttribute("width","500");
	img.setAttribute("height","500");
	newWindow.document.body.appendChild(img);

	
}
</script>

