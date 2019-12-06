package imgboard.bean;

import lombok.Data;

@Data
public class ImgboardDTO {
	private int seq;
	private String imageId;
	private String imageName;
	private int imagePrice;
	private int imageQty; 
	private String imageContent;
	private String image1;
	private String logtime;
	
}
