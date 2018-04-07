package br.edu.ifpb.pos.jaxws;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jws.WebParam;
import javax.jws.WebService;

//@WebService(name="MyService", targetNamespace="ag.ifpb", portName="PrimeiroPort")
public interface MyService extends Remote {
	String hello(Message p, @WebParam(header=true, name="pass") String password) throws RemoteException;
	byte[] helloAsBytes(Message p) throws RemoteException;
}
