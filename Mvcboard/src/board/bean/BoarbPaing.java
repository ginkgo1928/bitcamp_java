package board.bean;

import lombok.Data;

@Data
public class BoarbPaing {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][4][다음]
	private int pageSize; //1페이지당 5개씩
	private int totalA; //총글수
	//String Buffer 잡은 이유
	//String 편집X,편집되는게 아니라 새로운게 만들어진다.
	//그래서 공간이 많이 차지해서 String Buffer를 쓴다
	private StringBuffer pagingHTML; 
	
	 public void makePagingHTML() {
		 pagingHTML =new StringBuffer(); //1번 스트링 버퍼생성
		//총페이지수=(총글수+9)/10
		//총페이지수=총글수-한페이지 뿌릴 갯수 -1 / 한 페이지에 뿌릴 갯수
		 
		 int totalP = (totalA + pageSize - 1)/ pageSize; 
		 int startPage= (currentPage-1)/pageBlock*pageBlock+1;
		 int endPage=startPage+pageBlock-1;
		 if(endPage>totalP) //제어문 걸음
			 endPage=totalP;
		 
		 if(startPage>pageBlock)
			 pagingHTML.append("[<a id='paging' href='boardList.go?pg="+(startPage-1)+"'>이전</a>]");
			 	
		 for(int i= startPage; i <endPage; i++) { // 이전
			 if(i==currentPage) 
				 pagingHTML.append("[<a id='currentPaging' href='boardList.go=pg+"+i+"'>"+i+"</a>]");
			 else 
				 pagingHTML.append("[<a id='paging' href='boardList.go?pg="+i+"'>"+i+"</a>]");
		 }
		 
		 if(endPage<totalP) { //다음 페이지
			 pagingHTML.append("[<a id='paging' href='boardList.go?pg="+(endPage+1)+"'>다음</a>]");
		 }
	 }

}
