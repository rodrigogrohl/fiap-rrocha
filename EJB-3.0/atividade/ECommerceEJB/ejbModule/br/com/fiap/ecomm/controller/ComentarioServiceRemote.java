package br.com.fiap.ecomm.controller;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.ecomm.entity.Comentario;

@Remote
public interface ComentarioServiceRemote {
	
	void adicionar(Comentario comentario);
	
	List<Comentario> listar();

}
