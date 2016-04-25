import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreadTCP extends Thread {

	protected BufferedReader buff;
	protected PrintWriter ps;
	protected User user;

	public ThreadTCP(BufferedReader buff, PrintWriter ps, User user) throws IOException {
		this.buff = buff;
		this.ps = ps;
		this.user = user;
	}

	public void run() {
		try {
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

