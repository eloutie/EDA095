import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Welcome to our chat");
		//scan.close();
		try {
			TCPServer t = new TCPServer();
			t.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
}
