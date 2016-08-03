package br.com.fiap.rm48236.artigo.hibxml.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> implements DAO<T> {
	
	private final Class<T> classe;
	
	protected EntityManager em;

	public GenericDAO(Class<T> classe, EntityManager em) {
		this.classe = classe;
		this.em = em;
	}

	public void adicionar(T entidade) {
		//em = JPAUtil.getEntityManager();
		//em.getTransaction().begin();
		//System.out.println("Adicionando: " + entidade);
		em.persist(entidade);
		//em.getTransaction().commit();
		//em.close();
	}

	public List<T> listar() {
		//em = JPAUtil.getEntityManager();
		return em.createQuery("From " + classe.getSimpleName(), classe).getResultList();
	}

	public void atualizar(T entidade) {
		//em = JPAUtil.getEntityManager();
		//em.getTransaction().begin();
		em.merge(entidade);
		//em.getTransaction().commit();
		//em.close();
	}

	public void remover(T entidade) {
		// em = JPAUtil.getEntityManager();
		// em.getTransaction().begin();
		em.remove(em.merge(entidade));
		// em.getTransaction().commit();
		// em.close();
	}

	public T buscar(int id) {
		// em = JPAUtil.getEntityManager();
		T entidade = em.find(classe, id);
		// em.close();
		return entidade;
	}
}
