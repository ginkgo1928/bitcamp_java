package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		request.setCharacterEncoding("utf-8");
		int seq=Integer.parseInt(request.getParameter("seq"));
		int pg=Integer.parseInt(request.getParameter("pg"));
		//DB
		BoardDAO boardbao=BoardDAO.getInstance();
		BoardDTO Boarddto=boardbao.getBoardView(seq);
		//응답
		request.setAttribute("Boarddto", Boarddto);
		request.setAttribute("pg", pg);
		return "/board/boardViewForm.jsp";
	}
}
