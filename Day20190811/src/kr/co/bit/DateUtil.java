package kr.co.bit;

import java.util.Calendar;


public class DateUtil {
	public static String getCurTimeAs8Digit() { // 오늘 날짜를 String으로 반환한다.
		StringBuffer sb = new StringBuffer();
		Calendar cal = Calendar.getInstance();
		sb.append(cal.get(Calendar.YEAR));
		sb.append(String.format("%02d", cal.get(Calendar.MONTH) + 1));
		sb.append(String.format("%02d", cal.get(Calendar.DATE)));

		return sb.toString();
	}
}