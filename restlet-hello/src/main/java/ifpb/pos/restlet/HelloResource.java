package ifpb.pos.restlet;
import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;


public class HelloResource extends ServerResource{
	
  @Get("html")
  public Representation helloAsHtml(){
		return new StringRepresentation(
				"<h1>Hello</h1>", MediaType.TEXT_HTML
		);
	}
  
  @Get("json")
  public Representation helloAsJson(){
    return new StringRepresentation(
        "{\"hello\":\"hello\"}", MediaType.APPLICATION_JSON
    );
  }
  
  @Get("txt")
  public Representation hello(){
    return new StringRepresentation(
        "Hello World", MediaType.TEXT_PLAIN
    );
  }

}
