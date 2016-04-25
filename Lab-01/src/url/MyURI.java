/*
 * Main.java
 *
 * Created on 16 mars 2005, 17:41
 */
package url;

import java.net.URI;
import java.net.URL;

/**
 * @author pierre
 */
public class MyURI {

    /**
     * Creates a new instance of Main
     */
    public MyURI() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            URI myDoc1 = new URI("http://www.cs.lth.se/index.html");
            URI myDoc2 = new URI("http", "www.cs.lth.se", "index.html");
            URI myDoc3 = new URI("http:////www.cs.lth.se\\^/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL myDoc4 = new URL("htp:////www.cs.lth.se\\^/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL myDoc5 = new URL("htp", "www.cs.lth,se", "index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
