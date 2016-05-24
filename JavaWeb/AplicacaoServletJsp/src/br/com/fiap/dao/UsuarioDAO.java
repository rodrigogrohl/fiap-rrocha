package br.com.fiap.dao;

import javax.persistence.TypedQuery;

import br.com.fiap.entity.Usuario;

public class UsuarioDAO extends GenericDao<Usuario>{

	public UsuarioDAO() {
		super(Usuario.class);
	}
	
	public Usuario login(final String username, final String password) {
		em = JpaUtil.getEntityManager();
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class);
		query.setParameter("nome", username);
		query.setParameter("senha", password);
		return query.getSingleResult();
	}

}
