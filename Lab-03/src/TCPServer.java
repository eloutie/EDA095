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

public class TCPServer extends Thread {

	private ServerSocket server;
	private Scanner scan;
	private ArrayList<User> users;

	public TCPServer() throws IOException {
		this.server = new ServerSocket(30000);
		scan = new Scanner(System.in);
		users = new ArrayList<User>();
	}

	public void run() {
		System.out.println("Waiting for clients on port 30000.");
		
		while (true) {
		
			try {
				Socket socket = server.accept();
				InetAddress client = socket.getInetAddress();

				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();

				BufferedReader buff = new BufferedReader(new InputStreamReader(is));
				PrintWriter ps = new PrintWriter(os);

				System.out.println("Someone new entered our chatroom! They are from " + client.getHostName());
				ps.println("Welcome to our chat");

				ps.println("Pick a nickname: ");
				ps.flush();

				User user = new User(socket, buff.readLine());

				ps.println("Your name is " + user.getName());
				ps.flush();

				Mailbox mailbox = new Mailbox();
				
				Session session = new Session(ps, buff, mailbox, user);
				Thread t = new Thread(session);
				t.start();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}	
	}
}
