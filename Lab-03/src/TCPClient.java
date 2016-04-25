import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
	private Socket socket;
	private InputStream input;
	//private OutputStream output;
	private PrintWriter out;
	
	public TCPClient(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			
			try {
			input = socket.getInputStream();
			out = new PrintWriter(socket.getOutputStream());
			out.flush();
			
			} finally {
				socket.close();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
