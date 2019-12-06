<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<h3><img src="../img/pa.jpg" width="50" height="50" 
onclick="location.href='/Miniproject2/main/index.do'" style="cursor: pointer;">
MVC를 이용한 미니프로젝트</h3>
<br><br>
<c:if test="${memId!=null}">
<a href="/Miniproject2/board/boardWriteForm.do">글쓰기</a>&emsp;
</c:if>
<c:if test="${memId=='hyun3761' && hyunpwd=='3761'}">
<a href="/Miniproject2/imgboard/imgboardWriteForm.do">이미지등록</a>&emsp;
</c:if>
<a href="/Miniproject2/imgboard/imgboardList.do?pg=1">상품목록</a>&emsp;
<a href="/Miniproject2/board/boardList.do?pg=1">목록</a>
