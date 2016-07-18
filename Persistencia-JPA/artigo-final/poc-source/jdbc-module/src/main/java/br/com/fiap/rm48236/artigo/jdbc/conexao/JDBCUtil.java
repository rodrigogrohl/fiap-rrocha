package br.com.fiap.rm48236.artigo.jdbc.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.fiap.rm48236.artigo.jdbc.util.JDBCException;

public class JDBCUtil {
	
	private static final String URI = "C:\\Users\\rodrigor\\git\\fiap-rrocha\\Persistencia-JPA\\artigo-final\\poc-source\\database\\db";
	
	public JDBCUtil() throws JDBCException {

		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new JDBCException(e);
		}
		
	}
	
	public Connection getConnection() throws JDBCException {
		try {
			return DriverManager.getConnection("jdbc:h2:" + URI + ";USER=sa;PASSWORD=sa");
		} catch (SQLException e) {
			throw new JDBCException(e.getLocalizedMessage(), e);
		}
	}

}
