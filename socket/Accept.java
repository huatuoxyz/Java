package com.gedero.www.java.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Accept extends Thread{
	
	private Socket socket=null;
	public Accept(Socket socket){
		this.socket=socket;
		this.start();
	}
	
	public void run(){
		
		try {
			
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String inputLine;
			while((inputLine=in.readLine())!=null){
				System.out.println(inputLine);
			}
			
			in.close();
			out.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

