<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@page import="memberjsp.bean.MemberjspDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	//데이터
  request.setCharacterEncoding("utf-8");
  String id=request.getParameter("id");
  String name=request.getParameter("name");
  String pwd=request.getParameter("pwd");
  String gender=request.getParameter("gender");
  String email1=request.getParameter("email1");
  String email2=request.getParameter("email2");
  String tel1=request.getParameter("tel1");
  String tel2=request.getParameter("tel2");
  String tel3=request.getParameter("tel3");
  String zipcode=request.getParameter("zipcode");
  String addr1=request.getParameter("addr1");
  String addr2=request.getParameter("addr2");
  
 MemberjspDTO dto=new MemberjspDTO();
 dto.setId(id);
 dto.setName(name);
 dto.setPwd(pwd);
 dto.setGender(gender);
 dto.setEmail1(email1);
 dto.setEmail2(email2);
 dto.setTel1(tel1);
 dto.setTel2(tel2);
 dto.setTel3(tel3);
 dto.setZipcode(zipcode);
 dto.setAddr1(addr1);
 dto.setAddr2(addr2);

 //DB
 MemberjspDAO dao=MemberjspDAO.getInstance();
 int su = dao.memberupdate(dto);
 %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<h1>회원정보 수정중 잠시만 기다리세요.</h1>
<form name="" method="post" action="">
<body background="/MemberJSP/img/nnj.jpg">
<%if(su==1){ %>
	<%response.setHeader("Refresh", "1;url=../member/loginForm.jsp"); %>
	<br><br>
<%}else{ %>
	<%response.setHeader("Refresh", "1;url=../main/index.jsp"); %> 
<%} %>
</form>
</body>
<script type="text/javascript">
window.onload=function(){
	if(<%=su%>==1){
		alert("회원정보 수정중 입니다.");	
	}else{
		alert("회원정보수정 실패");
	}
}
</script> 
</html>