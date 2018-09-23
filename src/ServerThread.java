import java.net.Socket;
import java.io.*;

public class ServerThread extends Thread
{
    private Socket socket;
    private int id;

    public ServerThread(Socket socket, int id)
    {
        this.socket = socket;
        this.id = id;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);


            String text;

            do {
                text = reader.readLine();

                if(text.equals("bye")) {
                    System.out.println("Client disconnected");
                    writer.println("Server: You are disconnected");
                }
                else
                {
                    String reverseText = new StringBuilder(text).reverse().toString();
                    writer.println("Server: " + reverseText);
                }

            } while (!text.equals("bye"));

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
