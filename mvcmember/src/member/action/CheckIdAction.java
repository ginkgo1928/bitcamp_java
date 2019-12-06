package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberjsp.dao.MemberjspDAO;

public class CheckIdAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id=request.getParameter("id");
		//DB
		MemberjspDAO dao=MemberjspDAO.getInstance();
		boolean exist=dao.isExistId(id);
	
		//-->request(ID 가져감)
		request.setAttribute("id", id);
		//-->ID 사용 불가능(true)
		if(exist) 
			return "/member/checkFail.jsp"; 
		//-->ID 사용가능(false)
		else 	
		return "/member/checkId.jsp"; 
	}
}

