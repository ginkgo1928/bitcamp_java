<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<jsp:useBean id="boardDAO" class="board.dao.BoardDAO"/>

<%
request.setCharacterEncoding("utf-8");

int seq=Integer.parseInt(request.getParameter("seq"));
int pg=Integer.parseInt(request.getParameter("pg"));

//새로고침 쿠키
Cookie[] ar = request.getCookies();
System.out.println(ar.length+"쿠키");
if(ar!=null){
	for(int i=0; i<ar.length; i++){
		System.out.println(ar[i].getName());
		if(ar[i].getName().equals("memHit")){
			boardDAO.boardHit(seq);
			ar[i].setMaxAge(0);//쿠키삭제
			ar[i].setPath("/"); //알려주려고 가는거
			response.addCookie(ar[i]);
		}
	}
}


//쿠키 시간 30분 사용
/* String memId=(String)session.getAttribute("memId");
boolean sw=false;
Cookie[]ar =request.getCookies();//모든 쿠키 얻어오기
if(ar!=null){
for(int i=0; i<ar.length; i++){
	if(ar[i].getName().equals(memId+seq)){//getName 내 쿠키를 찾아간다
		sw=true; // sw 수행했는지 알기 위해 true로 바꾼다.
		}	
	}

	if(!sw){//참이면 수행했다. 증가하면 안된다.  true부정-->false
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.boardHit(seq);
		
		Cookie cookie=new Cookie(memId+seq,seq+"");
		System.out.println("쿠키명="+(memId+seq)+",값="+seq);
		cookie.setMaxAge(30*60);
		response.addCookie(cookie); //클라이언트 보내기
	}
} */


//조회수
//boardao.boardHit(seq);
BoardDTO Boarddto=boardDAO.getBoardView(seq);

%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<img src="../img/eoe.png" width="50" height="50" onclick="location.href='../main/index.jsp'" style="cursor:pointer;">
<body background="/MemberJSP/img/toy3.jpg">

<form name="" method="post" action="../action/boardModifyForm.jsp">
<h1 align="left"> <%=Boarddto.getSubject()%></h1>

<table border="1"  width="700" frame="hsides" rules="rows">
<tr>
	<th width="70" align="center">글번호</th>
	<th width="70" align="center">작성자</th>
	<th width="70" align="center">조회수</th>
</tr>


<tr>

	<td width="70" align="center"> <%=Boarddto.getSeq()%></td>
	<td width="70" align="center"><%=Boarddto.getId()%></td>
	<td width="70" align="center"><%=Boarddto.getHit()%></td>

</tr>


<tr>
	<td colspan="3" valign="top" width="700" height="500" >
	<pre style="white-space: pre-line; word-break: break-all;"><%=Boarddto.getContent()%></pre>
	</td>
</tr>

</table>

	<td colspan = 3  height="200" valign="top"  align="left">
	<input type="button" value="목록" onclick="location.href='../action/boardList.jsp?pg=<%=pg%>'">
	<%if(session.getAttribute("memId").equals(Boarddto.getId())){%>
	<input type = "button" value = "수정" onclick="BoadrModify(<%=Boarddto.getSeq()%>,<%=pg%>)">
	<input type = "button" value = "삭제" >
<% }%>
</form>
</body>
<script type="text/javascript">
function BoadrModify(seq,pg) {
	location.href="../board/boardModifyForm.jsp?seq="+seq+"&pg="+pg;
}
</script>
</html>