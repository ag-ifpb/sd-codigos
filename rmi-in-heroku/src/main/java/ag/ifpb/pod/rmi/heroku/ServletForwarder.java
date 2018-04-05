package ag.ifpb.pod.rmi.heroku;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletForwarder {

  private void forwardRequest(HttpServletRequest request, Socket localServer) throws IOException, 
      ServletForwarderException {
    //
    DataInputStream clientIn = new DataInputStream(request.getInputStream());
    byte[] buffer = new byte[request.getContentLength()];
    //
    try {
      clientIn.readFully(buffer);
    } 
    catch (EOFException e) {
      throw new ServletForwarderException("unexpected EOF " + "reading request body");
    } 
    catch (IOException e) {
      throw new ServletForwarderException("error reading request" + " body");
    }
    //
    DataOutputStream socketOut = null;
    // send to local server in HTTP
    try {
      //
      System.out.println("----> request inicializado sucesso.");
      //
      socketOut = new DataOutputStream(localServer.getOutputStream());
      socketOut.writeBytes("POST / HTTP/1.0\r\n");
      socketOut.writeBytes("Content-length: " + request.getContentLength() + "\r\n\r\n");
      socketOut.write(buffer);
      socketOut.flush();
      //
      System.out.println("----> request finalizado com sucesso.");
    } 
    catch (IOException e) {
      throw new ServletForwarderException("error writing to server");
    }
  }

  private void forwardResponse(HttpServletResponse response, Socket localServer) throws IOException, 
      ServletForwarderException {
    //
    DataInputStream socketIn;
    try {
      socketIn = new DataInputStream(localServer.getInputStream());
    } 
    catch (IOException e) {
      throw new ServletForwarderException("error reading from " + "server");
    }
    //
    boolean contentLengthFound = false;
    String line;
    int responseContentLength = -1;
    String key = "Content-length:".toLowerCase();
    //
    do {
      //
      try {
        line = socketIn.readLine();
        System.out.println(line);
      } 
      catch (IOException e) {
        throw new ServletForwarderException("error reading from server");
      }
      //
      if (line == null) {
        throw new ServletForwarderException("unexpected EOF reading server response");
      }
      if (line.toLowerCase().startsWith(key)) {
        responseContentLength = Integer.parseInt(line.substring(key.length()).trim());
        contentLengthFound = true;
      }
      //
    } while ((line.length() != 0) && (line.charAt(0) != '\r') && (line.charAt(0) != '\n'));
    //
    if (!contentLengthFound || responseContentLength < 0)
      throw new ServletForwarderException("missing or invalid content length in server response");
    //
    byte[] buffer = new byte[responseContentLength];
    try {
      socketIn.readFully(buffer);
    } 
    catch (EOFException e) {
      throw new ServletForwarderException("unexpected EOF reading server response");
    } 
    catch (IOException e) {
      throw new ServletForwarderException("error reading from server");
    }
    //
    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("application/octet-stream");
    response.setContentLength(buffer.length);
    //
    try {
      System.out.println("----> response inicializado sucesso.");
      OutputStream out = response.getOutputStream();
      out.write(buffer);
      out.flush();
      System.out.println("----> response finalizado com sucesso.");
    } 
    catch (IOException e) {
      throw new ServletForwarderException("error writing response");
    }
  }

  public void forward(HttpServletRequest req, HttpServletResponse resp, int port)
      throws IOException, ServletForwarderException {
    //
    Socket localSocket = null;
    try {
      localSocket = new Socket(InetAddress.getLocalHost(), port);
      forwardRequest(req, localSocket);
      forwardResponse(resp, localSocket);
    } 
    finally {
      if (localSocket != null) {
        localSocket.close();
      }
    }
  }

}
