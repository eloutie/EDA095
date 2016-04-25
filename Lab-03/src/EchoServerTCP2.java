import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class EchoServerTCP2 {
	
	public static ArrayList<Socket> connections = new ArrayList<Socket>();
	public static ArrayList<User> users = new ArrayList<User>();

	public static void main(String[] args) throws IOException {
		System.out.println("Let's start.");
		ServerSocket server = null;
		try {
			server = new ServerSocket(30000);
			Mailbox mailbox = new Mailbox();
			System.out.println("Waiting for clients on port 3000");
			while (true) {
				
				Socket connectionSocket = server.accept();
				
				connections.add(connectionSocket);
				
				System.out.println("Just connected to " + connectionSocket.getInetAddress().getHostName());
				
				InputStream is = connectionSocket.getInputStream();
				OutputStream os = connectionSocket.getOutputStream();
				BufferedReader buff = new BufferedReader(new InputStreamReader(is));
				PrintWriter ps = new PrintWriter(os);
				
				System.out.println("Välj användarnamn: ");
				Scanner scan = new Scanner(System.in);
				String username = buff.readLine();
				User user = new User(username);
				users.add(user);
				System.out.println("User " + user.getName() + " joined the chatt");
				
				ThreadTCP session = new ThreadTCP(buff, ps, user);
				
				session.start();

			}

		} catch (Exception e) {
			e.printStackTrace();
			server.close();
		}
	}
}
