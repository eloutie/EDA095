import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ClearMailboxThread extends ThreadTCP {

	private Mailbox mailbox;

	public ClearMailboxThread(BufferedReader buff, PrintWriter ps, Mailbox mailbox, User user) throws IOException {
		super(buff, ps, user);
		// TODO Auto-generated constructor stub
		this.mailbox = mailbox;
	}

	public void run() {
		while(true) {
			try {
				ps.println("Deleted " + mailbox.getMessage());
				double millis = Math.random();
				Thread.sleep((long) millis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
