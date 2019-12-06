package user.action;

import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import user.bean.UserDTO;
import user.dao.UserDAO;

public class UsersearchAction implements UserAction {

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		int num;
		
			System.out.println("1.이름 검색");
			System.out.println("2.아이디 검색");
			num = scan.nextInt();
			//이름
			String columnName= null; // value에 맞는 데이터 
			String value=null; //검색 

			if (num == 1) {
				System.out.println("검색할 이름 입력:");
				value= scan.next();
				columnName="name";
	
	
			} else if (num == 2) {
				System.out.println("검색할 아이디 입력:");
				value=scan.next();
				columnName="id";
			} 
			Map<String, String> map=new HashMap<String, String>();
			map.put("columnName", columnName);
			map.put("value", value);
			
			UserDAO userDAO=UserDAO.getInstance();
			List<UserDTO> list=userDAO.search(map);
			
			for(UserDTO userDTO : list) {
				System.out.println(userDTO.getName()+"\t"+userDTO.getId()+"\t"+userDTO.getPwd());
				

		}
	}
}

