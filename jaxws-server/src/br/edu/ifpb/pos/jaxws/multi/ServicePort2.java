package br.edu.ifpb.pos.jaxws.multi;

import java.rmi.RemoteException;

import javax.jws.WebService;

@WebService(name="Port2")
public interface ServicePort2 {
  void hello2() throws RemoteException;
}