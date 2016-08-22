/**
 * 
 */
package br.com.fiap.controller;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fiap.model.Curso;
import br.com.fiap.model.Escola;
import br.com.fiap.service.CursoService;

/**
 * @author Rodrigo
 *
 */

@SessionScoped
@Named(value = "cursoBean")
public class CursoController implements Serializable {
	
	private static final long serialVersionUID = -2340054197166179506L;

	@Inject
	private EscolaController escolaController;
	
	private Curso curso;
	
	private List<Curso> lista;
	
	@Inject
	private CursoService service;
	
	@Inject
	private Logger log;
	
	public String novo() {
		log.info("Adicionando cursos para " + escolaController.getEscola());
		Escola escola = escolaController.getEscola();
		lista = escola.getCursos();
		return "curso.jsf";
	}
	
	public String cadastar() {
		service.cadastrar(curso);
		lista = null;
		return "curso.jsp";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getLista() {
		return lista;
	}

}
