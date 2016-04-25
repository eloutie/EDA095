package url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class DecodeTest {

    public static void main(String[] args) {
        try {
            System.out.println(URLDecoder.decode("S%C3%B6k", "UTF-8"));
            System.out.println(URLDecoder.decode("S%F6k", "ISO-8859-1"));
            System.out.println(URLDecoder.decode("S%C3%B6k", "ISO-8859-1"));
            System.out.println(URLDecoder.decode("S%F6k", "UTF-8"));
            System.out.println(URLDecoder.decode("This+string+has+spaces", "UTF-8"));
            System.out.println(URLDecoder.decode("This*string*has*asterisks", "UTF-8"));
            System.out.println(URLDecoder.decode("This%25string%25has%25percent%25signs", "UTF-8"));
            System.out.println(URLDecoder.decode("This%C3%A9string%C3%A9has%C3%A9non-ASCII characters", "UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException("Broken VM does not support UTF-8");
        }
    }
}
