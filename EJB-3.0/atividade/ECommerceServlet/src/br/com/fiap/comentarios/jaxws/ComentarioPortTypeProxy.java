package br.com.fiap.comentarios.jaxws;

public class ComentarioPortTypeProxy implements br.com.fiap.comentarios.jaxws.ComentarioPortType {
  private String _endpoint = null;
  private br.com.fiap.comentarios.jaxws.ComentarioPortType comentarioPortType = null;
  
  public ComentarioPortTypeProxy() {
    _initComentarioPortTypeProxy();
  }
  
  public ComentarioPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initComentarioPortTypeProxy();
  }
  
  private void _initComentarioPortTypeProxy() {
    try {
      comentarioPortType = (new br.com.fiap.comentarios.jaxws.ComentarioServiceLocator()).getComentarioPort();
      if (comentarioPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)comentarioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)comentarioPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (comentarioPortType != null)
      ((javax.xml.rpc.Stub)comentarioPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.comentarios.jaxws.ComentarioPortType getComentarioPortType() {
    if (comentarioPortType == null)
      _initComentarioPortTypeProxy();
    return comentarioPortType;
  }
  
  public br.com.fiap.comentarios.jaxws.Comentario[] listar() throws java.rmi.RemoteException{
    if (comentarioPortType == null)
      _initComentarioPortTypeProxy();
    return comentarioPortType.listar();
  }
  
  
}