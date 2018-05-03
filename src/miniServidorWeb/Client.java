package miniServidorWeb;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String host = args[0].split(":")[0];
		int port = Integer.parseInt( args[0].split(":")[1].split("/")[0] );
		String file = args[0].split(":")[1].split("/")[1];
		
		try {
			
			Socket socket = new Socket(host, port);
			System.out.println("Conectado no servidor...");
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("Olá mundo! " + file);
			try {
				Thread.sleep(10000);
				socket.close();
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
