import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;

import br.edu.ifpb.pos.jaxws.Message;
import br.edu.ifpb.pos.jaxws.MyService;

public class Main {

	public static void main(String[] args) throws MalformedURLException, RemoteException {
		//
		long t0 = System.currentTimeMillis();
		// System.setProperty("com.sun.xml.ws.transport.http.client.HttpTransportPipe.dump",
		// "true");
		// System.setProperty("javax.net.debug", "all");

		// url de entrada (endpoint) + ?wsdl
		// 10.1.1.106
		// URL wsdlDocumentLocation = new URL("http://localhost:9191/app?wsdl");
		URL wsdlDocumentLocation = new URL("http://localhost:9191/app");
		//
		QName serviceName = new QName("http://jaxws.pos.ifpb.edu.br/", "HelloService");
		Service service = Service.create(wsdlDocumentLocation, serviceName);
		//
		QName portName = new QName("http://jaxws.pos.ifpb.edu.br/", "HelloPort");
		MyService myservice = service.getPort(portName, MyService.class);
		//
		Message message = new Message();
		message.setName("Ari Garcia");
		System.out.println("criou o serviço e a mensagem: " + (System.currentTimeMillis() - t0));
		String response = myservice.hello(message, "234567");
		System.out.println("requisitou hello: " + (System.currentTimeMillis() - t0));
		byte[] responseAsBytes = myservice.helloAsBytes(message);
		System.out.println("requisitou helloAsBytes: " + (System.currentTimeMillis() - t0));
		//
		System.out.println(response);
		System.out.println(new String(responseAsBytes));
	}

}
