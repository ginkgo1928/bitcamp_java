package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardDTO;


public class BoardDAO {
	private static BoardDAO instance;

	// 커넥션 풀로 이사가서 필요 없음.
	private DataSource ds;

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
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

	public int write(BoardDTO boardDTO) { // 글 등록
		int cnt = 0;
		String sql = "insert into board(seq,id,name,email,subject,content,ref) "
				+ "values(seq_board.nextval,?,?,?,?,?,seq_board.currval)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getEmail());
			pstmt.setString(4, boardDTO.getSubject());
			pstmt.setString(5, boardDTO.getContent());

			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public List<BoardDTO> boardlist(int startNum, int endNum) {//-->게시판 글 계산
		List<BoardDTO> boardlist = new ArrayList<BoardDTO>(); // List는 생성 할때 ArrayList를 생성!

		String sql = "select * from" + " (select rownum rn, " + "tt.* from(select seq,id,name,email,subject"
				+ ",content,ref,lev,step,pseq,reply,hit," + "to_char(logtime, 'YYYY.MM.DD') as logtime "
				+ "from board order by ref desc, step asc)tt)" + "where rn>=? and rn<=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDTO boarddto = new BoardDTO();
				boarddto.setSeq(rs.getInt("seq"));
				boarddto.setId(rs.getString("id"));
				boarddto.setName(rs.getString("name"));
				boarddto.setEmail(rs.getString("email"));
				boarddto.setSubject(rs.getString("subject"));
				boarddto.setContent(rs.getString("content"));
				boarddto.setRef(rs.getInt("ref"));
				boarddto.setLev(rs.getInt("lev"));
				boarddto.setStep(rs.getInt("step"));
				boarddto.setPseq(rs.getInt("pseq"));
				boarddto.setReply(rs.getInt("reply"));
				boarddto.setHit(rs.getInt("hit"));
				boarddto.setLogtime(rs.getString("logtime"));
				boardlist.add(boarddto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			boardlist = null;
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boardlist;
	}

	public int getTotalA() {// -->게시판 전체글 개수
		int totalA = 0;
		String sql = "select count(*) from board";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			totalA = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return totalA;
	}

	public BoardDTO getBoardView(int seq) { //게시판-->글 보기
		BoardDTO boarddto = null;
		String sql = "select * from board where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				boarddto = new BoardDTO();
				boarddto.setSeq(rs.getInt("seq"));
				boarddto.setId(rs.getString("id"));
				boarddto.setName(rs.getString("name"));
				boarddto.setEmail(rs.getString("email"));
				boarddto.setSubject(rs.getString("subject"));
				boarddto.setContent(rs.getString("content"));
				boarddto.setRef(rs.getInt("ref"));
				boarddto.setLev(rs.getInt("lev"));
				boarddto.setStep(rs.getInt("step"));
				boarddto.setPseq(rs.getInt("pseq"));
				boarddto.setReply(rs.getInt("reply"));
				boarddto.setHit(rs.getInt("hit"));
				boarddto.setLogtime(rs.getString("logtime"));
				}
			} catch (SQLException e) {
			e.printStackTrace();
			} finally {
			try {
				if (rs != null)rs.close();
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return boarddto;
	}

	public void Boardupdate(Map<String, String> map) { //-->글 수정 맵은 void 반환할 값이 없다. 
		int su=0;
		String sql = "update board set subject=?, content=?, logtime=sysdate where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("subject"));
			pstmt.setString(2, map.get("content"));
			pstmt.setInt(3, Integer.parseInt(map.get("seq")));
			pstmt.executeUpdate();
			System.out.println(su + "[DB게시글 수정완료]");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void boardHit(int seq) {// -->해당 글 조회수 증가

		String sql = "update board set hit=hit+1 where seq=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)pstmt.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}