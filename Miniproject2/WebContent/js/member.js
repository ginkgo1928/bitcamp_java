function checkWrite() { //-->회원가입
	if(document.writeForm.name.value=="")
		alert("이름을 입력하세요");
	else if(document.writeForm.id.value=="")
		alert("아이디를 입력하세요");
	else if(document.writeForm.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		alert("비밀번호가 맞지 않습니다")
	else if(document.writeForm.check.value!=document.writeForm.id.value)
		alert("중복체크 하세요");
	else
		document.writeForm.submit();
}

function checkId(){//-->ID
	var sId = document.writeForm.id.value;
	if(sId=="")
		alert("먼저 아이디를 입력하세요.");
	else
		window.open("/Miniproject2/member/checkId.do?id="+sId,
				"",
				"width=300 height=100 left=500 top=150 locations=yes");
}

function checkIdClose(id){ //-->ID가 중복되지 않는 경우
	opener.writeForm.id.value = id;
	opener.writeForm.check.value = id;
	window.close();
	opener.writeForm.pwd.focus();
}

function checkPost(){ //-->주소
	window.open("/Miniproject2/member/checkPost.do","","width=500 height=500 scrollbars=yes");
}

function checkPostClose(zipcode, address){ //-->주소를 선택하고 창이 닫힘
	opener.document.getElementById("daum_zipcode").value = zipcode;
	opener.document.getElementById("daum_addr1").value = address;
	window.close();
	opener.document.getElementById("daum_addr2").focus();
	
}

function checkLogin(){//-->로그인
	if(document.loginForm.id.value=="")
		alert("아이디를 입력하세요");
	else if(document.loginForm.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else
		document.loginForm.submit();
}

function checkModeify(){//-->회원정보 수정
	if(document.modifyform.name.value=="")
		alert("이름을 입력하세요");
	else if(document.modifyform.pwd.value=="")
		alert("비밀번호를 입력하세요");
	else if(document.modifyform.pwd.value != document.modifyform.repwd.value)
		alert("비밀번호가 맞지 않습니다")
	else
		document.modifyform.submit();
}
