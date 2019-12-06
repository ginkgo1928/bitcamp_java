<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<form name="imgwriteform" method="post" enctype="multipart/form-data" 
	action="/Miniproject2/imgboard/imgboardWrite.do">
		<table border="1">
		
			<tr>
				<th>상품 코드</th>
				<td><input type="text" id="imageId"  name="imageId" placeholder="img_" style="width: 400;"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" id="imageName" name="imageName" placeholder="상품명 입력" style="width: 400px;"></td>
			</tr>

			<tr>
				<th>단가</th>
				<td><input type="number" id="imagePrice" name="imagePrice" placeholder="단가 입력" style="width: 250px;"></td>
			</tr>

			<tr>
				<th>개수</th>
				<td><input type="number" id="imageQty" name="imageQty" placeholder="개수입력" style="width: 250px;"></td>
			</tr>

			<tr>
				<th>내용</th>
				<td><textarea id="imageContent" name="imageContent" placeholder="내용을 입력" style="width: 400px; height: 500px"></textarea></td>
			</tr>

			<tr>
				<td colspan="2"><input type="file" id="image1" name="image1"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<input type="button"value="이미지등록" onclick="checkimgBoard()"> 
				<input type="reset" value="다시 작성">
			</tr>
		</table>
	</form>
<script src="../js/imgboard.js" type="text/javascript"></script>
