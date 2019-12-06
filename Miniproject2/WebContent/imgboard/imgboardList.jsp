<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
 
<link rel="stylesheet" href="../css/imgboardList.css">

<form name="imageboardListForm" method="" action="/Miniproject2/imgboard/imgboardDelete.do">
<c:if test="${memId!=null}" />
<h1 align="center">상품목록</h1>

<table border="1" align="center">

<tr>
	<th width="70" align="left"><input type="checkbox" id="all" onclick="checkAll()"><b>번호</b></th>
	<th width="70" align="center"><b>이미지</b></th>
	<th width="100" align="center"><b>상품명</b></th>
	<th width="100" align="center"><b>단가</b></th>
	<th width="70" align="center"><b>개수</b></th>
	<th width="70" align="center"><b>합계</b></th>
</tr>

<c:forEach var ="imgboarddto" items="${imglist}"> 
<tr>
	<td align="center"><input type="checkbox" name="check" value="${imgboarddto.seq}">
	${imgboarddto.seq}</td>
	
	<td align="center">
	<a class="onsubject" style="cursor:pointer;">
	<img src="/Miniproject2/storage/${imgboarddto.image1}"onclick="location.href='/Miniproject2/imgboard/imgboardView.do?seq=${imgboarddto.seq}&pg=${pg}'" width="70" height="70"/>
	</a></td>
	<td align="center">${imgboarddto.imageName}</td>
	<td align="center"><fmt:formatNumber value="${imgboarddto.imagePrice}" pattern="#,###"/>
	<td align="center"><fmt:formatNumber value="${imgboarddto.imageQty}" pattern="#,###"/></td>
	<td align="center"><fmt:formatNumber value="${imgboarddto.imagePrice * imgboarddto.imageQty}" pattern="#,###"/>원</td>
</tr>
	</c:forEach>
</table>

<br>
<div style="float:left; width:80px;">
<input type="button" value="선택삭제" onclick="checkDelete()">
</div>
</form>

<div style="float: left; width: 450px; text-align: center;">
	${imgboardpaging.pagingHTML}
</div>


<script>
function checkAll(){
	var check = document.getElementsByName("check")
	if(document.getElementById("all").checked){
		for(i=0; i<check.length; i++){
			check[i].checked = true;
		}
	}else{
		for(i=0; i<check.length; i++){
			check[i].checked = false;
		}
	}	
}

function checkDelete(){
	var check = document.getElementsByName("check")
	var count=0;
	for(i=0; i<check.length; i++){
		if(check[i].checked) count++;
	}if(count==0) 
		alert("항목을 선택하세요");
	else{
		if(confirm("정말로 삭제하시겠습니까?"))
			document.imageboardListForm.submit();
	}
}
</script>

