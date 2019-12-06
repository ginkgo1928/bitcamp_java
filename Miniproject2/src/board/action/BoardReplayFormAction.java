package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.dao.BoardDAO;

public class BoardReplayFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터(원글,페이지),답글은 원글 밑에 들어가기 때문에 원글의 페이지 번호를 들고 가야한다.
		//pseq(원글번호),pg(원글페이지 번호)
		int pseq=Integer.parseInt(request.getParameter("pseq")); 
		int pg=Integer.parseInt(request.getParameter("pg"));
		
		
		//응답
		request.setAttribute("pseq", pseq);
		request.setAttribute("pg", pg);
		request.setAttribute("display", "/board/boardReplayForm.jsp");
		return "/main/index.jsp";
	}

}
