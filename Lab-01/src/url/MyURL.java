package url;

import java.net.URL;


/**
 * @author pierre
 */
public class MyURL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            URL myDoc1 = new URL("http://cs.lth.se/index.html");
            URL myDoc2 = new URL("http", "cs.lth.se", "/index.html");
            URL myDoc3 = new URL("http", "cs.lth.se", "index.html");
            URL myDoc4 = new URL(new URL("http://cs.lth.se/EDA095/"), "labs.shtml");
            URL myDoc5 = new URL(new URL("http://cs.lth.se/EDA095"), "labs.shtml");
            System.out.println(myDoc1.toString());
            System.out.println(myDoc2.toString());
            System.out.println(myDoc3.toString());
            System.out.println(myDoc4.toString());
            System.out.println(myDoc5.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
