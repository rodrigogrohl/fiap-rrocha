/**
 * 
 */
package br.com.fiap.rm48236.persistencia.Exercicio3.helper;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.rm48236.persistencia.Exercicio3.entity.Funcionario;

/**
 * @author rm48236
 *
 */
public class Helper {
	private EntityManager em;

	public Helper(EntityManager em) {
		this.em = em;
	}

	public void salvar(Funcionario funcionario) throws Exception {
		try {
			em.getTransaction().begin();
			em.persist(funcionario);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}
	}

	public List<Funcionario> listarFuncionarios() {
		TypedQuery<Funcionario> query = 
				em.createQuery("select f from Funcionario f", Funcionario.class);
		return query.getResultList();
	}

	public Funcionario buscarFuncionario(String numMatricula) {
		TypedQuery<Funcionario> query = 
				em.createQuery("select f from Funcionario f where matricula = :matricula", 
						Funcionario.class);
		query.setParameter("matricula", numMatricula);
		Funcionario f = (Funcionario) query.getSingleResult();
		return f;
	}

	public List<Funcionario> listarTodos() {
		TypedQuery<Funcionario> query = 
				em.createNamedQuery("Funcionario.findAll", Funcionario.class);
		return query.getResultList();
	}
}
