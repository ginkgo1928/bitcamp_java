package kr.co.bit;
import junit.framework.TestCase; //빌드패스에서 JUnti4

public class TestDateUtil extends TestCase{
	public void testGetCurTimeAs8Digit() {
		System.out.println("Date"+ DateUtil.getCurTimeAs8Digit()); //오늘 날짜 출력, test클래스 상속
	}

}
