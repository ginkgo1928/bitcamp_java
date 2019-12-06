package dbtest.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * DB설정
 * 1.Driver Loading(한 번만 해야된다)
 * 2.ojdbc7.jar(알집은 풀면 안된다. 내용을 보기 위해 쓴다)
 * 3.OrcleDriver.class-정확하게 모르니까 Class 몽타주를 잡음
 * 4.lib-폴더 생성-ojdbc-필드패스해줌
 * 5.메이븐: 서버에서 프로젝트에 필요한 거 전해준다
 * 6.Connection url,user,password
 * 7.PreparedStatement
 */
public class InsertTest {
	private String driver="oracle.jdbc.driver.OracleDriver";
	private String url="jdbc:oracle:thin:@localhost:1521:xe";
	private String user="java";
	private String password="dkdlxl";
	
			
	private Connection conn;
	private PreparedStatement pstmt;
	private Scanner scan;

	public InsertTest() {// 컨트롤 스페이스-기본생성자 단축키
		try {
			Class.forName(driver);// 타입을 모를 때 몰아부친다,풀쿼리네임
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// jdbc:oracle:드라이버명:포트명:데이베이스명
	}

	public void insertArtcle() {
		try {
			// 데이터 받아주기(오라클은 1번 부터시작)
			scan = new Scanner(System.in);
			System.out.println("이름 입력:");
			String name = scan.next();
			System.out.println("나이 입력:");
			int age = scan.nextInt();
			System.out.println("키 입력:");
			double height = scan.nextDouble();
			
			
			this.getConnection();//접속(끊었다 풀었다함)
			String sql="insert into dbtest va"
					+ "lues(?,?,?,sysdate)";
			pstmt = conn.prepareStatement(sql);// 보호하기 위해 ??사용,가이드
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);// 실행하기전에 만들어준다
			int su = pstmt.executeUpdate();// 실행-개수-리턴
			System.out.println(su + "row created");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {// 에러가 있어도 무조건 수행하라
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				}
			}
		}

	public static void main(String[]args) {
		InsertTest it=new InsertTest();//물귀신-생성자 부른다
		it.getConnection();
		it.insertArtcle();
		
	}
}
