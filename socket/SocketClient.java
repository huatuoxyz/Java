package com.gedero.www.java.socket;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	
	private final static int PORT = 10000;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			Socket socket = new Socket("169.254.244.60", PORT);
			
			new Accept(socket);
			new Send(socket);
			
		} catch (UnknownHostException e) {
			// TODO
			e.printStackTrace();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
		

	}

}

