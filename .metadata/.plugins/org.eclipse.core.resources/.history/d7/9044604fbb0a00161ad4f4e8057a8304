import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Vilken port vill du ansluta till? ");
		int port = scan.nextInt();
		scan.close();
		try {
			TCPServer t = new TCPServer();
			t.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
 	}
}
