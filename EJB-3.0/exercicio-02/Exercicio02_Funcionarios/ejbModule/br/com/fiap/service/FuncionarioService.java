package br.com.fiap.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.entity.Funcionario;

/**
 * Session Bean implementation class FuncionarioService
 */
@Stateless
@LocalBean
public class FuncionarioService implements FuncionarioServiceRemote {

	@PersistenceContext(name = "fiapPU")
	EntityManager em;
	
    public FuncionarioService() { }
    
    @Override
	public List<Funcionario> listAll() {
    	return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class).getResultList();
	}

	@Override
	public void add(Funcionario funcionario) {
		em.persist(funcionario);
	}

}
