package miniServidorWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ServerSocketProcessor implements Runnable {
	
	Socket socketClient;
	DataInputStream in;
	DataOutputStream out;
	
	public ServerSocketProcessor(Socket socket){
		this.socketClient = socket;
	}

	@Override
	public void run() {
		
		try {
			in = new DataInputStream( socketClient.getInputStream());
			System.out.println(in.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
