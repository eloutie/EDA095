import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageGetter extends ThreadTCP{

	private BufferedReader buff;
	//private PrintWriter ps;
	private Mailbox mailbox;

	public MessageGetter(BufferedReader buff, PrintWriter ps, Mailbox mailbox, User user) throws IOException {
		super(buff, ps, user);
		// TODO Auto-generated constructor stub
		this.mailbox = mailbox;
	}

	@Override
	public void run() {

		String message;

		try {

			message = mailbox.getMessage();
			for (int i = 0; i < 10; i++) {
				ps.println(message);
			}
			
			ps.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
