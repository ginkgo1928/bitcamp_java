package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.control.CommandProcess;

import memberjsp.bean.MemberjspDTO;
import memberjsp.dao.MemberjspDAO;

public class ModifyFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("memId");
		//DB
	     MemberjspDAO dao=MemberjspDAO.getInstance();
	     MemberjspDTO dto=dao.getUser(id);
	     //응답
	     request.setAttribute("memId", dto.getId());
	     request.setAttribute("memName", dto.getName());
	     request.setAttribute("memGender", dto.getGender());
	     System.out.println("여자"+dto.getGender());
	     request.setAttribute("memEmail1", dto.getEmail1());
	     request.setAttribute("memEmail2", dto.getEmail2());
	     request.setAttribute("memTel1", dto.getTel1());
	     request.setAttribute("memTel2", dto.getTel2());
	     request.setAttribute("memTel3", dto.getTel3());
	     request.setAttribute("memZipcode", dto.getZipcode());
	     request.setAttribute("memAddr1", dto.getAddr1());
	     request.setAttribute("memAddr2", dto.getAddr2());
	    
		
		//응답
		return"/member/modifyForm.jsp";
	}

}
