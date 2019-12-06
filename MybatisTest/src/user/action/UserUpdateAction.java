package user.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UserUpdateAction implements UserAction {
	@Override
	public void execute() {
		Scanner scan=new Scanner(System.in);
		System.out.println("아이디를 입력하세요 : ");
		 String id=scan.next();
		
		UserDAO userDAO=UserDAO.getInstance();
		UserDTO userDTO=userDAO.searchid(id);  //1. id를 먼저 찾음.
		
		
		if(userDTO!=null) {
		System.out.println("이름을 입력하세요 :");
		String name=scan.next(); //-->화면에서 문장만 받음
		//userDTO.setName(name); //-->문장 받은 걸 담아줌
		
		System.out.println("패스워드를 입력하세요:");
		String pwd=scan.next();
		//userDTO.setPwd(pwd);
		
		// userDAO.update(userDTO); //-->마지막 쿼리 실행
		//DTO와 map에다가 담아도 상관없음
		Map<String, String> map=new HashMap<String, String>(); 
		map.put("name", name);
		map.put("id", id);
		map.put("pwd", pwd);
	
		userDAO.update(map);
			 	
		System.out.println("수정이 완료되었습니다.");
		}else {
			System.out.println("수정할 아이디가 없습니다!");
			return;
		}
	}
}

