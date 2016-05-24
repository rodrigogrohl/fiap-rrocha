package br.com.fiap.rm48236.jpa.exercicio3.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> implements DAO<T> {
	
	private final Class<T> classe;
	protected EntityManager em;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
		em = JPAUtil.getEntityManager();

	}

	@Override
	public void adicionar(T entidade) {
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<T> listar() {
		return em.createQuery("From " + classe.getSimpleName(), classe).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(T entidade) {
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T buscar(int id) {
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}

	public EntityManager getEm() {
		return em;
	}
	
}
