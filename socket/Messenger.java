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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Messenger extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel msgLabel;
	private JTextField urlField, msgField;
	private JTextArea resArea;
	private JScrollPane area;
	private JPanel panel;
	private JButton submit;
	private JButton connect;
	private JComboBox combobox;
	
	private String url;
	private Socket socket;
	private PrintWriter out; 
	private int S_PORT=10000;
	private int C_PORT=10000;
	
	public static void main(String[] args) {
		new Messenger();
	}

	Messenger() {
		super("メッセンジャー");

		combobox = new JComboBox();
		combobox.addItem("通信相手選択");
		combobox.addItem("　<舩坂>");
		combobox.addItem("　<中野>");
		combobox.addItem("　<岩嵜>");
		combobox.addItem("　<　金>");
		
		combobox.addActionListener(this);
		
		// コンポーネントの作成
		msgLabel = new JLabel("メッセージ ");
		urlField = new JTextField("");
		msgField = new JTextField();
		resArea  = new JTextArea();
		area     = new JScrollPane(resArea);
		panel    = new JPanel();
		submit   = new JButton("送信");
		connect  = new JButton("接続");
		
		// GridBagLayoutの例
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// (0, 0)に追加
		c.gridx = 0; c.gridy = 0;
		c.weightx = 0.0;	// x方向に伸縮しない
		panel.add(combobox, c);
		// (1, 0)に追加
		c.gridx = 1;
		c.weightx = 1.0;	// x方向に伸縮する
		c.fill = GridBagConstraints.HORIZONTAL;	// 水平方向いっぱいに広がる
		panel.add(urlField, c);
		// (2, 0)に追加
		c.gridx = 2;
		c.weightx = 0.0;	// x方向に伸縮する
		//c.fill = GridBagConstraints.HORIZONTAL;	// 水平方向いっぱいに広がる
		panel.add(connect, c);
		
		
		// (0, 1)に追加
		c.gridx = 0; c.gridy = 1;
		c.weightx = 0.0;
		panel.add(msgLabel, c);
		// (1, 1)に追加
		c.gridx = 1;
		c.weightx = 1.0;
		c.gridwidth=2;		//colspan=2と同じ
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(msgField, c);

		// コンテント・ペインの取得
		Container cont = getContentPane();

		// コンテント・ペインへ部品を追加
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.NORTH);
		cont.add(area, BorderLayout.CENTER);
		cont.add(submit, BorderLayout.SOUTH);

		// リスナの登録
		submit.addActionListener(this);
		connect.addActionListener(this);
		
		// フレームのセットアップ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
		
		msgField.setEditable(false);
		resArea.setEditable(false);
		submit.setEnabled(false);
		resArea.setBackground(Color.getColor("silver"));
		new Server();
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==connect){
			try {
				url = urlField.getText();
				if (url.equals("")){
					resArea.append("通信相手を選択してください\n");
					return;
				}
				
				this.socket = new Socket(url, C_PORT);
				
				out = new PrintWriter(this.socket.getOutputStream(),true);
				
				connect.setEnabled(false);
				urlField.setEditable(false);
				combobox.setEnabled(false);
				
				msgField.setEditable(true);
				submit.setEnabled(true);
				resArea.append(url+"と接続成功！\n");
			} catch (IOException e1) {
				resArea.append("******"+url+" がみつかりません******\n");
				//e1.printStackTrace();
			}
			
			
		}else if(e.getSource()==submit){
			String msg = msgField.getText();
			if (msg.trim().equals("")){
				return;
			}
			out.println(msg);
			msgField.setText("");
			resArea.append("me:"+msg+"\n");
		}else if(e.getSource()==combobox){
			switch (((JComboBox)e.getSource()).getSelectedIndex()) {
			case 1:
				urlField.setText("169.254.244.??");
				break;
			case 2:
				urlField.setText("169.254.244.129");
				break;
			case 3:
				urlField.setText("169.254.244.61");
				break;
			case 4:
				urlField.setText("169.254.244.60");
				break;
			default:
				urlField.setText("");
				break;
			}
		}
	}
	
	class Server extends Thread{
		public Server(){
			this.start();
		}
		public void run(){
			try {
				ServerSocket socketServer = new ServerSocket(S_PORT);
				resArea.setText("サーバー起動...\n");
				resArea.append("通信相手を選択して「接続」ボタンをクリックしてください。\n");
				
				while(true){
					try {
						Socket socket = socketServer.accept();
						String ip = socket.getInetAddress().toString().substring(1, socket.getInetAddress().toString().length());
						resArea.append(ip+"から接続されました。\n");
						
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
						resArea.append("切断されました。");
						//e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

