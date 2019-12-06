package kr.co.bit;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

import javax.xml.ws.handler.MessageContext.Scope;

class ChatHandlerObject extends Thread {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private Socket socket;
	private ArrayList<ChatHandlerObject> list;

	public ChatHandlerObject(Socket socket, ArrayList<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void run(){//받는쪽 3번
		try{
			InfoDTO dto=null; 
			String nickName=null;
			while(true) {
			dto = (InfoDTO)ois.readObject();
			if(dto.getCommand()==Info.JOIN) {
				nickName=dto.getNickName();
				//모든 클라이언트에게 누가 들어왔는지 알려줘야한다(나까지포함)
				//모든 클라이언트 입장 메세지 보내기
				InfoDTO sendDTO = new InfoDTO();
				sendDTO.setCommand(Info.SEND);
				sendDTO.setMessage(nickName+"님이 입장하였습니다");
				broadcast(sendDTO);//모든 클라이언트에게 넘김
				
			}else if(dto.getCommand()==Info.EXIT) {//퇴장과 종료 두가지를 남겨야됨
				//나를 제외한 나머지 클라이언트에게 퇴장 메세지 보내기
					list.remove(this); // 리스트에서 나를 제거한다
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName + "님이 퇴장하셨습니다.");
					// 나한테는 exit를 보내기
					sendDTO.setCommand(Info.EXIT);
					oos.writeObject(sendDTO);
					oos.flush();

					ois.close();
					oos.close();
					socket.close();
					break;

				} else if (dto.getCommand() == Info.SEND) {
					System.out.println(dto.getMessage());
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("[" + nickName + "]" + dto.getMessage());
					broadcast(sendDTO);
					}
			}//while문
			} catch (IOException io) {
			io.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

	public void broadcast(InfoDTO sendDTO){//2.보내는쪽 생성
		for(ChatHandlerObject handler : list){
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException io) {
				io.printStackTrace();
			}
		}//for
	}
}







