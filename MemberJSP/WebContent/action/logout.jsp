<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //쿠키 죽이기
/* Cookie[]ar=request.getCookies();  //특정한 쿠키얻어 올 수 없다. 모든 쿠키 가져오기
if(ar!=null){ //이미 쿠키 시간이 끝나는 애들은 의미가 없다
	for(int i=0; i<ar.length; i++){
		if(ar[i].getName().equals("memName")){
			ar[i].setMaxAge(0); // 쿠키 삭제 메세지는 없다. 0로 만들면 끝난다.
			response.addCookie(ar[i]);
		}
		if(ar[i].getName().equals("memId")){
			ar[i].setMaxAge(0);
			response.addCookie(ar[i]);
		}
	}
} */
session.removeAttribute("memName"); //특정섹션 죽이기
session.removeAttribute("memId");

session.invalidate();  //모든 섹션 무효화
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
	alert("로그아웃 되었습니다.");
	location.href="../main/index.jsp";
}
</script>
</html>