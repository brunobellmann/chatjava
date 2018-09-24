import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Handler
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter port: ");
        int port = in.nextInt();

        try (ServerSocket serverSocket = new ServerSocket(port))
        {

            System.out.println("Server is listening on port " + port);

            while (true)
            {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                ServerThread newThread = new ServerThread(socket);
                newThread.start();


                String text = in.nextLine();

                if (text.equals("exit"))
                    serverSocket.close();
            }
        } catch (IOException ex)
        {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
            System.exit(0);
        }
    }
}
