package br.edu.ifpb.pos.jaxws.multi;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.EndpointContext;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.ws.spi.Provider;
import javax.xml.ws.spi.ServiceDelegate;
import javax.xml.ws.spi.http.HttpContext;

public class Main {

  public static void main(String[] args) throws MalformedURLException {
    //
    EndpointContext ctx = new EndpointContext() {
      @Override
      public Set<Endpoint> getEndpoints() {
        HashSet<Endpoint> hs = new HashSet<Endpoint>();
        hs.add(Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, new ServicePort1Impl()));
        hs.add(Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, new ServicePort2Impl()));
        return hs;
      }
    };
    //
    
    String wsdlDocumentLocation1= "http://cmis.alfresco.com/cmisws/RepositoryService?wsdl";
    //
    Service s = Service.create(new QName("http://docs.oasis-open.org/ns/cmis/ws/200908/", "DiscoveryService"));
    //
    Endpoint e = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, new Services());
    e.publish("http://localhost:8080/app");
    //
//    Endpoint p1 = Endpoint.create(SOAPBinding.SOAP11HTTP_BINDING, new ServicePort1Impl());
//    p1.publish("http://localhost:8080/app");
//    //
//    Endpoint p2 = Endpoint.create(SOAPBinding.SOAP11HTTP_MTOM_BINDING, new ServicePort2Impl());
//    p2.publish("http://localhost:8080/app");
  }
  
}
