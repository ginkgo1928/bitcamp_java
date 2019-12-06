package dbtest.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class UpdataTest {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="java";
	private String password="dkdlxl";
	
			
	private Connection conn;
	private PreparedStatement pstmt;
	private Scanner scan = new Scanner(System.in);
	public UpdataTest() {
		try {
			Class.forName(driver);
			System.out.println("드라이버로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(url,user,password);
			System.out.println("접속성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void ineserArtcle() {
		System.out.println("수정할 이름 입력");
		String name=scan.next();
		String sql="update dbtest set age=age+1 where name like ?";
		getConnection();
		try {
			pstmt=conn.prepareStatement(sql);//가이드 생성
			pstmt.setString(1, "%"+name+"%");
			int su=pstmt.executeUpdate();//실행-개수-리턴
			System.out.println(su+"rowsupdated");
			
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
	
	}
	public static void main(String[]args) {
		UpdataTest up=new UpdataTest();
		up.getConnection();
		up.ineserArtcle();
		
	}

}


