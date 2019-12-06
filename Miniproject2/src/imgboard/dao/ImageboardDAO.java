package imgboard.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import imgboard.bean.ImgboardDTO;

public class ImageboardDAO {
	private static ImageboardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	public ImageboardDAO() {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static  ImageboardDAO getInstance() {// --> 싱글톤
		if(instance==null) {
			synchronized (ImageboardDAO.class) {
				instance=new ImageboardDAO();
			}
		}
		return instance;
	}
	
	public void imgwrite(ImgboardDTO imgDTO) { //-->이미지 게시판 글등록
		  SqlSession sqlSession=sqlSessionFactory.openSession(); 
		  sqlSession.insert("imgSQL.imgwrite", imgDTO); 
		  sqlSession.commit();
		  sqlSession.close();	
	}
	
	public int imgboardtotalA() { //-->이미지 게시판 전체 갯수
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int totalA=sqlSession.selectOne("imgSQL.imgboardtotalA");
		sqlSession.close();
		return totalA;
	}
	
	public List<ImgboardDTO> getimgboardList(int startNum, int endNum){  //-->이미지 게시판 목록
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Map<String,Integer>map=new HashMap<>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		List<ImgboardDTO>imglist=sqlSession.selectList("imgSQL.getimgboardList",map);
		sqlSession.close();
		return imglist;
	}
	
	public ImgboardDTO imgboardview(int seq) { //-->상품보기
		SqlSession sqlSession=sqlSessionFactory.openSession();
		ImgboardDTO imgdto=sqlSession.selectOne("imgSQL.imgboardview",seq);
		sqlSession.close();
		return imgdto;
	}
	public void imgboardDelete(String[]check) {
		SqlSession sqlSession=sqlSessionFactory.openSession();
		Map<String,String[]>map=new HashMap<String,String[]>();
		map.put("check",check);
		sqlSession.delete("imgSQL.imgboardDelete",map);
		sqlSession.commit();//삭제할 때 락 꼭 풀어주기!!!
		sqlSession.close();
		
	}
}


