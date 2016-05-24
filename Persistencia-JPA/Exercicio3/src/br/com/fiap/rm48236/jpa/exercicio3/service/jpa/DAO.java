package br.com.fiap.rm48236.jpa.exercicio3.service.jpa;

import java.util.List;

public interface DAO<T> {
	
	void adicionar(T entidade);
	List<T> listar();
	void atualizar(T entidade);
	void remover(T entidade);
	T buscar(int id);
	
}