package board.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

public class BoardModifyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		 int pg=Integer.parseInt(request.getParameter("pg"));
		 int seq=Integer.parseInt(request.getParameter("seq"));
		 
		 String subject = request.getParameter("subject");
		 String content = request.getParameter("content");
		 
		//DB
		Map<String,String>map =new HashMap<String,String>();
		map.put("seq", seq+""); //seq 숫자여서 ""문자 처리
		map.put("subject",subject);
		map.put("content",content);
	
		BoardDAO Boarddao=BoardDAO.getInstance();
		Boarddao.Boardupdate(map);
			
		//응답
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardModify.jsp");
	
		return "/main/index.jsp";
	}
}
