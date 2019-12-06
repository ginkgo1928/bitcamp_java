package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplaydeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg=Integer.parseInt(request.getParameter("pg"));
		int seq=Integer.parseInt(request.getParameter("seq"));
		System.out.println(pg+"페이지");
		
		BoardDAO boardDAO=BoardDAO.getInstance();
		boardDAO.boardreplaydelete(seq);
		
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplaydelete.jsp");
		return "/main/index.jsp";
	}

}
