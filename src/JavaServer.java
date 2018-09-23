import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServer {


    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(1220);
            System.out.println("Server is on");

            Socket client = server.accept();


            //Input- und Outputstreams

            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            InputStream in = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            //-----------------------------------

            String s = null;

            while ((s = reader.readLine()) != null) {
                System.out.println("Recieved from client " + s);

            }

            writer.close();
            reader.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
