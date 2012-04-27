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
		super("���b�Z���W���[");

		combobox = new JComboBox();
		combobox.addItem("�ʐM����I��");
		combobox.addItem("�@<�t��>");
		combobox.addItem("�@<����>");
		combobox.addItem("�@<�⛽>");
		combobox.addItem("�@<�@��>");
		
		combobox.addActionListener(this);
		
		// �R���|�[�l���g�̍쐬
		msgLabel = new JLabel("���b�Z�[�W ");
		urlField = new JTextField("");
		msgField = new JTextField();
		resArea  = new JTextArea();
		area     = new JScrollPane(resArea);
		panel    = new JPanel();
		submit   = new JButton("���M");
		connect  = new JButton("�ڑ�");
		
		// GridBagLayout�̗�
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		// (0, 0)�ɒǉ�
		c.gridx = 0; c.gridy = 0;
		c.weightx = 0.0;	// x�����ɐL�k���Ȃ�
		panel.add(combobox, c);
		// (1, 0)�ɒǉ�
		c.gridx = 1;
		c.weightx = 1.0;	// x�����ɐL�k����
		c.fill = GridBagConstraints.HORIZONTAL;	// �������������ς��ɍL����
		panel.add(urlField, c);
		// (2, 0)�ɒǉ�
		c.gridx = 2;
		c.weightx = 0.0;	// x�����ɐL�k����
		//c.fill = GridBagConstraints.HORIZONTAL;	// �������������ς��ɍL����
		panel.add(connect, c);
		
		
		// (0, 1)�ɒǉ�
		c.gridx = 0; c.gridy = 1;
		c.weightx = 0.0;
		panel.add(msgLabel, c);
		// (1, 1)�ɒǉ�
		c.gridx = 1;
		c.weightx = 1.0;
		c.gridwidth=2;		//colspan=2�Ɠ���
		c.fill = GridBagConstraints.HORIZONTAL;
		panel.add(msgField, c);

		// �R���e���g�E�y�C���̎擾
		Container cont = getContentPane();

		// �R���e���g�E�y�C���֕��i��ǉ�
		cont.setLayout(new BorderLayout());
		cont.add(panel, BorderLayout.NORTH);
		cont.add(area, BorderLayout.CENTER);
		cont.add(submit, BorderLayout.SOUTH);

		// ���X�i�̓o�^
		submit.addActionListener(this);
		connect.addActionListener(this);
		
		// �t���[���̃Z�b�g�A�b�v
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
					resArea.append("�ʐM�����I�����Ă�������\n");
					return;
				}
				
				this.socket = new Socket(url, C_PORT);
				
				out = new PrintWriter(this.socket.getOutputStream(),true);
				
				connect.setEnabled(false);
				urlField.setEditable(false);
				combobox.setEnabled(false);
				
				msgField.setEditable(true);
				submit.setEnabled(true);
				resArea.append(url+"�Ɛڑ������I\n");
			} catch (IOException e1) {
				resArea.append("******"+url+" ���݂���܂���******\n");
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
				resArea.setText("�T�[�o�[�N��...\n");
				resArea.append("�ʐM�����I�����āu�ڑ��v�{�^�����N���b�N���Ă��������B\n");
				
				while(true){
					try {
						Socket socket = socketServer.accept();
						String ip = socket.getInetAddress().toString().substring(1, socket.getInetAddress().toString().length());
						resArea.append(ip+"����ڑ�����܂����B\n");
						
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
						resArea.append("�ؒf����܂����B");
						//e.printStackTrace();
					}
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}

