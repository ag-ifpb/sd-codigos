package ifpb.pos.restlet;

import java.io.IOException;

import junit.framework.TestCase;

import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class AppClientLocal extends TestCase {
	
  public void test() throws IOException {
		ClientResource resource = new ClientResource("http://localhost:10001/app/hello");
		Representation representation = resource.get();
		System.out.println(representation.getText());
	}

}
