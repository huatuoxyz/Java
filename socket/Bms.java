package com.gedero.www.java.socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * 
 * @author dongrikin@gmail.com
 */

public class Bms extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel myPortLabel;
	private JLabel ipLabel, msgLabel;
	private JTextField myPortField, ipField, portField, msgField;
	private JTextArea resArea;
	private JScrollPane area;
	private JPanel panel;
	private JButton start;
	private JButton submit;
	private JButton connect;
	
	private PrintWriter out;
	
	public static void main(String[] args) {
		new Bms();
	}

	Bms() {
		super("BMS");
		
		try {
			/*
			LookAndFeelInfo[] info = UIManager.getInstalledLookAndFeels();
			for(int i=0;i<info.length; i++){
				System.out.println(info[i].getClassName());
			}
			*/
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception exc) {
		    System.err.println("Error loading L&F: " + exc);
		}
		
		myPortLabel = new JLabel("Server Port:");
		ipLabel     = new JLabel("IP & Port:");
		msgLabel    = new JLabel("Message:");
		myPortField = new JTextField("",5);
		portField   = new JTextField("",5);
		ipField     = new JTextField("");
		msgField    = new JTextField("");
		resArea     = new JTextArea("");
		area        = new JScrollPane(resArea);
		panel       = new JPanel();
		start       = new JButton("Start");
		submit      = new JButton("Send");
		connect     = new JButton("Connect");
		
		// GridBagLayout
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		// (0, 0)
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(myPortLabel, c);
		
		// (2, 0)
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(myPortField, c);
		
		// (3, 0)
		c.gridx = 3;
		c.gridy = 0; 
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(start, c);
		
		// (0, 1)
		c.gridx = 0; 
		c.gridy = 1; 
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(ipLabel, c);
		
		// (1, 1)
		c.gridx = 1;
		c.gridy = 1; 
		c.weightx = 1.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(ipField, c);
		
		// (2, 1)
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(portField, c);
		
		
		// (3, 1)
		c.gridx = 3;
		c.gridy = 1; 
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(connect, c);
		
		
		// (0, 2)
		c.gridx = 0; 
		c.gridy = 2;
		c.weightx = 0.0;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(msgLabel, c);
		
		// (1, 2)
		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1.0;
		c.gridwidth=3;
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(msgField, c);
		
		
		// Container
		Container cont = getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.NORTH);
		cont.add(area, BorderLayout.CENTER);
		cont.add(submit, BorderLayout.SOUTH);

		// addActionListener
		start.addActionListener(this);
		submit.addActionListener(this);
		connect.addActionListener(this);
		
		// frame setup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 600);
		setVisible(true);
		
		ipField.setEditable(false);
		portField.setEditable(false);
		connect.setEnabled(false);
		msgField.setEditable(false);
		submit.setEnabled(false);
		resArea.setEditable(false);
		
		resArea.setBackground(Color.getColor("silver"));
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==start){
			new Server();
		}else if (e.getSource()==connect){
			String ipaddress = "";
			try {
				ipaddress = ipField.getText();
				
				if (ipaddress.equals("")) return;
				
				int port = Integer.valueOf(portField.getText().trim());
				Socket socket = new Socket(ipaddress, port);
				
				out = new PrintWriter(socket.getOutputStream(),true);
				
				ipField.setEditable(false);
				portField.setEditable(false);
				connect.setEnabled(false);
				
				msgField.setEditable(true);
				submit.setEnabled(true);
				resArea.append(ipaddress+": connect successI\n");
			} catch (IOException e1) {
				resArea.append(ipaddress+": connect error!\n");
			}
		}else if(e.getSource()==submit){
			String msg = msgField.getText();
			if (msg.trim().equals("")) return;
			out.println(msg);
			msgField.setText("");
			resArea.append("me:"+msg+"\n");
		}
	}
	
	class Server extends Thread{
		public Server(){
			this.start();
		}
		public void run(){
			try {
				int port = Integer.valueOf(myPortField.getText().trim());
				ServerSocket socketServer = new ServerSocket(port);
				
				resArea.setText("Server startup. Port:"+port+"\n");
				
				ipField.setEditable(true);
				portField.setEditable(true);
				connect.setEnabled(true);
				
				myPortField.setEditable(false);
				start.setEnabled(false);
				
				while(true){
					try {
						Socket socket = socketServer.accept();
						String ip = socket.getInetAddress().toString().substring(1, socket.getInetAddress().toString().length());
						resArea.append(ip+" connecting\n");
						
						PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
						BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						
						String inputLine;
						while((inputLine=in.readLine())!=null){
							resArea.append(ip+":"+inputLine+"\n");
						}
						
						in.close();
						out.close();
						socket.close();

					} catch (IOException e) {
						resArea.append("disconnect.");
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

