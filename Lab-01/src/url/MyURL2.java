package url;

import java.net.URL;

public class MyURL2 {

    public MyURL2() {
    }

    public static void main(String[] args) {
        try {
            URL myDoc1 = new URL("http://cs.lth.se/home/index.html");
            URL myDoc2 = new URL(myDoc1, "pierre.html");
            URL myDoc3 = new URL(myDoc1, "/pierre.html");
            URL myDoc4 = new URL(myDoc1, "http://lu.se/home/pierre.html");
            URL myDoc5 = new URL(myDoc1, "mailto:pierre@cs.lth.se");
            System.out.println("URL2: " + myDoc2.toString());
            System.out.println("URL3: " + myDoc3.toString());
            System.out.println("URL4: " + myDoc4.toString());
            System.out.println("URL5: " + myDoc5.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
