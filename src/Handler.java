import java.io.*;
import java.net.Inet4Address;
import java.net.*;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Scanner;

public class Handler
{
    private static Scanner scanner;
    private static int clientCounter;

    public static void main(String[] args)
    {
        int port = 1220;
        clientCounter = 0;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                clientCounter ++;
                new ServerThread(socket, clientCounter).start();


                /*InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String time = reader.readLine();

                System.out.println(time);*/
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
