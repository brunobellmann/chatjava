import java.io.*;
import java.net.*;

public class JavaClient
{
    private BufferedReader in;
    private BufferedWriter out;
    private Socket client;
    private int port;
    private Inet4Address host;

    public JavaClient(Inet4Address host, int port){
        this.host = host;
        this.port = port;
    }

    public void startClient(){
        try{
            client = new Socket(host, port);
            out = new BufferedWriter
                    (new OutputStreamWriter(client.getOutputStream()));

            //hier müsste nun jedes mal wenn der Button geklickt wird
            //die Nachricht versendet werden mit out.write( ? );out.newLine();out.flush();
            out.write("hallo", 5, 6);
            out.close();
        } catch (IOException e) { System.err.println(e); }
        finally{
            try{
                if(client != null)
                    client.close();
            }catch (IOException e) { System.err.println(e); }
        }
    }
}
