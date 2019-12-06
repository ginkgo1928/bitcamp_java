package memberjsp.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import memberjsp.bean.MemberjspDTO;
import memberjsp.bean.ZipcodeDTO;
import oracle.jdbc.proxy.annotation.GetCreator;
import sun.misc.Resource;

public class MemberjspDAO {
	private static MemberjspDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public MemberjspDAO() {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public static MemberjspDAO getInstance() {
		if (instance == null)
			synchronized (MemberjspDAO.class) {
				instance = new MemberjspDAO();
			}
		return instance;
	}

	public int write(MemberjspDTO memberDTO) {//-->회원가입
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int cnt=sqlSession.insert("memberSQL.write", memberDTO);
		sqlSession.commit();
		sqlSession.close();
		return cnt;
	}
	
	public boolean isExistId(String id) { //-->아이디중복,boolean형 안됨
		boolean exist=false;
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemberjspDTO memberDTO=sqlSession.selectOne("memberSQL.isExistId", id);
		if(memberDTO!=null) exist=true; //null아닌 경우,상관쿼리는 가능-->(null)을 잡아줌
		sqlSession.close();
		return exist;
	}
	
	public MemberjspDTO isLogin(String id,String pwd) { //-->로그인
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Map<String,String>map=new HashMap<>();
		map.put("id",id);
		map.put("pwd",pwd); 
		MemberjspDTO memberDTO= sqlSession.selectOne("memberSQL.isLogin", map);
		sqlSession.close();
		
		return memberDTO;
	}
	
	public MemberjspDTO getUser(String id) { // 로그인--> 회원정보 불러오기
		SqlSession sqlSession=sqlSessionFactory.openSession();
		MemberjspDTO dto=sqlSession.selectOne("memberSQL.getUser", id);
		sqlSession.close();
		return dto;
	}
	public void memberupdate(MemberjspDTO memberDTO) {//로그인 -->회원정보 수정 완료
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.selectOne("memberSQL.memberupdate", memberDTO);
		sqlSession.commit();
		sqlSession.close();
	}

	public List<ZipcodeDTO> getZipcodeList(Map<String, String> map) { //--> 주소(액션,DAO에서 어디서든 묶어도 상관없다.)
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<ZipcodeDTO>list=sqlSession.selectList("memberSQL.getZipcodeList", map);//selectList 자동으로 List를 제공
		sqlSession.close();
		return list;
	}

}

	