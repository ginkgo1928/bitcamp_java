package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardPaing;
import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardSearchAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg=Integer.parseInt(request.getParameter("pg"));
		String searchOption=request.getParameter("searchOption");
		String keyword =request.getParameter("keyword");
		
		//페이지
		int endNum=pg*5;
		int startNum=endNum-4;
		
		Map<String, String>map= new HashMap<String, String>();
		map.put("startNum", startNum+"");
		map.put("endNum", endNum+"");
		map.put("searchOption",searchOption);
		map.put("keyword", keyword);
		
		BoardDAO boarddao=BoardDAO.getInstance();
		List<BoardDTO>boli=boarddao.boardSearch(map);
		
		//페이징 처리
		BoardPaing boardPaging = new BoardPaing(); 
		int totalA=boarddao.getSearchTotalA(map);
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(5);
		boardPaging.setPageSize(4);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		
		request.setAttribute("pg", pg);
		request.setAttribute("searchOption", searchOption);
		request.setAttribute("keyword", keyword);
		request.setAttribute("boli", boli);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/board/boardList.jsp");
		return "/main/index.jsp";
	}

}
