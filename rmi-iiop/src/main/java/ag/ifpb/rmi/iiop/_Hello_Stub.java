// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

package ag.ifpb.rmi.iiop;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import javax.rmi.CORBA.Stub;
import javax.rmi.CORBA.Util;
import org.omg.CORBA.ORB;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.ApplicationException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.RemarshalException;
import org.omg.CORBA.portable.ResponseHandler;
import org.omg.CORBA.portable.ServantObject;


public class _Hello_Stub extends Stub implements Hello {
    
    private static final String[] _type_ids = {
        "RMI:ag.ifpb.rmi.iiop.Hello:0000000000000000"
    };
    
        public String[] _ids() { 
            return (String[]) _type_ids.clone();
        }
        
        public void hello(String arg0) throws java.rmi.RemoteException {
            if (!Util.isLocal(this)) {
                try {
                    org.omg.CORBA_2_3.portable.InputStream in = null;
                    try {
                        org.omg.CORBA_2_3.portable.OutputStream out = 
                            (org.omg.CORBA_2_3.portable.OutputStream)
                            _request("hello", true);
                        out.write_value(arg0,String.class);
                        _invoke(out);
                    } catch (ApplicationException ex) {
                        in = (org.omg.CORBA_2_3.portable.InputStream) ex.getInputStream();
                        String $_id = in.read_string();
                        throw new UnexpectedException($_id);
                    } catch (RemarshalException ex) {
                        hello(arg0);
                    } finally {
                        _releaseReply(in);
                    }
                } catch (SystemException ex) {
                    throw Util.mapSystemException(ex);
                }
            } else {
                ServantObject so = _servant_preinvoke("hello",Hello.class);
                if (so == null) {
                    hello(arg0);
                    return ;
                }
                try {
                    ((Hello)so.servant).hello(arg0);
                } catch (Throwable ex) {
                    Throwable exCopy = (Throwable)Util.copyObject(ex,_orb());
                    throw Util.wrapException(exCopy);
                } finally {
                    _servant_postinvoke(so);
                }
            }
        }
    }
