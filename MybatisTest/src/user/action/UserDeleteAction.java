package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserDeleteAction implements UserAction {

	@Override
	public void execute() {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("삭제할 아이디를 입력하세요 : ");
		String id=scan.next();
		
	
		UserDAO userDAO=UserDAO.getInstance();
		UserDTO userDTO=userDAO.searchid(id);
	
		
		if(userDTO==null) {
			System.out.println("삭제할 아이디가 없습니다.");
		return;

		}else { 
		userDAO=UserDAO.getInstance();
		userDAO.delete(id);
		
		System.out.println("데이터를 삭제했습니다!");
		
		}
	}

}
