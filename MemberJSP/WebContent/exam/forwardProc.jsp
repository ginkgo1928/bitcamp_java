<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
request.setAttribute("ood", "우디");

//페이지 이동 RequestDispatcher는 new가 안돼!
RequestDispatcher dispatcher=
request.getRequestDispatcher("forwardResult.jsp");
//제어권 넘기기 (공유하기)
dispatcher.forward(request, response);

%>
<%-- jsp:forward page="forwardResult.jsp"/> --%>