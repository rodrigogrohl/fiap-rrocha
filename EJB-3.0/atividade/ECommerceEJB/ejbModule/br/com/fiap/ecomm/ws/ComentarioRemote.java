package br.com.fiap.ecomm.ws;

import java.util.List;

import javax.ejb.Remote;
import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.ecomm.entity.Comentario;

@Remote
@WebService(name = "ComentarioPortType", 
			targetNamespace = "http://jaxws.comentarios.fiap.com.br")
public interface ComentarioRemote {
	
	@WebMethod(operationName="listar")
	List<Comentario> listar();

}
