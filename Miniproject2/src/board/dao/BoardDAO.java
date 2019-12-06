package board.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import board.bean.BoardDTO;
import oracle.net.aso.b;


public class BoardDAO {
	private static BoardDAO instance;
	private SqlSessionFactory sqlSessionFactory;
	
	public BoardDAO() {
		try {
			Reader reader=Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory =new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

	public static BoardDAO getInstance() {
		if (instance == null) {
			synchronized (BoardDAO.class) {
				instance = new BoardDAO();
			}
		}
		return instance;
	}

 
	 public void write(BoardDTO boardDTO) { //--> 글 등록 
	  SqlSession sqlSession=sqlSessionFactory.openSession(); 
	  sqlSession.insert("boardSQL.write", boardDTO); 
	  sqlSession.commit();
	  sqlSession.close();
	   
	  }
	 

	public List<BoardDTO> boardlist(int startNum, int endNum) { //-->게시판 글 목록
		Map<String,Integer>map=new HashMap<>();
		map.put("startNum",startNum);
		map.put("endNum",endNum);
		
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<BoardDTO>boardlist=sqlSession.selectList("boardSQL.boardlist", map);
		sqlSession.close();
		
		return boardlist;
	}
	public int getTotalA() {// -->게시판 전체글 갯수
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int totalA=sqlSession.selectOne("boardSQL.getTotalA");
		sqlSession.commit();
		sqlSession.close();
		return totalA;
	}
	public BoardDTO getBoardView(int seq) { //게시판-->글 보기
		SqlSession sqlSession=sqlSessionFactory.openSession();
		BoardDTO boarddto=sqlSession.selectOne("boardSQL.getBoardView",seq);
		sqlSession.close();
		return boarddto;
	}
	public void Boardupdate(Map<String, String> map) { //-->게시판 글 수정 
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.Boardupdate", map);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void boardHit(int seq) {// -->게시판 조회수 증가
		SqlSession sqlSession=sqlSessionFactory.openSession();
		sqlSession.update("boardSQL.boardHit", seq);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void boardreplay(BoardDTO boardDTO) {//-->답글
		
		BoardDTO pDTO=getBoardView(boardDTO.getPseq()); //-->원글
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//step update(step)-->ref 그룹번호 증가
		sqlSession.update("boardSQL.boardReply1",pDTO);
		
		//insert(원글그룹번호ref,원글Lev+1), 등록
		boardDTO.setRef(pDTO.getRef());
		boardDTO.setLev(pDTO.getLev()+1);
		boardDTO.setStep(pDTO.getStep()+1);
		sqlSession.insert("boardSQL.boardReply2", boardDTO);
		
		//reply update -->답글 수 증가
		sqlSession.update("boardSQL.boardReply3", boardDTO.getPseq());
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	public void boardreplaydelete(int seq) { //-->답글 삭제
		
		SqlSession sqlSession=sqlSessionFactory.openSession();

		//1.과일 원글 찾아가서 답글 감소(pesq,step)-->리플레이 줄임
		sqlSession.update("boardSQL.boardreplaydelete1",seq);
		
		//2.제목에 원글이 삭제 된 답글이라고 추가하기
		sqlSession.update("boardSQL.boardreplaydelete2",seq);
		
		//3.삭제
		sqlSession.delete("boardSQL.boardreplaydelete3",seq);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public List<BoardDTO> boardSearch(Map<String, String>map){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		List<BoardDTO>boli =sqlSession.selectList("boardSQL.boardSearch",map);
		sqlSession.close();
		return boli;
	}

	public int getSearchTotalA(Map<String, String> map) { //검색 갯수
		SqlSession sqlSession=sqlSessionFactory.openSession();
		int totalA=sqlSession.selectOne("boardSQL.getSearchTotalA",map);
		sqlSession.close();
		return totalA;
	}
}
			
