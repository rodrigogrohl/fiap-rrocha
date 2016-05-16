package br.com.rrocha.fiap.Persistencia.exercicio01;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.svenjacobs.loremipsum.LoremIpsum;

public class PersistData {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exercicio1PU");
		EntityManager em = emf.createEntityManager();
		
		LoremIpsum ipsum = new LoremIpsum();
		Cliente clienteA  = new Cliente(null,ipsum.getWords(2), ipsum.getWords(1) + "@teste.com");
		Cliente clienteB  = new Cliente(null,ipsum.getWords(4), ipsum.getWords(1) + "@teste.com");
		Cliente clienteC  = new Cliente(null,ipsum.getWords(3), ipsum.getWords(1) + "@teste.com");
		
		em.getTransaction().begin();
		em.persist(clienteA);
		em.persist(clienteB);
		em.persist(clienteC);
		em.getTransaction().commit();
		
		Pedido pedidoA = new Pedido(null, clienteA, new Date(), ipsum.getWords(5), 2999.6);
		Pedido pedidoB = new Pedido(null, clienteB, new Date(), ipsum.getWords(4), new Random().nextDouble());
		Pedido pedidoC = new Pedido(null, clienteA, new Date(), ipsum.getWords(6), 9.0);
		
		em.getTransaction().begin();
		em.persist(pedidoA);
		em.persist(pedidoB);
		em.persist(pedidoC);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
