package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberjsp.bean.MemberjspDTO;
import memberjsp.dao.MemberjspDAO;

public class LoginAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		String id= request.getParameter("id");
		String pwd=request.getParameter("pwd");
		//DB
		MemberjspDAO memberdao=MemberjspDAO.getInstance();
		MemberjspDTO memberDTO=memberdao.isLogin(id, pwd);
		
		if(memberDTO==null) {
			request.setAttribute("display", "/member/loginFail.jsp");
			return "/main/index.jsp";
		}else {
		//세션
		HttpSession session=request.getSession();
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
		
	
		request.setAttribute("display", "/member/loginOk.jsp");
		}
		return "/main/index.jsp";
	}
}
