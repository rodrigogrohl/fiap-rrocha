/**
 * LivroBean.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.fiap.ejbws;

public interface LivroBean extends java.rmi.Remote {
    public void add(br.com.fiap.ejbws.Livros arg0) throws java.rmi.RemoteException;
    public br.com.fiap.ejbws.Livros[] getAll() throws java.rmi.RemoteException;
}
