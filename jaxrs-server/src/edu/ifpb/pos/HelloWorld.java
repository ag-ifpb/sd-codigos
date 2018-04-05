package edu.ifpb.pos;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 * Test in:
 * 
 * In linux:
 * export WSURL=http://localhost:8080/ServerJAXRS/rest/hello.service
 * curl -H "Accept: application/json" -X POST $WSURL
 * curl -H "Accept: text/xml" -X POST $WSURL
 * curl -H "Accept: text/html" -X POST $WSURL
 * curl -H "Accept: text/plain" -X POST $WSURL
 * 
 * @author ari
 *
 */
@Path("/hello.service")
public class HelloWorld {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String sayJsonHello() {
		return "{\"message\" : \"Hello Jersey\"}";
	}

	@POST
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	@POST
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}

}