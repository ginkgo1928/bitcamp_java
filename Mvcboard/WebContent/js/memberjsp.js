	function checkPost() { 
		window.open("checkPost.jsp","","width=500 height=500 scrollbars=yes"); 
		
	}

	
	
	function checkPostClose(zipcode,address){ //checkpost-->회원가입 주소창으로 값 이동
		//opener.memberjspform.zipcode.value=zipcode;
		//opener.memberjspform.addr1.value=address;
		//opener.memberjspform.addr2.focus();
		
		opener.document.getElementById("daum_zipcode").value=zipcode;
		opener.document.getElementById("daum_addr1").value=address;
		opener.document.getElementById("daum_addr2").value.focus();
		
		//forms 1
		//opener.document.forms[0].zipcode.value = zipcode;
		//opener.document.forms[0].addr1.value = address;
		//window.close();
		//opener.document.forms[0].addr2.focus();
		


	}
	

	function checkWrite(){		
 		if(document.memberjspform.name.value == "") {
 			alert("이름을 입력하세요");
 			document.memberjspform.name.focus();
 			
 		} else if(document.memberjspform.id.value == ""){
 			alert("아이디를 입력하세요");
 			document.memberjspform.id.focus();	
 			
 		} else if(document.memberjspform.pwd.value == ""){
 			alert("패스워드를 입력하세요");
 			document.memberjspform.pwd.focus();
 			
 		} else if(document.memberjspform.repwd.value != document.memberjspform.pwd.value){
 			alert("패스워드가 일치하지 않습니다.");
 			document.memberjspform.repwd.focus();
 		} else if(document.memberjspform.check.value!=document.memberjspform.id.value){
 			alert("아이디를 중복체크 하세요");
 		} else {
 			document.memberjspform.submit();
 		}
 	}

	function checkId(){
		var sId=document.memberjspform.id.value;
		// var는 일반적인 자바스크립 자료형이다.
		if(sId=="")
		alert("먼저 아이디를 입력해주세요!");
		else
		window.open("../member/checkId.jsp?id="+sId,"", 
					"width=300 height=100 left=500 top=150 locations=yes"); 
		
	}
	

	function checkIdClose(id) {// id 중복 검사
		/* 1.jsp 파일이 아니므로 현재 %는 먹히지 않는다
		 * 2. chckld ()에서 파라미터로 넘김
		 * 3. js 에서 jsp에 넘겸  받은  id를 스크립토 문법으로 바꾼다.
		 */
		opener.memberjspform.id.value=id;
		
		opener.memberjspform.check.value=id; //체크가 값을 바꿀  때 id를 넣음
		
		window.close();
		opener.memberjspform.pwd.focus();
	}
	
 	 function checkLogin(){ //로그인
 	 	if(document.loginform.id.value=="")
 	 		alert("아이디를 입력하세요");
 	 	else if(document.loginform.pwd.value=="")
 	 		alert("비밀번호를 입력하세요");
 	 	else
 	 	 document.loginform.submit();
 	}
 	

 	 function checkModeify(){// 회원수정 완료
 		 if(document.modifyform.name.value==""){
 			 alert("이름을 입력하세요");
 		 }else if(document.modifyform.pwd.value==""){
 			 alert("패스워드를 입력하세요");
 		 }else if(document.modifyform.repwd.value != document.modifyform.pwd.value){
 			alert("패스워드가 일치하지 않습니다.");
 		 }else{
 			document.modifyform.submit();
 		 }
 	 }