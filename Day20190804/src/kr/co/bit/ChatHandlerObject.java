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
	public void run() {

			try {
				InfoDTO dto = null;
				String nickName = null;
				while (true) {
					dto=(InfoDTO)ois.readObject();
					if(dto.getCommand()==Info.JOIN){
						nickName=dto.getNickName();
						 InfoDTO sendDTO=new InfoDTO();
						 sendDTO.setCommand(Info.SEND);
						 sendDTO.setMessage(nickName+"님이 입장하셨습니다");
						 broadcast(sendDTO);
					}else if(dto.getCommand()==Info.EXIT) {
						list.remove(this);
						InfoDTO sendDTO=new InfoDTO();
						sendDTO.setCommand(Info.SEND);
						
						
						sendDTO.setCommand(Info.EXIT);
						sendDTO.setMessage(nickName+"님이 퇴장하셨습니다");
						oos.close();
						ois.close();
						oos.writeObject(sendDTO);
						oos.flush();
						socket.close();
						break;
					}else if(dto.getCommand()==Info.SEND) {
						InfoDTO sendDTO=new InfoDTO();
						sendDTO.setMessage(nickName+dto.getMessage());
						sendDTO.setCommand(Info.SEND);
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		
	}

	public void broadcast(InfoDTO sendDTO) {// 2.보내는쪽 생성
		for (ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException io) {
				io.printStackTrace();
			}
		} // for
	}
}
