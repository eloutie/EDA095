import java.io.BufferedReader;
import java.io.PrintWriter;

public class Session extends Thread{

	private PrintWriter ps;
	private BufferedReader buff;
	private Mailbox mailbox;
	private User user;
	private String message;

	public Session(PrintWriter ps, BufferedReader buff, Mailbox mailbox, User user){
		this.ps = ps;
		this.buff = buff;
		this.mailbox = mailbox;
		this.user = user;
		message = "";
	}

	public void run() {
		while (true) {

			try {
				message = buff.readLine();
				mailbox.write(user, message);
				String mess = mailbox.getMessage();
				System.out.println(user.getName() + " said: " + mess);
				
				ps.flush();
			} catch (Exception e) {
				
			}
		}
	}
}
