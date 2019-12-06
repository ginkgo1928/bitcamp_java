package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardWriteFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setCharacterEncoding("utf-8");

		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		BoardDTO boardDTO=new BoardDTO();
		boardDTO.setName("hyun");
		boardDTO.setId("hong");
		boardDTO.setEmail("hong@naver.com");
		boardDTO.setSubject(subject);
		boardDTO.setContent(content);
		

		BoardDAO boardbao=BoardDAO.getInstance();
		int cnt=boardbao.write(boardDTO);
		
		if(cnt==1) //-->글 등록 성공!
			return "/action/boardWrite.jsp";
		else
			
		return "/board/boardWriteForm.jsp";
	}

}
