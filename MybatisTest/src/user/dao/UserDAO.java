package user.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import user.bean.UserDTO;

public class UserDAO {
	private static UserDAO instance;
	// 환경설정 누가 어디 있는지 알아야한다.(한 번만 읽으면 된다)
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDAO() {
		try {
			Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static UserDAO getInstance() {
		if(instance==null) {
			synchronized (UserDAO.class) {
				instance = new UserDAO();
			}
		}
		return instance;
	}

	public void write(UserDTO userDTO) { //-->가입
		SqlSession sqlSession=sqlSessionFactory.openSession(); //팩토리를 통해서 -->섹션 생성
		int su=sqlSession.insert("userSQL.write", userDTO); //userSQL-->namesqce 이름 구분자
		//parameterType-->자료형
		sqlSession.commit();
		sqlSession.close();
		
	}

	public void delete(String id) {// -->삭제
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.delete("userSQL.delete", id);
		sqlSession.commit();
		sqlSession.close();
		
	}

	public List<UserDTO> getList() { //-->출력
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.getList");//selectList 자동 리스트에 담는다, 제네릭 안하면 오브젝트 걸림,resultType -담아라
		sqlSession.close();
		return list;
	}

	
	public void  update(Map<String, String> map) { //-->수정
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update("userSQL.update", map);
	
		sqlSession.commit();
		sqlSession.close();
	}
	
	public UserDTO searchid(String id) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDTO userDTO=sqlSession.selectOne("userSQL.searchid", id);
		sqlSession.close();
		return userDTO;
		
	}


	public List<UserDTO> search(Map<String, String> map) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserDTO> list = sqlSession.selectList("userSQL.search",map);
		sqlSession.close();
		return list;
	}
}
	

