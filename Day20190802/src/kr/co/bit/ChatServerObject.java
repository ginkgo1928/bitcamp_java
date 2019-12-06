
package kr.co.bit;
/*
 * 클라이언트 바꾸고 다음 서버 바꿀거 없음
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

class ChatServerObject {
	private ServerSocket ss;
	private ArrayList<ChatHandlerObject> list;

	public ChatServerObject(){
		try{
			ss = new ServerSocket(9500);
			System.out.println("서버준비완료");

			list = new ArrayList<ChatHandlerObject>();

			while(true){
				Socket socket = ss.accept();
				ChatHandlerObject handler = new ChatHandlerObject(socket, list);//스레드 생성
				handler.start();//스레드 시작

				list.add(handler);
			}//while
		}catch(IOException io){
			io.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChatServerObject();
	}
}
