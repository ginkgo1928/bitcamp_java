package kr.co.bit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
	public static void main(String[] args)throws IOException,MalformedURLException{
		URL url=new URL("https://www.kakaocorp.com/service/KakaoTalk?lang=ko");
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		String line=null;
		int index=0;
		int count=0;
		
		while((line=br.readLine()) != null) {
			line=line.toLowerCase();
			while((index=line.indexOf("kakao",index))!= -1) {
				count++;
				index+=("kakao".length());
				
			}
			
		}
		System.out.println("카카오 갯수"+count);
		br.close();
	}
}
