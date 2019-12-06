<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<h1 align="center">회원가입</h1>

<form name="writeForm" method="post" action="/Miniproject2/member/write.do">
<table border="1" align="center">
	<tr>
	
	<th width="100">이름</th>
	<td><input type="text" name="name" placeholder="이름 입력"  style="width: 200px;"> </td>
	</tr> 
	
	<tr>
	<th width="100">아이디</th>
	<td><input type="text" name="id" placeholder="아이디 입력" style="width: 200px;">
		<input type="button" value="중복체크" onclick="checkId()">
		<input type="hidden" name="check" >
		</td>
		
	</tr>
	
	<tr>
	<th width="100">패스워드</th>
	<td><input type="password" name="pwd"></td>
	</tr>
	
	<tr>
	<th width="110">비밀번호 확인</th>
	<td><input type="password" name="repwd"></td> 
	</tr>
	
	<tr>
	<th width="100">성별</th>
	<td><input type="radio" name="gender" value="0">남
		<input type="radio" name="gender" value="1">여
	</td> 
	</tr>
	
	
	<tr>
	<th>이메일</th>
	<td><input type="text" name="email1">@
	<input list="mailaddr"  name="email2" placeholder="직접입력">
	<datalist id="mailaddr">
	<option value="gmail.com"></option>
	<option value="naver.com"></option>
	<option value="daum.net"></option>
	</datalist>
	</td>	
	</tr>
	
	<tr>
	<th width="80">핸드폰</th>
	<td>
		<select name="tel1" style="width: 50px;">
		<option value="010">010</option>
		<option value="011">011</option>
		<option value="012">019</option>
		</select>
			-
		<input type="text" name="tel2" style="width: 50px;">
		-
		<input type="text" name="tel3" style="width: 50px;">
	</td>
</tr>
	
	
	
	<tr>
	<th>주소</th>
	<td>
	   <input type = "text" id = "daum_zipcode" name = "zipcode" size = 5 readonly> 
	   <input type = "button" value = "우편번호검색" onclick = "checkPost()"> <br>
	   <input type = "text" id = "daum_addr1" name = "addr1" size = 40 placeholder = "주소 " readonly><br>
	   <input type = "text" id = "daum_addr2" name = "addr2" size = 40 placeholder = "상세 주소 ">
	</td>
	</tr>
	
	<tr>
		<td colspan = 2 align = "center"> 
		<input type = "button" value = "회원가입" onclick = "checkWrite()">
		<input type = "reset" value = "다시작성">     
		</td>   
	 </tr>    		  	 
</table>
</form>
<script src="../js/member.js" type="text/javascript"></script>
