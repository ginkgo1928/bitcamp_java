<%@page import="com.sun.org.apache.bcel.internal.classfile.PMGClass"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <% 
 request.setCharacterEncoding("utf-8");
 
 int seq=Integer.parseInt(request.getParameter("seq"));
 int pg=Integer.parseInt(request.getParameter("pg"));
 String subject = request.getParameter("subject");
 String content = request.getParameter("content");
 
 BoardDTO dto=new BoardDTO();
 dto.setSeq(seq);
 dto.setSubject(subject);
 dto.setContent(content);
//DB
Map<String,String>map =new HashMap<String,String>();
map.put("seq", seq+""); //seq 숫자여서 ""문자 처리
map.put("subject",subject);
map.put("content",content);

BoardDAO Boarddao=BoardDAO.getInstance();
Boarddao.Boardupdate(map);
 

 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<script type="text/javascript">
window.onload=function(){
	alert("글이 수정되었습니다.");
	location.href="boardList.jsp?pg=<%=pg%>";
}

</script>
</html>
