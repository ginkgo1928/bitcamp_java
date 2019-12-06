<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     

<script type="text/javascript">
window.onload=function(){
	alert("글이 수정되었습니다.");
	location.href="/Miniproject2/board/boardList.do?pg=${pg}";
}
</script>

