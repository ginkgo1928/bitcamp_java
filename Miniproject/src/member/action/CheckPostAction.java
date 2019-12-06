package member.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.control.CommandProcess;
import memberjsp.bean.ZipcodeDTO;
import memberjsp.dao.MemberjspDAO;

public class CheckPostAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		//데이터
		 String sido = request.getParameter("sido");
		 String sigungu = request.getParameter("sigungu");
		 String roadname = request.getParameter("roadname");
		 
		 //DB-->시.도 null이 아닐때만 처리
		  MemberjspDAO memberDAO = MemberjspDAO.getInstance();

		  List<ZipcodeDTO> list=null;
		  if(sido!=null && roadname!=null){
		  	list = memberDAO.getZipcodeList(sido, sigungu, roadname);
		  }
		  //응답 -->list에 담고 간다.
		  request.setAttribute("list", list);
		  return "/member/checkPost.jsp";
	}
}
