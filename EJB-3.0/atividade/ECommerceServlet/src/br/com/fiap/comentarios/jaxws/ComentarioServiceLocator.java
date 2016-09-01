/**
 * ComentarioServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.comentarios.jaxws;

public class ComentarioServiceLocator extends org.apache.axis.client.Service implements br.com.fiap.comentarios.jaxws.ComentarioService {

    public ComentarioServiceLocator() {
    }


    public ComentarioServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ComentarioServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ComentarioPort
    private java.lang.String ComentarioPort_address = "http://localhost:8080/ECommerceEJB/ComentarioService/ComentarioWS";

    public java.lang.String getComentarioPortAddress() {
        return ComentarioPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ComentarioPortWSDDServiceName = "ComentarioPort";

    public java.lang.String getComentarioPortWSDDServiceName() {
        return ComentarioPortWSDDServiceName;
    }

    public void setComentarioPortWSDDServiceName(java.lang.String name) {
        ComentarioPortWSDDServiceName = name;
    }

    public br.com.fiap.comentarios.jaxws.ComentarioPortType getComentarioPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ComentarioPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getComentarioPort(endpoint);
    }

    public br.com.fiap.comentarios.jaxws.ComentarioPortType getComentarioPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.fiap.comentarios.jaxws.ComentarioServiceSoapBindingStub _stub = new br.com.fiap.comentarios.jaxws.ComentarioServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getComentarioPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setComentarioPortEndpointAddress(java.lang.String address) {
        ComentarioPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.fiap.comentarios.jaxws.ComentarioPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.fiap.comentarios.jaxws.ComentarioServiceSoapBindingStub _stub = new br.com.fiap.comentarios.jaxws.ComentarioServiceSoapBindingStub(new java.net.URL(ComentarioPort_address), this);
                _stub.setPortName(getComentarioPortWSDDServiceName());
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
        if ("ComentarioPort".equals(inputPortName)) {
            return getComentarioPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://jaxws.comentarios.fiap.com.br", "ComentarioService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://jaxws.comentarios.fiap.com.br", "ComentarioPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ComentarioPort".equals(portName)) {
            setComentarioPortEndpointAddress(address);
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
