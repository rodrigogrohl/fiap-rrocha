package br.com.fiap.rm48236.artigo.hibxml;

import java.util.Date;
import java.util.List;

import javax.persistence.LockModeType;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.fiap.rm48236.artigo.hibxml.conexao.HibernateUtil;
import br.com.fiap.rm48236.artigo.hibxml.dao.GenericDAO;
import br.com.fiap.rm48236.artigo.hibxml.entidade.Aluno;
import br.com.fiap.rm48236.artigo.hibxml.entidade.Classe;
import br.com.fiap.rm48236.artigo.hibxml.entidade.FakeObjects;

public class HibXMLPoc {
	
	private Session session;
	GenericDAO<Classe> daoClasse;
	GenericDAO<Aluno> daoAluno;
	
	public HibXMLPoc() {
		session = HibernateUtil.getSession();
		daoClasse = new GenericDAO<Classe>(Classe.class, session);
		daoAluno = new GenericDAO<Aluno>(Aluno.class, session);
	}
	
	public static void main(String[] args) {
		// Transacao com 10 Classes com 50 alunos cada
		//new HibXMLPoc().transactionTest(10, 50);
		
		// Operacao com Cache
		//new HibXMLPoc().cacheTest();
		
		// Concorrencia
		new HibXMLPoc().concurrencyTest();

	}
	
	private void concurrencyTest() {
		Transaction tx = session.getTransaction();
		tx.begin();
		
		Classe classe = session.find(Classe.class, 1);
		System.out.println("Lock test for: " + classe);
		classe.setSigla( classe.getSigla() + " Lock");

		// Lock apos leitura
		session.lock(classe, LockModeType.PESSIMISTIC_READ);
		secondConcurrency();
		
		session.persist(classe);
		tx.commit();
		session.close();
	}
	
	private void secondConcurrency(){
		Session em2 = HibernateUtil.getSession();
		
		em2.getTransaction().begin();
		Classe classe = em2.find(Classe.class, 1);
		classe.setSigla( classe.getSigla() + " No Lock");
		//em2.lock(classe, LockModeType.LockModeType.PESSIMISTIC_READ);
		
		em2.persist(classe);
		em2.getTransaction().commit();
		em2.close();
	}

	protected void transactionTest() {
		long startTransaction = new Date().getTime();
		transactionTest(10, 100);		
		long endTransaction = new Date().getTime();
		
		long totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total de Execucao: " + totalTransaction + "ms.");
	}
	
	protected void cacheTest() {
		long startTransaction = 0;
		long endTransaction = 0;
		long totalTransaction = 0;
		
		startTransaction = new Date().getTime();
		listar();
		endTransaction = new Date().getTime();
		
		totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total PRIMEIRA Execucao: " + totalTransaction + "ms.");
		
		startTransaction = new Date().getTime();
		listar();
		endTransaction = new Date().getTime();
		
		totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total SEGUNDA Execucao: " + totalTransaction + "ms.");
		
		
	}
	
	protected void transacaoSimples() {
				
		session.getTransaction().begin();
		Classe classe = new Classe();
		classe.setSigla("SCJ01");
		classe.setCoordenador("Carlos");
		daoClasse.adicionar(classe);
		session.getTransaction().commit();
		session.close();
	}
	
	protected void listar() {
		int count = 0;
		List<Classe> list = daoClasse.listar();
		for (Classe c : list) {
			//System.out.println(c);
			count++;
			List<Aluno> alunos = c.getAlunos();
			if(alunos != null)
				count += alunos.size();
			/*
			for (Aluno aluno : alunos) {
				System.out.println(aluno);
				count++;
			}
			*/
		}
		System.out.println("Total Read entities: " + count);
	}
	
	protected void transactionTest(int quantidadeClasses, int quantidadeAlunos) {
		System.out.println(String.format("Hibernate Transaction: Adicionando %d classes, contendo %d alunos cada.", quantidadeClasses, quantidadeAlunos));
		List<Classe> classes = FakeObjects.getFullClasses(quantidadeClasses, quantidadeAlunos);
		
		// Inicia Transacao
		Transaction tx = session.getTransaction();
		tx.begin();
		
		for (Classe classe : classes) {
			// Adiciona 10 salas com 100 alunos cada
			daoClasse.adicionar(classe);
			List<Aluno> alunos = classe.getAlunos();
			for (Aluno aluno : alunos) {
				daoAluno.adicionar(aluno);
			}
		}
		
		tx.commit();
		session.close();
	}

}
