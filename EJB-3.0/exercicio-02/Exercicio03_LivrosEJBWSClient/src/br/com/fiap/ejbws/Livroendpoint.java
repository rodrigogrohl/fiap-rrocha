/**
 * Livroendpoint.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.ejbws;

public interface Livroendpoint extends javax.xml.rpc.Service {
    public java.lang.String getLivroBeanPortAddress();

    public br.com.fiap.ejbws.LivroBean getLivroBeanPort() throws javax.xml.rpc.ServiceException;

    public br.com.fiap.ejbws.LivroBean getLivroBeanPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
