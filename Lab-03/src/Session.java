import java.io.BufferedReader;
import java.io.PrintWriter;

public class Session {
	
	private PrintWriter ps;
	private BufferedReader buff;
	private Mailbox mailbox;
	private User user;
	private String message;
	
	public Session(PrintWriter ps, BufferedReader buff, Mailbox mailbox, User user) {
		this.ps = ps;
		this.buff = buff;
		this.mailbox = mailbox;
		this.user = user;
		message = "";
	}
}
