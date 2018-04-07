package ifpb.pos.restlet;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class App {

	public static void main(String[] args) throws Exception {
		//
		int port = System.getenv("PORT") != null ? Integer.valueOf(System.getenv("PORT")) : 8080;
		// criando o componente
		Component component = new Component();
		component.getServers().add(Protocol.HTTP, port);
		component.getClients().add(Protocol.FILE);
		//
		Logger logger = component.getLogger();
		logger.setLevel(Level.ALL);

		// roteando a aplicação 1
		Application app1 = new Application();
		component.getDefaultHost().attach("/app1", app1);
		// roteando a aplicação 2
		Application app2 = new Application();
		component.getDefaultHost().attach("/app2", app2);
		//
		// roteando os recursos
		Router router1 = new Router();
		router1.attach("/contact/{code}", ContactResource.class);

		// adicionando um roteador para a app1
		router1.attach("/hello", HelloResource.class);
		app1.setInboundRoot(router1);
		//
		component.start();
	}

}
