import java.net.Socket;
import java.io.*;

public class ServerThread extends Thread
{
    private Socket socket;
    private ServerThread partner;
    private PrintWriter writer;

    public ServerThread(Socket socket)
    {
        this.socket = socket;
        partner = null;
    }

    public void setChatpartner(ServerThread partner)
    {
        this.partner = partner;
    }

    public PrintWriter getWriter()
    {
        if (writer != null)
            return writer;
        else
            return null;
    }

    public void run()
    {
        try
        {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String text;

            do
            {
                text = reader.readLine();
                if (text.equals("bye"))
                {
                    System.out.println("Client disconnected");
                    writer.println("You diconnected");
                } else
                {
                    writer.println("Partner: " + text);
                }

            } while (!text.equals("bye"));

            socket.close();
        } catch (IOException ex)
        {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
