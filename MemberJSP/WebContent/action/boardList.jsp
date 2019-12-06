<%@page import="board.bean.BoarbPaing"%>
<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO" />

<%
	request.setCharacterEncoding("utf-8");

//세션
String memId="";
if(session.getAttribute("memId")!=null)
memId=(String)session.getAttribute("memId");

//데이터
int pg=Integer.parseInt(request.getParameter("pg"));

//페이지
int endNum=pg*5;
int startNum=endNum-4;
List<BoardDTO>boli=boardDAO.boardlist(startNum, endNum);


//페이징 
BoarbPaing boardPaging = new BoarbPaing(); 
int totalA=boardDAO.getTotalA();
boardPaging.setCurrentPage(pg);
boardPaging.setPageBlock(5);
boardPaging.setPageSize(4);
boardPaging.setTotalA(totalA);
boardPaging.makePagingHTML();

//조회수-->새로고침 조회수 방지
//(세션이 null이 아니라면)
if(session.getAttribute("memId")!=null){
	Cookie cookie=new Cookie("memHit","0");
	cookie.setMaxAge(30*60);
	cookie.setPath("/");
	response.addCookie(cookie); //클라이언트에게 보내기
}
%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
 
<link rel="stylesheet" href="../css/boardList.css">

<div>
	<img src="../img/eoe.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor:pointer;">
</div>
</head>
<body background="/MemberJSP/img/nnj.jpg">
<h1 align="center">게시판</h1>
<%if(boli!=null){%>
<form  name="boardListform" method="post" action="../board/boardView.jsp">
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
<%for(BoardDTO boardDTO : boli){%>
<tr>
		<td width="50" align="center"> <%=boardDTO.getSeq()%></td>
		<td width="50" align="left">
		<a href="javascript:void(0)" id="subjectA"  onclick="isLogin(<%=boardDTO.getSeq()%>,<%=pg%>)">
		<%=boardDTO.getSubject()%></a>
		</td>
		<td width="50" align="center"><%=boardDTO.getId()%></td>
		<td width="50" align="center"><%=boardDTO.getLogtime()%></td>
		<td width="50" align="center"><%=boardDTO.getHit()%></td>
		
</tr>
	<%}//for%>
</table>

<div style="float:left; width:1600px; text-align:center;">
	<%=boardPaging.getPagingHTML()%>
</div>

<%}//if%>

</form>
</body>
<script type="text/javascript">
function isLogin(seq,pg) {
	//""를 안 쓰면 문자열로 인식함 null도 마찬가지다.
	//ID가 null일 경우 세션에 검사할 때 null을 막는다.

	if("<%=memId%>"=="")
		alert("먼저 로그인하세요!")
	else 
		location.href="../board/boardView.jsp?seq="+seq+"&pg="+pg;
	
}
</script>
<html>