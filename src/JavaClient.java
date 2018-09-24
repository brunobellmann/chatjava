import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JavaClient
{
    public static void main(String[] args)
    {

        Scanner in;
        String message;

        in = new Scanner(System.in);

        System.out.print("Enter host: ");
        String host = in.nextLine();

        System.out.print("Enter Serverport: ");
        int port = in.nextInt();

        try (Socket socket = new Socket(Inet4Address.getByName(host), port))
        {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            do
            {
                message = in.nextLine();
                writer.println(message);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String time = reader.readLine();
                System.out.println(time);

            } while (!message.equals("bye"));

        } catch (UnknownHostException ex)
        {
            System.out.println("Server not found: " + ex.getMessage());
        } catch (IOException ex)
        {
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
