<%@page import="com.jstl.PersonDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
/*자바코드  */
ArrayList<String>list=new ArrayList<String>();
list.add("호랑이");
list.add("사자");
list.add("기린");
list.add("코끼리");
list.add("타조");
list.add("코알라");
list.add("여우");
PersonDTO aa=new PersonDTO("홍길동",25);
PersonDTO bb=new PersonDTO("이또치",20);
PersonDTO cc=new PersonDTO("장보고",80);


ArrayList<PersonDTO>list2=new ArrayList<PersonDTO>();
list2.add(aa);
list2.add(bb);
list2.add(cc);



//데이터 태움
request.setAttribute("list", list);
request.setAttribute("list2", list2);

//페이지이동
/* response.sendRedirect("jstlTest.jsp"); */


//forward와 같은 의미 꼭 외우기 지금 현재 유일한 생존자!!!
RequestDispatcher dispatcher=request.getRequestDispatcher("jstlTest.jsp");//상대번지
dispatcher.forward(request, response); //제어권 넘기기
%>
<!--한페이지 공유!!  -->
<%-- <jsp:forward page="jstlTest.jsp"/>; 죽음!!--%>