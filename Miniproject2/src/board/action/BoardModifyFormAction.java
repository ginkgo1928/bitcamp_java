package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardModifyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		 int pg=Integer.parseInt(request.getParameter("pg"));
		 int seq=Integer.parseInt(request.getParameter("seq"));
		 //DB
		 BoardDAO Boarddao=BoardDAO.getInstance();
		 BoardDTO Boarddto=Boarddao.getBoardView(seq);
		 
		//응답
		request.setAttribute("Boarddto",Boarddto);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardModifyForm.jsp");
	
		return "/main/index.jsp";
	}
}
