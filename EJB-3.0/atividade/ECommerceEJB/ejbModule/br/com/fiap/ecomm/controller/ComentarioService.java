package br.com.fiap.ecomm.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.fiap.ecomm.entity.Comentario;

/**
 * Session Bean implementation class ComentarioService
 */
@Stateless
@LocalBean
public class ComentarioService implements ComentarioServiceRemote {

	
	@PersistenceContext
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ComentarioService() {
        // TODO Auto-generated constructor stub
    }
    
    public void adicionar(Comentario comentario) {
    	comentario.setData(new Date());
    	em.persist(comentario);
    }
    
    public List<Comentario> listar() {
    	TypedQuery<Comentario> query = em.createQuery("FROM Comentario", Comentario.class);
    	return query.getResultList();
    }

}
