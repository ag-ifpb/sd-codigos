package ifpb.pos.restlet;

import java.io.IOException;

import junit.framework.TestCase;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class AppClientTest extends TestCase {
  
  public void test() throws IOException {
		//String ip = "10.3.1.236";
		//String ip = "10.3.1.199";
		//String ip = "10.3.1.173";
		//String ip = "10.3.1.064";
		String ip = "10.3.1.148";
		//
		ClientResource clientResource;
		Representation r;
		//
		clientResource = new ClientResource("http://" + ip + ":8082/app1/resource1");
		r = clientResource.get();
		System.out.println("Test1: " + ("OK1".equals(r.getText())));
		//
		clientResource = new ClientResource("http://" + ip + ":8082/app1/resource2");
		r = clientResource.get();
		System.out.println("Test2: " + ("OK2".equals(r.getText())));
		//
		clientResource = new ClientResource("http://" + ip + ":8082/app2/resource1");
		r = clientResource.get();
		System.out.println("Test3: " + ("OK3".equals(r.getText())));
		//
		clientResource = new ClientResource("http://" + ip + ":8082/app2/resource2");
		r = clientResource.get();
		System.out.println("Test4: " + ("OK4".equals(r.getText())));
	}
	
}
