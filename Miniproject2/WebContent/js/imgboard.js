function checkimgBoard(){ //이미지 게시판
	if(document.getElementById("imageId").value==""){
		alert("상품코드를 입력하세요.")
		document.getElementById("imageId").focus();
	}else if(document.getElementById("imageName").value==""){
		alert("상품명을 입력하세요.")
		document.getElementById("imageName").focus();
	}else if(document.getElementById("imagePrice").value==""){
		alert("단가를 입력하세요")
		document.getElementById("imagePrice").focus();
	}else if(document.getElementById("imageQty").value==""){
		alert("개수를 입력하세요.")
		document.getElementById("imageQty").focus();
		
	}else if(document.getElementById("imageContent").value==""){
		alert("내용을 입력하세요.")
		document.getElementById("imageContent").focus();
	}else{
		 document.forms[0].submit(); //form의 배열
	}
}

