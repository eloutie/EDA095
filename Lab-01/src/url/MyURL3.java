package url;

import java.net.URL;


/**
 * @author pierre
 */
public class MyURL3 {

    public MyURL3() {
    }

    public static void main(String[] args) {
        try {
            URL myDoc1 = new URL("http://cs.lth.se/index.html");
            URL myDoc2 = new URL("http", "cs.lth.se", "/index.html");
            URL myDoc3 = new URL(new URL("http://cs.lth.se/EDA095/"), "labs.shtml");
            URL myDoc4 = new URL("http:////cs;lth.se\\^/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL myDoc5 = new URL("htp:////cs;lth.se\\^/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            URL myDoc6 = new URL("htp", "cs.lth,se", "/index.html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
