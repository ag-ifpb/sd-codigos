// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package ag.ifpb.rmi.server;

@SuppressWarnings({"serial", "deprecation" })
public final class HelloServerImpl_Stub extends java.rmi.server.RemoteStub implements ag.ifpb.rmi.shared.Hello, java.rmi.Remote {
	//serial
	private static final long interfaceHash = -1173440210250143739L;
	//operations (methods)
	private static final java.rmi.server.Operation[] operations = {
			new java.rmi.server.Operation("void hello(java.lang.String)") };

	// constructors
	public HelloServerImpl_Stub() {super();}
	public HelloServerImpl_Stub(java.rmi.server.RemoteRef ref) { super(ref);}

	// methods from remote interfaces
	// implementation of hello(String)
	public void hello(java.lang.String $param1) throws java.rmi.RemoteException {
		try {
			//create remote call
			java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0,
					interfaceHash);
			//write params
			try {
				java.io.ObjectOutput out = call.getOutputStream();
				out.writeObject($param1);
			} catch (java.io.IOException e) {
				throw new java.rmi.MarshalException("error marshalling arguments", e);
			}
			//invoke remote methods
			ref.invoke(call);
			//close connection
			ref.done(call);
		} catch (java.lang.RuntimeException e) {
			throw e;
		} catch (java.rmi.RemoteException e) {
			throw e;
		} catch (java.lang.Exception e) {
			throw new java.rmi.UnexpectedException("undeclared checked exception", e);
		}
	}
}
