package ag.ifpb.rmi.iiop.idl.service;

/**
* ag/ifpb/rmi/iiop/idl/service/HelloHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Hello.idl
* Wednesday, March 28, 2018 2:34:08 AM BRT
*/

public final class HelloHolder implements org.omg.CORBA.portable.Streamable
{
  public ag.ifpb.rmi.iiop.idl.service.Hello value = null;

  public HelloHolder ()
  {
  }

  public HelloHolder (ag.ifpb.rmi.iiop.idl.service.Hello initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ag.ifpb.rmi.iiop.idl.service.HelloHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ag.ifpb.rmi.iiop.idl.service.HelloHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ag.ifpb.rmi.iiop.idl.service.HelloHelper.type ();
  }

}