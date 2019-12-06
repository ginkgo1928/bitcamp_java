package user.action;

import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserInsertAction implements UserAction {

	@Override
	public void execute() {
		Scanner scan=new Scanner(System.in);
		//데이터 
		System.out.println("이름을 입력하세요 : ");
		String name=scan.next();
		System.out.println("아이디를 입력하세요 : ");
		String id=scan.next();
		System.out.println("패스워드를 입력하세요 : ");
		String pwd=scan.next();
		
		//DB
		UserDTO userDTO=new UserDTO();
		userDTO.setName(name);
		userDTO.setId(id);
		userDTO.setPwd(pwd);
		
		//응답
		UserDAO userDAO=UserDAO.getInstance();
		userDAO.write(userDTO);
		
		System.out.println("데이터를 저장했습니다!");
			
		
	}

}
