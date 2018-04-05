package br.edu.ifpb.pos.jaxws;

import javax.xml.ws.Endpoint;


public class Main {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:9191/app", new MyServiceImpl());
		
	}
	
}
