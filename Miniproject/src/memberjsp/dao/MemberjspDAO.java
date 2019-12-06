package memberjsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import memberjsp.bean.MemberjspDTO;
import memberjsp.bean.ZipcodeDTO;
import oracle.jdbc.proxy.annotation.GetCreator;

public class MemberjspDAO {
	private static MemberjspDAO instance;
	
	private DataSource ds;

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String user = "java";
//	private String password = "dkdlxl";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public MemberjspDAO() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");//tomcat의 경우
			
		} catch (NamingException e) {
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

	public int write(MemberjspDTO dto) {
		int cnt = 0;
	
		String sql = "insert into member values(?,?,?,?,?,?,?,?,?,?,?,?, sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getGender());
			pstmt.setString(5, dto.getEmail1());
			pstmt.setString(6, dto.getEmail2());
			pstmt.setString(7, dto.getTel1());
			pstmt.setString(8, dto.getTel2());
			pstmt.setString(9, dto.getTel3());
			pstmt.setString(10, dto.getZipcode());
			pstmt.setString(11, dto.getAddr1());
			pstmt.setString(12, dto.getAddr2());
			cnt = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnt;
	}

	public boolean isExistId(String id) {
		boolean exist = false;
		String sql = "select * from member where id=?";
	
		// pstmt: 자바 파일 안에서 오라클 명령 처리하기 위해 필요하다
		try {
			
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				exist = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return exist;
	}

	public MemberjspDTO isLogin(String id, String pwd) {// 로그인
		MemberjspDTO memberDTO=null;
		
		String sql = "select * from member where id = ? and pwd = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//ArrayList에 담으면 안된다.(Value,map에 받아야된다)
				memberDTO = new MemberjspDTO();
				memberDTO.setName(rs.getString("name"));
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPwd(rs.getString("pwd"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setEmail1(rs.getString("email1"));
				memberDTO.setEmail2(rs.getString("email2"));
				memberDTO.setTel1(rs.getString("tel1"));
				memberDTO.setTel2(rs.getString("tel2"));
				memberDTO.setTel3(rs.getString("tel3"));
				memberDTO.setZipcode(rs.getString("zipcode"));
				memberDTO.setAddr1(rs.getString("addr1"));
				memberDTO.setAddr2(rs.getString("addr2"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberDTO;
	}

	public MemberjspDTO getUser(String id) { // 로그인--> 회원정보 불러오기
		MemberjspDTO dto = null;
		String sql = "select * from member where id=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id); //1번 물음표 
			rs = pstmt.executeQuery();
			if (rs.next()) { // 하나밖에 없을 때 if문 쓰는게 편함
				dto = new MemberjspDTO();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPwd(rs.getString("pwd"));
				dto.setGender(rs.getString("gender"));
				dto.setEmail1(rs.getString("email1"));
				dto.setEmail2(rs.getString("email2"));
				dto.setTel1(rs.getString("tel1"));
				dto.setTel2(rs.getString("tel2"));
				dto.setTel3(rs.getString("tel3"));
				dto.setZipcode(rs.getString("zipcode"));
				dto.setAddr1(rs.getString("addr1"));
				dto.setAddr2(rs.getString("addr2"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (rs != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	public int memberupdate(MemberjspDTO dto) {//로그인 -->회원정보 수정 완료
	
		int su=0;
		String sql="update member set name=?, pwd=?, gender=?, email1=?,"
				+ " email2=?, tel1=?,tel2=?,tel3=?, zipcode=?,"
				+ "addr1=?, addr2=?, logtime=sysdate where id=?";
		try {
			conn = ds.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPwd());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getEmail1());
			pstmt.setString(5, dto.getEmail2());
			pstmt.setString(6, dto.getTel1());
			pstmt.setString(7, dto.getTel2());
			pstmt.setString(8, dto.getTel3());
			pstmt.setString(9, dto.getZipcode());
			pstmt.setString(10, dto.getAddr1());
			pstmt.setString(11, dto.getAddr2());
			pstmt.setString(12,dto.getId());
			su=pstmt.executeUpdate();
			System.out.println(su+"[회원수정 완료 DB]");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		return su;
	}

	public List<ZipcodeDTO> getZipcodeList(String sido, String sigungu, String roadname) { // 주소
		List<ZipcodeDTO> list = new ArrayList<ZipcodeDTO>();
		String sql = "select * from newzipcode where sido like ? " 
		+ "and nvl(sigungu,'0') like ? and roadname like?"; 																			// 넣기
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + sido + "%");
			pstmt.setString(2, "%" + sigungu + "%");
			pstmt.setString(3, "%" + roadname + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {// whlie문 쓸 때마다 zicodedto생성
				ZipcodeDTO zicodedto = new ZipcodeDTO();
				zicodedto.setZipcode(rs.getString("zipcode"));
				zicodedto.setSido(rs.getString("sido"));
				// 시군구 null값 제거, 조건연산자 사용
				/*
				 * if(rs.getString("sigungu")==null)-->삼항연산자로 쓰기 zicodedto.setSigungu(""); else
				 * zicodedto.setSigungu(rs.getString("sigungu"));
				 */
				zicodedto.setSigungu(rs.getString("sigungu") == null ? "" : rs.getString("sigungu"));
				zicodedto.setYubmyundong(rs.getString("yubmyundong"));
				zicodedto.setRi(rs.getString("ri") == null ? "" : rs.getString("ri"));
				zicodedto.setRoadname(rs.getString("roadname"));
				zicodedto.setBuildingname(rs.getString("buildingname") == null ? "" : rs.getString("buildingname"));
				list.add(zicodedto);// add담는다! while문이 참이 동안 dto를 담는다
				System.out.println(zicodedto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			list = null;// 에러가 나면 리스트를 null값으로 버린다
		}
		return list;
	}
}
