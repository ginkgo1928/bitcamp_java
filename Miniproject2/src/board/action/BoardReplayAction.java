package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardReplayAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터(원글,페이지),답글은 원글 밑에 들어가기 때문에 원글의 페이지 번호를 들고 가야한다.
		//pseq(원글번호),pg(원글페이지 번호)
		
		int pseq=Integer.parseInt(request.getParameter("pseq")); 
		int pg=Integer.parseInt(request.getParameter("pg"));
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		//답글 누가 달았는지 알기 위해 세션 가져온다.
		HttpSession session=request.getSession();
		String id = (String)session.getAttribute("memId");
		String name = (String)session.getAttribute("memName");
		String email = (String)session.getAttribute("memEmail");
		
		//DTO에 담아간다. 이떄 원글 번호 꼭 필요함
		BoardDTO boardDTO=new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		boardDTO.setPseq(pseq);
		
		//DB
		BoardDAO boardbao=BoardDAO.getInstance();
		boardbao.boardreplay(boardDTO);
		
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplay.jsp");
		return "/main/index.jsp";
	}

}
