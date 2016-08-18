package br.com.fiap.interfaces;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Funcionarios {

	public List<String> listar();
	public void adicionar(String nome);
	
}
