package url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class ViewHTML {

    public ViewHTML() {
    }

    public static void main(String[] args) {
        try {
            URL myDoc = new URL("http://cs.lth.se/pierre_nugues");
            //URL myDoc = new URL("http://cs.lth.se/fileadmin/_processed_/csm_hitta_01_4e84950ea8.png");
            //URL myDoc = new URL("http", "cs.lth.se", "/eda095");
            //URL myDoc = new URL("http://cs.lth.se/eda095");
            //URL myDoc = new URL(new URL("http://cs.lth.se/"), "/eda095/laborationer/");
            //URL myDoc = new URL("http://cs229.stanford.edu/notes/cs229-notes1.pdf");

            System.out.println(myDoc.toString());
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
