package br.com.fiap.rm48236.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = 
			Persistence.createEntityManagerFactory("jpaPU");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
