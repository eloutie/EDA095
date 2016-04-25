package url;

import java.net.URL;

public class MyURL4 {

    public MyURL4() {
    }

    public static void main(String[] args) {
        try {
            URL myDoc1 = new URL("http://cs.lth.se:80/pierre/index.html");
            URL myDoc2 = new URL("http", "cs.lth.se", (int) 80, "/pierre/index.html");
            URL myDoc3 = new URL("http:////cs;lth.se:80\\^/pierre/index.html");
            System.out.println("Protocols: " + myDoc1.getProtocol() + " " + myDoc2.getProtocol() + " " + myDoc3.getProtocol());
            System.out.println("Files: " + myDoc1.getFile() + " " + myDoc2.getFile() + " " + myDoc3.getFile());
            System.out.println("Ports: " + myDoc1.getPort() + " " + myDoc2.getPort() + " " + myDoc3.getPort());
            System.out.println("Hosts: " + myDoc1.getHost() + " " + myDoc2.getHost() + " " + myDoc3.getHost());
            System.out.println("Paths: " + myDoc1.getPath() + " " + myDoc2.getPath() + " " + myDoc3.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
