/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package url;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author pierre
 */
public class HTTPTester {

    public static void main(String[] args) {
        Socket httpSocket;
        OutputStream out;
        InputStream in;
        byte[] command = {'G', 'E', 'T', ' ', '/', ' ', 'H', 'T', 'T', 'P', '/', '1', '.', '0', '\r', '\n', '\r', '\n'};
        int c;

        try {
            httpSocket = new Socket("cs.lth.se", 80);
            out = httpSocket.getOutputStream();
            in = httpSocket.getInputStream();
            out.write(command, 0, command.length);
            System.out.println(new String(command));
            c = in.read();
            while (c != -1) {
                System.out.print(Character.toChars(c));
                c = in.read();
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
