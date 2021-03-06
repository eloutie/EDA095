public class Mailbox {
	
	private User user;
	private String message;
	
	public Mailbox() {
		this.user = null;
		message = "";
	}
	
	public synchronized void write(User user, String message) throws InterruptedException {
		this.user = user;
		while(!message.equals("")) {
			wait();
		}
		
		this.message = user.getName() + message;
		
		notifyAll();
	}
	
	public synchronized String getMessage() throws InterruptedException {
		while(!message.equals("")) {
			wait();
		}
		
		String temp = message;
		message = "";
		user = null;
		notifyAll();
		return temp;
	}
}
