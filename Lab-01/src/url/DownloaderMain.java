package url;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DownloaderMain {

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv en url: ");
		String myURL = scan.next();
		List<URL> URLlist = new ArrayList<URL>();
		try {
			URL url = new URL(myURL);
			System.out.println(url.toString());
			LinkGetter lg = new LinkGetter();
			List<String> list = lg.getLinks(url.toString());

			for (String s : list) {
				if (s.endsWith(".pdf")) {
					URL u = new URL(url, s);
					URLlist.add(u);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		scan.close();
		int i = 0;
		for (URL url : URLlist) {
			download(url, "fil " + i + ".pdf");
			i++;
			System.out.println(url.toString());
		}
	}

	public static void download(URL u, String filename) {
		try {
			System.out.println("Opening connection");

			InputStream in = u.openStream();

			FileOutputStream fos = new FileOutputStream(new File(filename));

			System.out.println("Reading from resource and writing to file...");
			int length = -1;
			
			byte[] buffer = new byte[1024];// buffer for portion of data from
											// connection
			while ((length = in.read(buffer)) > -1) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			in.close();
			System.out.println("File downloaded\n");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
