package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

public class LoginFormAction implements CommandProcess {
	
	//ControlServlet-->command.properties-->ControlServlet-->LoginFormAction
	//LoginFormAction(1.데이터,DB,loginOk,loginFill)
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		request.setAttribute("display", "/member/loginForm.jsp");
		return "/main/index.jsp";
	}

}
