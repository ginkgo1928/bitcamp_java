package imgboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import imgboard.dao.ImageboardDAO;

public class ImgboardDeleteAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		String[] check = request.getParameterValues("check");
		
		ImageboardDAO imageboardDAO=ImageboardDAO.getInstance();
		imageboardDAO.imgboardDelete(check);
		
		request.setAttribute("display", "/imgboard/imgboardDelete.jsp");
		return "/main/index.jsp";
	}

}
