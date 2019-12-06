package kr.co.bit;

import junit.framework.TestCase;

public class TestAssert extends TestCase {
	public void testAssert() {
		String today = DateUtil.getCurTimeAs8Digit();
		
		assertNotNull(today); //Assert클래스 매개변수 targe이 null인지 확인한다
		assertEquals("20120505", today); //두개의 매개변수 같은지 확인한다 (거짓 : failure)
		assertEquals("20190811", today); //(참 : success)
	}

}
