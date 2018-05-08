package miniServidorWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		String host, file;
		int port;
		
		if(args == null || args.length==0 ){
			System.out.println("Digite o endereço e tente novamente.");
			return;
		}
		host = args[0].split(":")[0];
		try {
			port = Integer.parseInt(args[0].split(":")[1].split("/")[0]);			
		} catch (Exception e) {
			System.out.println("Redirecionando para a porta 6500...");
			port = 6500;
		}
		try{
			file = args[0].split(":")[1].split("/")[1] ;
		}catch(Exception e ){
			file = "index.html";
		}

		try {

			Socket socket = new Socket(host.split("/")[0], port);
			System.out.println("Conectado no servidor...");
			DataOutputStream request = new DataOutputStream(socket.getOutputStream());
			DataInputStream response = new DataInputStream(new DataInputStream(socket.getInputStream()));

			request.writeUTF(file);
			String status ;
			status = response.readUTF();
			if(status.equals("200")){				
				do{
					status = response.readUTF();
					if(!status.equals("\\EOF"))
						System.out.println(status);
				}while(!status.equals("404") && !status.equals("\\EOF"));
			}else
				System.out.println(status + " Not Found\nPágina não encontrada!");
			
			try {
				Thread.sleep(10000);
				socket.close();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("desconectado.");

		} catch (IOException e) {
			
			System.out.println("Servidor não encontrado!\n"
					+ "Verifique se a URL "+ host +":"+port+ " está correta.\n"
					+ "Tente novamente...");
		}

	}

}
