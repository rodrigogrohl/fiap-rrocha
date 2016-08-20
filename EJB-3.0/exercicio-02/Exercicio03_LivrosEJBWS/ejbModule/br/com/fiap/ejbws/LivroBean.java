package br.com.fiap.ejbws;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Livros;

/**
 * Session Bean implementation class LivroBean
 */
@Stateless
@LocalBean
@WebService(serviceName = "livroendpoint")
public class LivroBean implements LivroBeanRemote {

	//java:global/Exercicio03_LivrosEJBWS/LivroBean!br.com.fiap.ejbws.LivroBean
	
	@PersistenceContext(unitName = "fiapPU")
	private EntityManager em;

	@Override
	@WebMethod
	public void add(Livros livro) {
		em.persist(livro);
	}

	@Override
	@WebMethod
	public List<Livros> getAll() {
		TypedQuery<Livros> query = em.createQuery("select u from Livros u", Livros.class);
		return query.getResultList();
	}

}
