package br.com.fiap.rm48236.artigo.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.rm48236.artigo.jdbc.conexao.JDBCUtil;
import br.com.fiap.rm48236.artigo.jdbc.util.JDBCException;

public class Transacao {

	public static void main(String[] args) {
		
		try {
			
			Connection connection = new JDBCUtil().getConnection();
			connection.setAutoCommit(false);
			
			
		} catch (JDBCException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
