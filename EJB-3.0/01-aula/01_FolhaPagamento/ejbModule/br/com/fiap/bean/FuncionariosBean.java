package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.fiap.interfaces.Funcionarios;

/**
 * Session Bean implementation class FuncionariosBean
 */
@Stateful
public class FuncionariosBean implements Funcionarios {

	private List<String> lista;
	
    public FuncionariosBean() {
    	lista = new ArrayList<String>();
    }

	@Override
	public List<String> listar() {
		System.out.println("Total Returned: " + lista.size());
		return lista;
	}

	@Override
	public void adicionar(String nome) {
		lista.add(nome);
	}

}
