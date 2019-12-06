package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

class URLTest2 {
	public static void main(String[] args) throws IOException, MalformedURLException {
		URL url = new URL("https://www.chanel.com/ko_KR/watches-jewelry/fine-jewelry/c/rings/J001000?show=All");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = null;
		int count = 0;
		int index = 0;
		while ((line = br.readLine()) != null) {
			line = line.toLowerCase(); // 라인을 전부 소문자로 바꾼다
			
			while ((index = line.indexOf("18k", index)) != -1) {
				count++;
				index += ("18K".length());
			}
			index = 0;
		}
		System.out.println("18k의 개수 = " + count + "개");
		br.close();
	}
}
