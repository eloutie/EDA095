import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer /**extends Thread*/ {

	private ServerSocket server;
	private Scanner scan;

	public TCPServer() throws IOException {
		this.server = new ServerSocket(30000);
		scan = new Scanner(System.in);
	}

	public void run() {

		while (true) {
			System.out.println("Trying to connect to " + server.getLocalPort() + "...");
			
			try {
				Socket connectionSocket = server.accept();
				InetAddress client = connectionSocket.getInetAddress();
				
				InputStream is = connectionSocket.getInputStream();
				OutputStream os = connectionSocket.getOutputStream();
				
				BufferedReader buff = new BufferedReader(new InputStreamReader(is));
				PrintWriter ps = new PrintWriter(os);
				
				System.out.println("Just connected to InetAddress " + client);
				
				while (true) {
					String message = buff.readLine();
					System.out.println("client said: " + message);
					ps.println(message);
					ps.flush();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
	}
}