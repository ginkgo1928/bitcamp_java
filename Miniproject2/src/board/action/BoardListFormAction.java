package board.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardPaing;
import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardListFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		int pg=Integer.parseInt(request.getParameter("pg"));
		//게시판 글 계산
		int endNum=pg*5;
		int startNum=endNum-4;
		//DB
		BoardDAO boardbao=BoardDAO.getInstance();
		List<BoardDTO>boli=boardbao.boardlist(startNum, endNum);
		
		//페이징 처리
		BoardPaing boardPaging = new BoardPaing(); 
		int totalA=boardbao.getTotalA();
		boardPaging.setCurrentPage(pg);
		boardPaging.setPageBlock(5);
		boardPaging.setPageSize(4);
		boardPaging.setTotalA(totalA);
		boardPaging.makePagingHTML();
		System.out.println(boardPaging);
		
		//세션이 null 아닐 떄 쿠키 생성
		HttpSession session=request.getSession();
		if(session.getAttribute("memId")!=null) {
			Cookie cookie=new Cookie("memHit","0");
			cookie.setMaxAge(30*60);
			cookie.setPath("/");
			response.addCookie(cookie);	
		}
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("boli", boli);
		request.setAttribute("boardPaging", boardPaging);
		request.setAttribute("display", "/board/boardList.jsp");
		
		return "/main/index.jsp";
	}
}
