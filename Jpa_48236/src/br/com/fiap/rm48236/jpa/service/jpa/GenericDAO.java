package br.com.fiap.rm48236.jpa.service.jpa;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> implements DAO<T> {
	
	private final Class<T> classe;
	protected EntityManager em;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	@Override
	public void adicionar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<T> listar() {
		em = JPAUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName(), classe).getResultList();
	}

	@Override
	public void atualizar(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(entidade);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void remover(T entidade) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entidade));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public T buscar(int id) {
		em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		T entidade = em.find(classe, id);
		em.getTransaction().commit();
		em.close();
		return entidade;
	}
}
