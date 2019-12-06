<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@page import="java.net.URLEncoder"%>

<%
//실제폴더
String realFolder = request.getServletContext().getRealPath("/storage");
System.out.println("실제폴더="+realFolder);

//업로드(C:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps)-->실제폴더.
MultipartRequest multi = new MultipartRequest(request,
											  realFolder,
											  5*1024*1024,//5MB
											  "UTF-8",
											  new DefaultFileRenamePolicy()//똑같은 이름의 파일 올라가면 바꾼다.
											  );
//모든 권한은 Multi에게 있음
String subject=multi.getParameter("subject");
String content=multi.getParameter("content");

//aaa1.txt
String originalFileName1=multi.getOriginalFileName("upload1");
String originalFileName2=multi.getOriginalFileName("upload2");

String fileName1=multi.getFilesystemName("upload1");
String fileName2=multi.getFilesystemName("upload2");

//파일 크기 알아내기 이름만 알고 있으면 크기를 못구해온다.
//내가 가지고 있는 거를 파일 생성한다.-java.io

File file1=multi.getFile("upload1");
File file2=multi.getFile("upload2");

long fileSize1=0;
long fileSize2=0;

if(file1!=null)fileSize1=file1.length();
if(file2!=null)fileSize2=file2.length();


 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body background="/MemberJSP/img/nnj.jpg">
<h3>업르드 완료</h3>
<ul>
<li>제목:<%=subject%></li>
<li>내용:<pre><%=content%></pre></li>
<li>파 일 : <a href="fileDownLoad.jsp?fileName=<%=URLEncoder.encode(originalFileName1,"UTF-8")%>"><%=originalFileName1%></a><br>
<li>파일:<%=fileName1%>
<li>크기:<%=fileSize1%></li><br>


<li>파일:<%=originalFileName2%></li>
<li>파일:<%=fileName2%></li>
<li>크기:<%=fileSize2%></li>



</ul>
</body>
</html>