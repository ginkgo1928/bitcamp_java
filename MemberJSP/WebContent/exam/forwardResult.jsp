<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String ood=(String)request.getAttribute("ood");
//sendProc send보내서 결과는 null값
%>
결과: <%=ood%>
나는 forwardProc.jsp의 regeust의 ood와 값이 같아.

