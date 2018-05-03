package miniServidorWeb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainSever {

	public static void main(String[] args) {
		
		try {

			ServerSocket serverSocket = new ServerSocket(6500);
			System.out.println("Aguardando conexões...");
			
			while(true){
				Socket s = serverSocket.accept();
				System.out.println("Cliente conectado...");
				new Thread(new ServerSocketProcessor(s)).start();
				
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
