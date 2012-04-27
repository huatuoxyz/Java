package com.gedero.www.java.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


class Send extends Thread{
	private Socket socket=null;
	public Send(Socket socket){
		this.socket=socket;
		this.start();
	}
	
	public void run(){
		try {
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Scanner sc = new Scanner(System.in);
			while(true){
				String str = sc.next();
				out.println("messageÅF"+str);
				if(str.equals("bye")){
					break;
				}
			}
			in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
