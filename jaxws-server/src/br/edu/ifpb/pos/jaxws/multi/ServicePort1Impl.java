package br.edu.ifpb.pos.jaxws.multi;

import java.rmi.RemoteException;

import javax.jws.WebService;

@WebService(serviceName="MyService", portName="port1", targetNamespace="http://multi.jaxws.pos.ifpb.edu.br")
public class ServicePort1Impl implements ServicePort1 {


  @Override
  public void hello1() throws RemoteException {
    System.out.println("Hello 1");
  }

}
