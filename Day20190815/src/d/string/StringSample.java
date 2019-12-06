package d.string;

import java.util.concurrent.CountDownLatch;

import javax.swing.text.StyleContext.SmallAttributeSet;
import javax.xml.soap.Text;

public class StringSample {
	public static void main(String[] args) {
		StringSample sample = new StringSample();

		//sample.constrictors();
		System.out.println(sample.nullCheck(null));
		sample.compareCheck();
		sample.equalsCheck();
		sample.compareToCheck();
		sample.addressCheck();
		sample.matchCheck();
		sample.indexOfCheck();
		sample.substringCheck();
		sample.splitCheck();
		sample.trimCheck();
		sample.replaceCheck();
		sample.formatCheck();
		sample.splitCheck2();

	}

	public void printByteArray(byte[]array) {
		try {
			String str = "한글";

			byte[] array1 = str.getBytes();
			printByteArray(array1);
			String str1 = new String(array1);
			System.out.println(str1);

			byte[] array2 = str.getBytes();
			printByteArray(array2);
			String str2 = new String(array2, "EUC-UR");
			System.out.println(str2);

			byte[] array3 = str.getBytes("UTF-16");
			printByteArray(array1);
			String str3 = new String(array3, "UTF-16");
			System.out.println(str3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean nullCheck(String text) {
//		int textLength=text.length();
//		System.out.println(textLength);
		if(text==null) return true;
		else return false;	
	}
	public void compareCheck() {
		String text="You must know String class.";
		System.out.println("text.length()="+text.length());
		System.out.println("text.isEmpty()=" +text.isEmpty());
	}
	public void equalsCheck() {
		String text="Check value";
		//String text2="Check value";
		String text2=new String("Check value");
		if(text==text2) {
			System.out.println("text==text2 result is name.");
		}else {
			System.out.println("text==text2 result is different");
		}
		if(text.equals("Check value")) {
			System.out.println("text.equals(text2) result is name");
		}
		String text3="Check value";
		if(text.equalsIgnoreCase(text3)){
			System.out.println("text.equalsIgnoreCase(text3) result is same");
		}
	}
	public void compareToCheck() {
		String text="a";
		String text2="b";
		String text3="c";
		System.out.println(text.compareTo(text));
		System.out.println(text.compareTo(text2));
		System.out.println(text.compareTo(text3));
	}

	public void addressCheck() {
//		String addresses[] = new String[] { "서울시 구로구 신림동", 
//				"경기도 성남시 분당구 정자동", "서울시 구로구 개봉동" };
//		int startCount = 0, endCount = 0;
//		String startText = "서울시";
//		String endText = "동";
//
//		for (String address : addresses) {
//			if (address.startsWith(startText)) //startsWith-특정 조건에 맞는 문자열이 있는지 확인하는 메소드
//				startCount++;
//			{
//			}
//			if (address.endsWith(endText)) //endsWith
//				endCount++;
//			{
//			}
//		}
//		System.out.println("Starts with"+ startText +" count is" + startCount);
//		System.out.println("Ends with"+ endText +" count is" + endCount);	
//		}
		//많은 데이터의 확인해야 유용하다
		String addresses[] = new String[] { "서울시 구로구 신림동", 
			"경기도 성남시 분당구 정자동", "서울시 구로구 개봉동" };
		int startCount=0,  endCount=0; int containCount=0;
		String startText="서울시";
		String endText="동";
		String containText="구로";
		for(String address:addresses) {
			if(address.startsWith(startText)) {
				startCount++;
			}
			if(address.endsWith(endText)) {
				endCount++;
			}
			if(address.contains(containText)) {
				containCount++;
			}
		}
		System.out.println("Starts with"+ startText + "count is " + startCount);
		System.out.println("Ends with"+ endText + "count is " + endCount);
		System.out.println("Contains"+ containText + "count is " + containCount);
		
	}
	
	public void matchCheck() {
		String text="This is a text";
		String compare1="is";
		String compare2="this";
		//regionMatches - 특정 영역이 메개 변수로 넘어온 문자열과 동일한지를 확인한데 사용
		System.out.println(text.regionMatches(2, compare1, 0, 1));
		//메개변수가 4인 메서드(2번째 또는 5번째가 is인지 확인, 0, 1은 i인지 아닌지 확인)
		System.out.println(text.regionMatches(5, compare1, 0, 2));
		//메개변수가 4인 메서드
		System.out.println(text.regionMatches(true, 0, compare2, 0, 4));
		//메개변수가 5개인 메서드
	}
	
	public void indexOfCheck() {
		
		String text="Java technology is both a programming languabe and a platform.";
		//text 문자열 길이 62.
		//indexof 앞에서 부터 0부터 시작
		System.out.println(text.indexOf('a'));
		//a는 Java의 a 첫 번쩨 이므로 1을 출력
		System.out.println(text.indexOf("a "));
		//Java 단어 뒤 공백이 있으모로 3을 출력
		System.out.println(text.indexOf('a',20));
		System.out.println(text.indexOf("a ", 20));
		System.out.println(text.indexOf('z'));
		//문장에 없으므로 -1
		
		//lastIndexof  62 뒤에서 부터 시작
		System.out.println(text.lastIndexOf('a'));
		System.out.println(text.lastIndexOf("a "));
		System.out.println(text.lastIndexOf('a',20));
		System.out.println(text.lastIndexOf("a ", 20));
		System.out.println(text.lastIndexOf('z'));
		
		char values[] = new char[] {'J', 'a', 'v', 'a'};
		String javaText=String.copyValueOf(values);
	}
	public void substringCheck() {
		String text="Java technology";
		//substring 5번째 부터 text문자열 끝나는 부분까지 짤라오도록
		String technology=text.substring(5);
		System.out.println(technology);
		//String tech=text.substring(5,4);
		//substring 문자가 끝나는 위치까지 짤라오는 것.
		String tech=text.substring(5,9);
		System.out.println(tech);
	}
	
	public void splitCheck() {
		
		String text="Java technology is both a programming languabe and a platform.";
		String[] splitArray=text.split(" ");
		//split 공백부터 단어를 짤라라
		for(String temp : splitArray) {
			System.out.println(temp);
		}	
	}
	public void splitCheck2() {
		String text="2019년 08월 16일 split 연습";
		String[]splitArray=text.split(" ");
		for(String temp : splitArray) {
			System.out.println(temp);
		}
	}
	public void trimCheck() {
		String strings[] = new String[] {"a"," b ", "  c","d  ","e  f","  "};
		for(String string:strings) {
			System.out.println("[" + string + "]");
			//trim 공백을 제거할때 유용하다 문자열의 앞과 뒤 있는 공백을 일일 찾아서 지워 버릴 필요 없이 사용하면 된다
			System.out.println("Trim[" + string.trim() + "]");
		}
	}
	public void replaceCheck() { // --> replace 내용을 교체하는 메서드
		String text="The String class represents character strings.";
		System.out.println(text.replace('s', 'z'));
		System.out.println(text);
		System.out.println(text.replace("tring", "trike"));
		System.out.println(text.replace(" ", "|"));
		System.out.println(text.replace(" ", "|"));
		
	}
	public void formatCheck() {
		//format 특정형식에 맞춰 값을 치환한다.
		String text="제 이름은 %s 입니다. 지금까지 %d 권의 책을 썼고,"+"하루에 %f %%의 시간을 책을 쓰는데 할애하고 있습니다";
		String realText=String.format(text, "이상민", 4, 10.5);
		System.out.println(realText);
	}
	

	

}
