package br.com.fiap.ecomm.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.ecomm.controller.ComentarioService;
import br.com.fiap.ecomm.entity.Comentario;

@RequestScoped
@Named(value = "comentarioBean")
public class ComentarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ComentarioService service;

	private Comentario comentario;

	private List<Comentario> lista;

	@PostConstruct
	public void create() {
		comentario = new Comentario();
	}
	
	public String adicionar() {
		System.out.println("Adding: " + comentario);
		service.adicionar(comentario);
		comentario = new Comentario();
		lista = null;
		return "index.jsf";
	}

	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}

	public List<Comentario> getLista() {
		if(lista == null)
			lista = service.listar();
		return lista;
	}
}
