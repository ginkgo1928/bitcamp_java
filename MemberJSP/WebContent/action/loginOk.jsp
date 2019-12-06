<%@page import="memberjsp.bean.MemberjspDTO"%>
<%@page import="memberjsp.dao.MemberjspDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--   주소를 확인하면 한글이 잘 왔다!  -->
<% 
request.setCharacterEncoding("utf-8");
//String name=request.getParameter("name");
String name=null;
String id=null;
//쿠키 불러온다. 
//쿠키의 단점 : 내가 원하는 특정 쿠키(값만)추출할 수 없다. 모든 쿠키를 가져온다
//Cookie[]ar=request.getCookies(); //모든 쿠키를 가져오기 위해 배열 생성
/*if(ar!=null){ //쿠키 값이 살아 있을 때 물어봐야한다 내가 쿠키 생존시간 3초로 정함
	for(int i=0; i<ar.length; i++){
 		String cookieName=ar[i].getName(); //쿠키명
		String cookievalue=ar[i].getValue(); //쿠키값 */
/* 		
		if(ar[i].getName().equals("memName"))
			name=ar[i].getValue();
		if(ar[i].getName().equals("memId"))
			id=ar[i].getValue();
		System.out.println(name+","+id);
		
	}
} */
//이메일 세션 생성


//세션(형변환)
/* name = (String)session.getAttribute("memName");
id = (String)session.getAttribute("memId");
response.sendRedirect("../main/index.jsp");
 */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="../img/mo1.jpg" width="500" height="500" onclick="location.href='../main/index.jsp'" style="cursor: pointer;">
<br>
<%-- <%=name%>님 로그인 
<input type="button"  value="회원정보 수정" onclick="location.href='../member/modifyForm.jsp?id=<%=id%>'">
<input type="hidden" name="id" value="<%=id%>"> 

<input type="button" value="로그아웃" onclick="location.href='logout.jsp'"> --%>
</body>
</html>