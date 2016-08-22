package br.com.fiap.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.fiap.data.DisciplinaRepository;
import br.com.fiap.model.Disciplina;

@Stateless
public class DisciplinaService {
	
	@Inject
	private DisciplinaRepository repository;
	
	public void cadastrar(final Disciplina disciplina){
		repository.adicionar(disciplina);
	}
	
	public void atualizar(final Disciplina disciplina){
		repository.atualizar(disciplina);
	}
	
	public List<Disciplina> listar() {
		return repository.listar();
	}
	
	public Disciplina buscar(final Integer id) {
		return repository.buscar(id);
	}
	

}
