package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoarbPaing;
import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg=Integer.parseInt(request.getParameter("pg"));
		//페이지
		int endNum=pg*5;
		int startNum=endNum-4;
		
		//DB
		BoardDAO boardbao=BoardDAO.getInstance();
		List<BoardDTO>boli=boardbao.boardlist(startNum, endNum);
		
		//페이징 
		BoarbPaing boardPaging = new BoarbPaing(); 
		int totalA=boardbao.getTotalA();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(5);
		boardPaging.setPageSize(4);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("boli", boli);
		request.setAttribute("boardPaging", boardPaging);
		
		
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/main/index.jsp";
	}

}
