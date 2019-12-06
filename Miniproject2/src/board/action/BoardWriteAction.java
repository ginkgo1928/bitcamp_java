package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		 
		HttpSession session=request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		String email = (String)session.getAttribute("memEmail");
		
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		BoardDTO boardDTO=new BoardDTO();
		boardDTO.setName(name);
		boardDTO.setId(id);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
	
		BoardDAO boardbao=BoardDAO.getInstance();
		
		boardbao.write(boardDTO);
		
		request.setAttribute("display", "/board/boardWrite.jsp");
		return "/main/index.jsp";
	}

}
