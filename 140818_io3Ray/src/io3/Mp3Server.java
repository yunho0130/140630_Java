package io3;
// 가장 처음 구동

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Mp3Server {
	private ServerSocket serverSocket;
	public Mp3Server()throws Exception{
		serverSocket = new ServerSocket(5555);
		System.out.println("ready.....");
		waitClient();
	}

	private void waitClient() {
		System.out.println("클라이언트의 연결을 대기중...");
		Socket client = null;
		OutputStream out = null;
		InputStream in = null;
		byte[] buffer = new byte[1024*8];
		try{
			client = serverSocket.accept();
			System.out.println(client);
			out = client.getOutputStream();
			in = new FileInputStream("C:\\zzz\\aaa.mp3");
			while(true){
				int count = in.read(buffer);
				if(count == -1) { break; }
				out.write(buffer,0, count);
			}
			out.flush();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try {in.close();} catch (Exception e) {}
			try {out.close();} catch (Exception e) {}
			try {client.close();} catch (Exception e) {}
		}
		waitClient();
	}
	public static void main(String[] args)throws Exception {
		Mp3Server obj = new Mp3Server();
	}
}










