package com.test.client02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class ChatManager {
	private ChatManager(){};
	private static final ChatManager instance = new ChatManager();
	public static ChatManager getCM(){
		return instance;
	}
	
	MainWindow window;
	Socket socket;
	BufferedReader reader;
	String IP;
	PrintWriter writer;
	
	public void setWindow(MainWindow window) {
		this.window = window;
	}
	public void connect(String ip){
		this.IP = ip;
		new Thread(){
			
			@Override
			public void run() {
				try {
					socket = new Socket(IP,12345);
					writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
					reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					
					String line;
					while((line = reader.readLine())!=null){
						
					}
					writer.close();
					reader.close();
					writer = null;
					reader = null;
					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
	}
	public void receiveFile(){
		try {
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
