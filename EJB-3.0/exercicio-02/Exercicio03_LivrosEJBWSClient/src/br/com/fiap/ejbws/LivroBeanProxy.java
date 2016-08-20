package br.com.fiap.ejbws;

public class LivroBeanProxy implements br.com.fiap.ejbws.LivroBean {
  private String _endpoint = null;
  private br.com.fiap.ejbws.LivroBean livroBean = null;
  
  public LivroBeanProxy() {
    _initLivroBeanProxy();
  }
  
  public LivroBeanProxy(String endpoint) {
    _endpoint = endpoint;
    _initLivroBeanProxy();
  }
  
  private void _initLivroBeanProxy() {
    try {
      livroBean = (new br.com.fiap.ejbws.LivroendpointLocator()).getLivroBeanPort();
      if (livroBean != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)livroBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)livroBean)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (livroBean != null)
      ((javax.xml.rpc.Stub)livroBean)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public br.com.fiap.ejbws.LivroBean getLivroBean() {
    if (livroBean == null)
      _initLivroBeanProxy();
    return livroBean;
  }
  
  public void add(br.com.fiap.ejbws.Livros arg0) throws java.rmi.RemoteException{
    if (livroBean == null)
      _initLivroBeanProxy();
    livroBean.add(arg0);
  }
  
  public br.com.fiap.ejbws.Livros[] getAll() throws java.rmi.RemoteException{
    if (livroBean == null)
      _initLivroBeanProxy();
    return livroBean.getAll();
  }
  
  
}