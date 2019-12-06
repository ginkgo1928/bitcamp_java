package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		HttpSession session=request.getSession();
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		String email = (String)session.getAttribute("memEmail");
		

		BoardDTO boardDTO=new BoardDTO();
		boardDTO.setId(id);
		boardDTO.setName(name);
		boardDTO.setEmail(email);
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		
		BoardDAO boardbao=BoardDAO.getInstance();
		int cnt=boardbao.write(boardDTO);
		if(cnt==1) { //-->글 등록 성공!
			request.setAttribute("display", "/board/boardList.jsp");
			return "/main/index.jsp";
			
		}else 
			request.setAttribute("display", "/board/boardWriteForm.jsp");
		return "/main/index.jsp";
	}

}
