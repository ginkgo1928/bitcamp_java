package imgboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.control.CommandProcess;
import com.oreilly.servlet.MultipartRequest;
import imgboard.bean.ImgboardDTO;
import imgboard.dao.ImageboardDAO;

public class ImgboardWrite implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		
		//실제폴더-->C:\java_ee\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\Miniproject2\storage
		String realFolder = request.getServletContext().getRealPath("/storage");
		System.out.println(realFolder);
		//업로도
		MultipartRequest multi=new MultipartRequest(request, 
													realFolder,
													5*1024*1024, //5MB
													"UTF-8");
		
		String imageId=multi.getParameter("imageId");
		String imageName=multi.getParameter("imageName");
		int imagePrice =Integer.parseInt(multi.getParameter("imagePrice"));
		int imageQty=Integer.parseInt(multi.getParameter("imageQty"));
		String imageContent =multi.getParameter("imageContent");
		String image1=multi.getOriginalFileName("image1");
		
		ImgboardDTO imgdto=new ImgboardDTO();
		imgdto.setImageId(imageId);
		imgdto.setImageName(imageName);
		imgdto.setImagePrice(imagePrice);
		imgdto.setImageQty(imageQty);
		imgdto.setImageContent(imageContent);     
		imgdto.setImage1(image1);     

		
		ImageboardDAO imgDAO=ImageboardDAO.getInstance();
		imgDAO.imgwrite(imgdto);
		
		request.setAttribute("display", "/imgboard/imgboardWrite.jsp");
		return "/main/index.jsp";

	}

}
