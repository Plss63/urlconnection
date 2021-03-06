package url;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConn {


/**
 * return urladdress in file with name
 * @param urladdr
 * @param name
 */
public void url(String urladdr, String name){
        try {
             URL connection = new URL(urladdr);
             HttpURLConnection urlconn;
             urlconn = (HttpURLConnection) connection.openConnection();
             urlconn.setRequestMethod("GET");
             urlconn.connect();
             InputStream in = null;
             in = urlconn.getInputStream();
             OutputStream writer = new FileOutputStream("C:/Mydir/" + name + ".html");
             byte buffer[] = new byte[in.read()];
             int i = in.read(buffer);
             while (i > 0) {
                 writer.write(buffer, 0, i);
                 i = in.read(buffer);
             }
             writer.flush();
             writer.close();
             in.close();
         } catch (IOException e) {
             System.out.println(e);
         }
}

public static void main(String[] args){
    Argument argument = new Argument();
    argument.make(args);
    UrlConn ur = new UrlConn();
    ur.url(argument.makeprint("urladdr"), argument.makeprint("name"));
}


}