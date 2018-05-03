package miniServidorWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Socket socket = new Socket("localhost", 6500);
			System.out.println("Conectado no servidor...");
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Olá mundo!");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("desconectado.");
//			DataInputStream in = new DataInputStream(socket.getInputStream());
			
//			do{
//				out.writeUTF(JOptionPane.showInputDialog("Mensagem: "+Thread.currentThread().getName()));
//			} while (!socket.isClosed());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
