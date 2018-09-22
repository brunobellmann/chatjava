import java.net.Inet4Address;
import java.net.UnknownHostException;

public class Handler
{

    public static void main(String[] args)
    {

        JavaClient myClient = null;
        try
        {
            myClient = new JavaClient((Inet4Address) Inet4Address.getByName("141.30.207.44"), 2223 );
        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        myClient.startClient();
    }
}
