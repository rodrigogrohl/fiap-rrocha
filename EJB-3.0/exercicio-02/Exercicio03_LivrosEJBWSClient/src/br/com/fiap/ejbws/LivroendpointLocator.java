/**
 * LivroendpointLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.ejbws;

public class LivroendpointLocator extends org.apache.axis.client.Service implements br.com.fiap.ejbws.Livroendpoint {

    public LivroendpointLocator() {
    }


    public LivroendpointLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LivroendpointLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LivroBeanPort
    private java.lang.String LivroBeanPort_address = "http://localhost:8080/Exercicio03_LivrosEJBWS/livroendpoint/LivroBean";

    public java.lang.String getLivroBeanPortAddress() {
        return LivroBeanPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LivroBeanPortWSDDServiceName = "LivroBeanPort";

    public java.lang.String getLivroBeanPortWSDDServiceName() {
        return LivroBeanPortWSDDServiceName;
    }

    public void setLivroBeanPortWSDDServiceName(java.lang.String name) {
        LivroBeanPortWSDDServiceName = name;
    }

    public br.com.fiap.ejbws.LivroBean getLivroBeanPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LivroBeanPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLivroBeanPort(endpoint);
    }

    public br.com.fiap.ejbws.LivroBean getLivroBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.ejbws.LivroendpointSoapBindingStub _stub = new br.com.fiap.ejbws.LivroendpointSoapBindingStub(portAddress, this);
            _stub.setPortName(getLivroBeanPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLivroBeanPortEndpointAddress(java.lang.String address) {
        LivroBeanPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.ejbws.LivroBean.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.ejbws.LivroendpointSoapBindingStub _stub = new br.com.fiap.ejbws.LivroendpointSoapBindingStub(new java.net.URL(LivroBeanPort_address), this);
                _stub.setPortName(getLivroBeanPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LivroBeanPort".equals(inputPortName)) {
            return getLivroBeanPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ejbws.fiap.com.br/", "livroendpoint");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ejbws.fiap.com.br/", "LivroBeanPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LivroBeanPort".equals(portName)) {
            setLivroBeanPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
