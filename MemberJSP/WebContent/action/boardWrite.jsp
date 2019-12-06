<%@page import="memberjsp.bean.MemberjspDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

 
<% 
request.setCharacterEncoding("utf-8");

String subject = request.getParameter("subject");
String content = request.getParameter("content");


String name = (String)session.getAttribute("memName");
String id = (String)session.getAttribute("memId");
String email = (String)session.getAttribute("memEmail");

BoardDTO boardDTO=new BoardDTO();
boardDTO.setId(id);
boardDTO.setName(name);
boardDTO.setEmail(email);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

BoardDAO boardbao=BoardDAO.getInstance();
int cnt=boardbao.write(boardDTO);
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>

	if(<%=cnt%>==1){
		alert("글이 등록되었습니다.");
		
	}else{
		alert("다시작성해주세요.");
	}
</script>
</head>
<body background="/MemberJSP/img/nnj.jpg">
<%if(cnt==1){ %>
	<%response.setHeader("Refresh", "1;url=../action/boardList.jsp?pg=1"); %>
	<br><br>
<%}else{ %>
	<%response.setHeader("Refresh", "1;url=../board/boardWriteForm.jsp"); %>
<%} %>
</body>
<!-- <srcipt type="text/javascript">
window.onlad=function(){
alert("글쓰기 성공")
}
</srcipt> -->
<script src="../js/boardjs.js" type="text/javascript"></script>
</html>