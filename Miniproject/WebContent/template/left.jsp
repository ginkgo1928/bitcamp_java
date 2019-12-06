<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${memId==null}">
<a href="/Miniproject/member/writeForm.do">회원가입</a><br>
<a href="/Miniproject/member/loginForm.do">로그인</a><br>
</c:if>
<c:if test="${memId!=null}">
<a href="/Miniproject/member/logout.do">로그아웃</a><br>
<a href="/Miniproject/member/modifyForm.do">회원정보수정</a><br>
<a href="/Miniproject/board/boardWriteForm.do">글쓰기</a><br>
</c:if>
<a href="/Miniproject/board/boardList.do?pg=1">목록</a><br>

