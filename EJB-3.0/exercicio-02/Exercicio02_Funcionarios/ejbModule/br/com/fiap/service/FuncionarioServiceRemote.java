package br.com.fiap.service;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.entity.Funcionario;

@Remote
public interface FuncionarioServiceRemote {
	
	List<Funcionario> listAll();
	void add(Funcionario funcionario);

}
