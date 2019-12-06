package kr.co.bit;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class URLTest {
	public static void main(String[] args) throws IOException, MalformedURLException {
		URL url=new URL("https://www.chanel.com/ko_KR/watches-jewelry/fine-jewelry/c/rings/J001000?show=All");
		BufferedReader br= new BufferedReader(new InputStreamReader(url.openStream()));
		String line=null;
		int count=0;
		int index=0;
		while((line=br.readLine())!=null) {
			line=line.toLowerCase();
			
			while((index=line.indexOf("18k",index))!=-1) {
				count++;
				index+=("18k".length());
			}
			index=0;
		}
		System.out.println("18K반지의 개수"+count+"개");
		br.close();
	}
}
