import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class HTMLDownloader {

	public static String getUrlSource(String url) throws IOException {
		String line = null;
		try {
        	URL myDoc = new URL(url);
	         InputStream is = myDoc.openStream();
	         BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
	         
	         while ((line = buffer.readLine()) != null) {
	        	 System.out.println(line);
	         }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return line;
    }

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Skriv en url: ");
		String input = scan.nextLine();
		try {
			System.out.println(getUrlSource(input));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
