package br.com.fiap.client;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import br.com.fiap.ejbws.LivroBean;
import br.com.fiap.ejbws.LivroendpointLocator;
import br.com.fiap.ejbws.Livros;

public class LivrosServiceConsumer {
	
	public static void main(String[] args) throws ServiceException, RemoteException {
		
		LivroendpointLocator locator = new LivroendpointLocator();
		LivroBean livroBeanPort = locator.getLivroBeanPort();
		
		Livros livros = new Livros("Rodrigo", null, Double.valueOf(50.5), "FIAP in Action");
		livroBeanPort.add(livros);
		
	}

}
