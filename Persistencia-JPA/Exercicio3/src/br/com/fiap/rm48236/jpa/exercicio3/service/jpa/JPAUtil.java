package br.com.fiap.rm48236.jpa.exercicio3.service.jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil implements Serializable {
	
	private static final long serialVersionUID = 677126129562908214L;
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("hospitalPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
