import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JavaClient
{
    public static void main(String[] args) {


        int port = 1220;

        try (Socket socket = new Socket(Inet4Address.getByName("localhost"), port)) {

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            Console console = System.console();
            String text;
            Scanner in;
            in = new Scanner(System.in);

            do {
                text = in.nextLine();



                writer.println(text);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                String time = reader.readLine();

                System.out.println(time);

            } while (!text.equals("bye"));

        } catch (UnknownHostException ex) {

            System.out.println("Server not found: " + ex.getMessage());

        } catch (IOException ex) {

            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
