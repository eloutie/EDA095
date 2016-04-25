import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class TCPServer /**extends Thread*/ {

	private ServerSocket server;
	private Scanner scan;
	private ArrayList<User> users;

	public TCPServer() throws IOException {
		this.server = new ServerSocket(30000);
		scan = new Scanner(System.in);
		users = new ArrayList<User>();
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
				ps.println("Welcome to our chat");
				
				ps.println("Pick a nickname: ");
				ps.flush();
				User user = new User(client, buff.readLine());
				
				ps.println("Your name is " + user.getName());
				
				ps.flush();
				
				while (true) {
					String message = buff.readLine();
					System.out.println(user.getName() + " said: " + message);
					ps.println(message);
					ps.flush();
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}	
	}
}
