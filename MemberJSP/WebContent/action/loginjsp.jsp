<%@page import="memberjsp.bean.MemberjspDTO"%>
<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.net.URLEncoder" %> 
<%
 request.setCharacterEncoding("utf-8");
String id= request.getParameter("id");
 String pwd=request.getParameter("pwd");

 MemberjspDAO memberdao=MemberjspDAO.getInstance();
 MemberjspDTO memberDTO=memberdao.isLogin(id, pwd);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<form name="" method="post" action="../member/modifyForm.jsp">
<input type="hidden" name="id" value="<%=id%>"> 
<%if(memberDTO==null){
	response.sendRedirect("../action/loginFail.jsp");	
	
}else{
	//이름을  보낼때 한글이 깨져서 URLEncoder static 형식으로 다이렉트 보냄(암호화)
	//response.sendRedirect("../action/loginOk.jsp?name="+URLEncoder.encode(name,"utf-8"));
	

	//쿠키는 서버에서 생성한다
/* 	Cookie cookie=new Cookie("memName", name); //memName쿠키명, name값
	cookie.setMaxAge(3*60); //쿠키 생존시간 (방문증 시간)
	response.addCookie(cookie);
	
	Cookie cookie2=new Cookie("memId", id);
	cookie.setMaxAge(3*60); //쿠키 생존시간 (방문증 시간)(30분 생존시간)
	response.addCookie(cookie2); //add 클라이언트 보관 */
	//세션 : 인터페이스 (jsp내장객체에 섹션을 가지고 있다.),객체값 dto통으로 담아도 된다.
	//HttpSession session = request.getSession();-세션 생성
	//이미 섹션은 가지고 있어서 생성 할 필요 없다
	//세션 값이 있을 떄 :회원정보 수정,로그아웃,목록
	//세션 값이 없을 떄 : 회원 가입, 로그인 ,모록
	
	session.setAttribute("memName", memberDTO.getName());
	session.setAttribute("memId", id);
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
		
	//response.sendRedirect("loginOk.jsp");
	response.sendRedirect("../main/index.jsp");
	
	
	
}%>
	</form>
</body>
</html>
 <!--onclick="location.href ='modifyForm.jsp?id=<%=id%> post방식으로 수정함-->