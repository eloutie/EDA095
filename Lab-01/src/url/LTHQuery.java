package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class LTHQuery {

    public LTHQuery() {
    }

    public static void main(String[] args) {
        try {
            URL myDoc = new URL("http://cs.lth.se/sok/?s=1&so=1&i=sv&category=cs&q=nugues&x=S%F6k");
            InputStream is = myDoc.openStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
