<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>--변수설정--</h3>
<c:set var="name">JSTL</c:set>
<c:set var="age" value="25"/>
내 이름은  <c:out value="${name}"/>입니다<br>
내 나이는 ${age} 살 입니다.<br>
내가 좋아하는 색깔은${color}입니다.<br>

<h3>--변수삭제--</h3>
<!--잘 사용 안함  -->
<c:remove var=" name"/>
내 이름은<c:out value="${name}"/>입니다<br>
내 나이는${age}살 입니다<br>


<h3>--For Each--</h3>
<!--for(int i=1; i<=10; i++)  -->
<c:forEach var="i" begin="1" end ="10" step="1">
${i}
<c:set var="sum"  value="${sum+i}"/>
</c:forEach>

<br>
1~10까지의 합=${sum}

<br><br>

<c:forEach var="i" begin="1" end="10" step="1">
${11-i}
</c:forEach>

<h3>--문자열 분리--</h3>
<c:forTokens var="car" items="지프,벤츠,BWM,아우디,페라리" delims=",">
${car }<br>
</c:forTokens>
<h3>--jstlExam.jsp list 출력--</h3>
 결과 = ${requestScope.list}
 
 <!--requestScope 안 써도 나 다음에 requestScope로  알아서 찾아감. 
 내가 requestScope 있을 경우 꼭 써야된다!  -->
 <h3>--인덱스 2번째 출력--</h3>
 결과 = ${list[2]}
 
 
 <h3>--jstl.jsp list2 출력--</h3>
<c:forEach var="personDTO" items="${requestScope.list2}">
<%-- ${personDTO }<br> 객체 --%>
<!--진짜 데이터 값 get,set 생략할 수 없다. -->
이름=${personDTO.getName() } &nbsp;&emsp; 나이=${personDTO.getAge() }<br>
</c:forEach> 

<h3>--jstl.jsp lis2 출력방식 2--</h3>
<c:forEach var="personDTO" items="${requestScope.list2 }">
이름=${personDTO.name } &nbsp;&emsp; 나이=${personDTO.age }<br>
</c:forEach>
</body>
</html>