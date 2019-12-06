package member.action;

import java.util.HashMap;
import java.util.Map;

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
		
		//관리자
		String hyunID="hyun3761";
		String hyunpwd="3761";
		//DB
		Map<String, String> map=new HashMap<String, String>();
		MemberjspDAO memberdao=MemberjspDAO.getInstance();
		MemberjspDTO memberDTO=memberdao.isLogin(id,pwd);
		
		String loginResult=null;
		
		if(memberDTO==null) {
			loginResult="fail";
		}else {
		//세션
		HttpSession session=request.getSession();
		session.setAttribute("memName", memberDTO.getName());
		session.setAttribute("memId", id);
		session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
		session.setAttribute("hyunID", hyunID);
		session.setAttribute("hyunpwd", hyunpwd);

		}
		//조건이 맞아도 틀려도 결과는 똑같아서 바깥으로 뻇다.
		request.setAttribute("loginResult", loginResult);
		request.setAttribute("display", "/template/body.jsp");
		return "/main/index.jsp";
	}
}
