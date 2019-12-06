package imgboard.bean;

import lombok.Data;

@Data
public class ImgBoarbPaing {
	private int currentPage; //현재페이지
	private int pageBlock; //[이전][1][2][3][4][다음]
	private int pageSize; //1페이지당 5개씩
	private int imgboardtotalA; //총글수
	private StringBuffer pagingHTML; 
	
	 public void makePagingHTML() {
		 pagingHTML =new StringBuffer();
		 int totalP = (imgboardtotalA + pageSize - 1)/ pageSize; 
		 int startPage= (currentPage-1)/pageBlock*pageBlock+1;
		 int endPage=startPage+pageBlock-1;
		 if(endPage>totalP) //제어문 걸음
			 endPage=totalP;
		 if(startPage>pageBlock)
			 pagingHTML.append("[<a id='paging' href='imgboardList.do?pg="+(startPage-1)+"'>이전</a>]");
		 for(int i= startPage; i <endPage; i++) { // 이전
			 if(i==currentPage) 
				 pagingHTML.append("[<a id='currentPaging' href='imgboardList.do=pg+"+i+"'>"+i+"</a>]");
			 else 
				 pagingHTML.append("[<a id='paging' href='imgboardList.do?pg="+i+"'>"+i+"</a>]");
		 }
		 
		 if(endPage<totalP) { //다음 페이지
			 pagingHTML.append("[<a id='paging' href='imgboardList.do?pg="+(endPage+1)+"'>다음</a>]");
		 }
	 }

}
