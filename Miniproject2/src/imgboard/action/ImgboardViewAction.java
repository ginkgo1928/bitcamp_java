package imgboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imgboard.bean.ImgboardDTO;
import imgboard.dao.ImageboardDAO;

public class ImgboardViewAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int seq=Integer.parseInt(request.getParameter("seq"));
		System.out.println(seq);
		int pg=Integer.parseInt(request.getParameter("pg"));
		
		ImageboardDAO imgDAO=ImageboardDAO.getInstance();
		ImgboardDTO imgdto= imgDAO.imgboardview(seq);
		
		
		
		request.setAttribute("pg", pg);
		request.setAttribute("imgdto", imgdto);
		request.setAttribute("display","/imgboard/imgboardView.jsp");
		return "/main/index.jsp";
		
	}

}
