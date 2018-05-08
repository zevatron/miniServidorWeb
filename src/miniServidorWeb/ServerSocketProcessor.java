package miniServidorWeb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.filechooser.FileNameExtensionFilter;

public class ServerSocketProcessor implements Runnable {

	Socket socketClient;
	DataInputStream in;
	DataOutputStream out;
	File dir;

	public ServerSocketProcessor(Socket socket) {
		this.socketClient = socket;
		dir = new File("www");
	}

	@Override
	public void run() {

		try {
			in = new DataInputStream(socketClient.getInputStream());
			out = new DataOutputStream(new DataOutputStream(socketClient.getOutputStream()));
			final String readUTF = in.readUTF();
			
			if (Arrays.asList(dir.list()).contains(readUTF)) {
				out.writeUTF("200");
				File f = new File("www/"+readUTF);
				Scanner scanner = new Scanner(f);
				
				while(scanner.hasNextLine()){
					out.writeUTF(scanner.nextLine());
				}
				out.writeUTF("\\EOF");
				
			} else {
				out.writeUTF("404");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
