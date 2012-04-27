package com.gedero.www.java.socket;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

	private final static int PORT = 10000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			ServerSocket socketServer = new ServerSocket(PORT);
			
			while(true){
				try{
					
					System.out.println("サーバー起動...");
					Socket socket = socketServer.accept();
					new Accept(socket);
					new Send(socket);
					
				}catch (Exception ex){
					ex.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}



