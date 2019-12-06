package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberjsp.bean.MemberjspDTO;
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
		
		if(!exist) { //-->사용 가능한 ID
			request.setAttribute("display", "/member/checkId.jsp");
			return "/main/index.jsp"; 
	
		}else { //-->ID가 중복될 경우
			request.setAttribute("display", "/member/checkFail.jsp");
			return "/main/index.jsp"; 
		}
	}
}

