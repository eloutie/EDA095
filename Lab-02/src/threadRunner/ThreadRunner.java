package threadRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ThreadRunner extends Thread {

	private List<URL> list;

	public ThreadRunner(List<URL> list) {
		this.list = list;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			URL url = null;

			try {
				synchronized (list) {
					if (list.isEmpty()) {
						break;
					} else {
						url = list.remove(0);
					}
				}
				
				System.out.println("Opening connection");
				InputStream in = url.openStream();
				String name = url.getFile();
				String filename = name.substring(name.lastIndexOf("/") + 1);
				FileOutputStream fos = new FileOutputStream(new File(filename));

				System.out.println("Reading from resource and writing to file...");
				int length = -1;

				byte[] buffer = new byte[1024];// buffer for portion of data
												// from
												// connection
				while ((length = in.read(buffer)) > -1) {
					fos.write(buffer, 0, length);
				}
				fos.close();
				in.close();
				System.out.println(filename + " downloaded\n");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
