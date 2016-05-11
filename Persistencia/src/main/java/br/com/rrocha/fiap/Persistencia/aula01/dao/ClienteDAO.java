/**
 * 
 */
package br.com.rrocha.fiap.Persistencia.aula01.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rrocha.fiap.Persistencia.aula01.entity.Cliente;

/**
 * @author rm48236
 *
 */
public class ClienteDAO extends DAO {

	public void incluir(final Cliente cliente) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO cliente (nome, email) VALUES (?,?)";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			
		} catch(ClassNotFoundException | SQLException e ) {
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	public Cliente busca(int id) throws Exception {
		Cliente cliente = null;
		try {
			abrirConexao();
			stmt = con.prepareStatement("SELECT * FROM CLIENTE WHERE id = ?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				cliente = transform(rs);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			fecharConexao();
		}
		return cliente;
	}
	
	public List<Cliente> listar() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			abrirConexao();
			stmt = con.prepareStatement("SELECT * FROM CLIENTE");
			rs = stmt.executeQuery();
			while(rs.next()) {
				clientes.add( transform(rs) );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			fecharConexao();
		}
		return clientes;
	}
	
	private Cliente transform(ResultSet rs) throws SQLException {
		Cliente cliente = new Cliente();
		cliente.setId(rs.getInt("id"));
		cliente.setNome(rs.getString("nome"));
		cliente.setEmail(rs.getString("email"));
		return cliente;
	}
}
