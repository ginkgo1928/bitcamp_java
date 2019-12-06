package board.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardViewFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int seq=Integer.parseInt(request.getParameter("seq"));
		int pg=Integer.parseInt(request.getParameter("pg"));
		
		//DB
		BoardDAO boardbao=BoardDAO.getInstance();
		
		//-->조회수
		Cookie[]cook=request.getCookies();
		if(cook!=null) {
			for(int i=0; i<cook.length; i++) {
				if(cook[i].getName().equals("memHit")) { //-->쿠키명 찾기
				boardbao.boardHit(seq);
				cook[i].setMaxAge(0); //-->쿠키삭제
				cook[i].setPath("/"); //알려주려고 가는거
				response.addCookie(cook[i]);
			}
		}
	}
		
		BoardDTO Boarddto=boardbao.getBoardView(seq);
		
		request.setAttribute("pg", pg);
		request.setAttribute("Boarddto", Boarddto);
		request.setAttribute("display","/board/boardViewForm.jsp");
		return "/main/index.jsp";
	}
}
