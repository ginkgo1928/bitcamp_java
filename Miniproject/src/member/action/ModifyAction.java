package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import memberjsp.bean.MemberjspDTO;
import memberjsp.dao.MemberjspDAO;

public class ModifyAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {	
	 //데이터
	  String id=request.getParameter("id");
	  String name=request.getParameter("name");
	  String pwd=request.getParameter("pwd");
	  String gender=request.getParameter("gender");
	  String email1=request.getParameter("email1");
	  String email2=request.getParameter("email2");
	  String tel1=request.getParameter("tel1");
	  String tel2=request.getParameter("tel2");
	  String tel3=request.getParameter("tel3");
	  String zipcode=request.getParameter("zipcode");
	  String addr1=request.getParameter("addr1");
	  String addr2=request.getParameter("addr2");
	  
	 MemberjspDTO dto=new MemberjspDTO();
	 dto.setId(id);
	 dto.setName(name);
	 dto.setPwd(pwd);
	 dto.setGender(gender);
	 dto.setEmail1(email1);
	 dto.setEmail2(email2);
	 dto.setTel1(tel1);
	 dto.setTel2(tel2);
	 dto.setTel3(tel3);
	 dto.setZipcode(zipcode);
	 dto.setAddr1(addr1);
	 dto.setAddr2(addr2);

	 //DB
	 MemberjspDAO dao=MemberjspDAO.getInstance();
	 int su = dao.memberupdate(dto);
		
	 //응답
	request.setAttribute("display", "/member/modify.jsp");
	 return "/main/index.jsp";
	}
}
