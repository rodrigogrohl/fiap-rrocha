package br.com.rrocha.fiap.Persistencia.exercicio02;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {
	
	private static final long serialVersionUID = 677126129562908214L;
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio1PU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
