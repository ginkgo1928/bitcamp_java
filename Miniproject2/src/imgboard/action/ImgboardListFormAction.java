package imgboard.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;

import board.bean.BoardPaing;
import imgboard.bean.ImgBoarbPaing;
import imgboard.bean.ImgboardDTO;
import imgboard.dao.ImageboardDAO;

public class ImgboardListFormAction implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		int pg=Integer.parseInt(request.getParameter("pg"));
		//게시판 글 계산
		int endNum=pg*3;
		int startNum=endNum-2;
		 
		ImageboardDAO imgDAO=ImageboardDAO.getInstance();
		List<ImgboardDTO>imglist=imgDAO.getimgboardList(startNum, endNum);
		
		//페이징 처리
		ImgBoarbPaing imgboardpaging = new ImgBoarbPaing(); 
		int imgboardtotalA =imgDAO.imgboardtotalA();
		imgboardpaging.setCurrentPage(pg);
		imgboardpaging.setPageBlock(3);
		imgboardpaging.setPageSize(2);
		imgboardpaging.setImgboardtotalA(imgboardtotalA);
		imgboardpaging.makePagingHTML();
		System.out.println(imgboardpaging);
		
		for (ImgboardDTO imgboardDTO : imglist) {
			System.out.println(imgboardDTO.getSeq());
			
		}
	
		request.setAttribute("pg", pg);
		request.setAttribute("imglist", imglist);
		request.setAttribute("imgboardpaging", imgboardpaging);
		request.setAttribute("display", "/imgboard/imgboardList.jsp");
		
		return "/main/index.jsp";
	}

}
