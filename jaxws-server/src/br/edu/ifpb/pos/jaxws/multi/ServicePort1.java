package br.edu.ifpb.pos.jaxws.multi;

import java.rmi.RemoteException;

import javax.jws.WebService;

@WebService(name="Port1")
public interface ServicePort1 {
  void hello1() throws RemoteException;
}
