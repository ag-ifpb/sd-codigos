import java.util.Hashtable;
import java.util.Vector;

import javax.xml.bind.JAXB;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcClientRequest;
import org.apache.xmlrpc.XmlRpcClientRequestProcessor;
import org.apache.xmlrpc.XmlRpcClientResponseProcessor;
import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.XmlRpcHandlerMapping;
import org.apache.xmlrpc.XmlRpcResponseProcessor;

public class JavaClient {

    // The location of our server.
//    private final static String server_url =
//        "http://xmlrpc-c.sourceforge.net/api/sample.php";
    
    private final static String server_url =
        "http://localhost:9999/RPC2";

    public static void main (String [] args) {
        try {

            // Create an object to represent our server.
            XmlRpcClient server = new XmlRpcClient(server_url);

            // Build our parameter list.
            Vector params = new Vector();
            params.addElement(new Integer(5));
            params.addElement(new Integer(3));

            // Call the server, and get our result.
            Hashtable result = (Hashtable) server.execute("sample.sumAndDifference", params);
            int sum = ((Integer) result.get("sum")).intValue();
            int difference = ((Integer) result.get("difference")).intValue();

            // Print out our result.
            System.out.println("Sum: " + Integer.toString(sum) +
                               ", Difference: " +
                               Integer.toString(difference));

        } catch (XmlRpcException exception) {
            System.err.println("JavaClient: XML-RPC Fault #" +
                               Integer.toString(exception.code) + ": " +
                               exception.toString());
        } catch (Exception exception) {
            System.err.println("JavaClient: " + exception.toString());
        }
    }
}