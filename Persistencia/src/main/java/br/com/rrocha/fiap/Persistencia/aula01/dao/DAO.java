package br.com.rrocha.fiap.Persistencia.aula01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO {
	
	protected Connection con;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	
	private String url = "jdbc:mysql://localhost:3306/vendas";
	
	protected void abrirConexao() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,"root","fiap");
	}
	
	protected void fecharConexao() throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}

}
