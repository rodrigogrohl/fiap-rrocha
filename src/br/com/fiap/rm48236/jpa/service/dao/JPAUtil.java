package br.com.fiap.rm48236.jpa.service.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {
	
	private static final long serialVersionUID = 677126129562908214L;
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("jpa_48236");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
