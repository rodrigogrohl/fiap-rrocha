package br.com.fiap.rm48236.artigo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import br.com.fiap.rm48236.artigo.jdbc.conexao.JDBCUtil;
import br.com.fiap.rm48236.artigo.jdbc.conexao.JdbcDAO;
import br.com.fiap.rm48236.artigo.jdbc.entidade.Aluno;
import br.com.fiap.rm48236.artigo.jdbc.entidade.Classe;
import br.com.fiap.rm48236.artigo.jdbc.entidade.FakeObjects;
import br.com.fiap.rm48236.artigo.jdbc.util.JDBCException;

public class JDBCPoc {

	public static void main(String[] args) throws JDBCException, SQLException {
		
		//new JDBCPoc().transactionTest();
		//new JDBCPoc().cacheTest();
		new JDBCPoc().concurrencyTest(); 

	}
	
	protected void transactionTest() throws JDBCException, SQLException {
		long startTransaction = new Date().getTime();
		transactionTest(10, 100);		
		long endTransaction = new Date().getTime();
		
		long totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total de Execucao: " + totalTransaction + "ms.");
	}

	protected void transactionTest(int quantidadeClasses, int quantidadeAlunos) 
			throws JDBCException, SQLException {
		
		System.out.println(String.format("JDBC Transaction: Adicionando %d classes, com %d alunos cada.", 
				quantidadeClasses, quantidadeAlunos));
		
		List<Classe> classes = FakeObjects.getFullClasses(quantidadeClasses, quantidadeAlunos);
				
		// Inicia Transacao
		Connection connection = new JDBCUtil().getConnection();
		connection.setAutoCommit(false);

		JdbcDAO dao = new JdbcDAO(connection);
		
		for (Classe classe : classes) {
			// Adiciona 10 salas com 100 alunos cada
			dao.adicionarClasse(classe);
			List<Aluno> alunos = classe.getAlunos();
			for (Aluno aluno : alunos) {
				dao.adicionarAluno(classe, aluno);
			}
		}
		
		connection.commit();
		connection.close();
	}
	
	protected void cacheTest() throws JDBCException, SQLException {
		long startTransaction = 0;
		long endTransaction = 0;
		long totalTransaction = 0;
		
		startTransaction = new Date().getTime();
		listar();
		endTransaction = new Date().getTime();
		
		totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total PRIMEIRA Execucao JDBC: " + totalTransaction + "ms.");
		
		startTransaction = new Date().getTime();
		listar();
		endTransaction = new Date().getTime();
		
		totalTransaction = endTransaction - startTransaction;
		System.out.println("Tempo Total SEGUNDA Execucao JDBC: " + totalTransaction + "ms.");
		
		
	}
	
	protected void listar() throws JDBCException, SQLException {
		Connection connection = new JDBCUtil().getConnection();
		JdbcDAO dao = new JdbcDAO(connection);
		
		int count = 0;
		List<Classe> list = dao.listar();
		for (Classe c : list) {
			//System.out.println(c);
			count++;
			List<Aluno> alunos = c.getAlunos();
			count += alunos.size();
		}
		System.out.println("Total Read entities: " + count);
	}
	
	private void concurrencyTest() throws SQLException, JDBCException {
		// Inicia Transacao
		Connection connection = new JDBCUtil().getConnection();
		connection.setAutoCommit(false);
		connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
		
		JdbcDAO dao = new JdbcDAO(connection);
		Classe classe = dao.getClasse(1);
		classe.setSigla( classe.getSigla() +"_UP");
		dao.update(classe);
		
		secondConcurrency();
		
		connection.commit();
		connection.close();
	}
	
	private void secondConcurrency() throws JDBCException, SQLException{
		Connection connection = new JDBCUtil().getConnection();
		connection.setAutoCommit(false);
		JdbcDAO dao = new JdbcDAO(connection);
		Classe classe = dao.getClasse(1);
		classe.setSigla( classe.getSigla() +"_UP");
		dao.update(classe);
		
		connection.commit();
		connection.close();
		
	}
}
