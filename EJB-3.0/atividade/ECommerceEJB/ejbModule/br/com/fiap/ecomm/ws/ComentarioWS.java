package br.com.fiap.ecomm.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import br.com.fiap.ecomm.controller.ComentarioService;
import br.com.fiap.ecomm.entity.Comentario;

@Stateless

@WebService(serviceName = "ComentarioService", 
	portName = "ComentarioPort", 
	endpointInterface = "br.com.fiap.ecomm.ws.ComentarioRemote", 
	targetNamespace = "http://jaxws.comentarios.fiap.com.br")
//@WebService(serviceName="ComentarioService")
public class ComentarioWS implements ComentarioRemote {

	@EJB
	private ComentarioService service;
	
	public List<Comentario> listar(){
		return service.listar();
	}
	
}
