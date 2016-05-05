package br.com.rrocha.fiap.Persistencia.aula01.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.rrocha.fiap.Persistencia.aula01.entity.Cliente;
import br.com.rrocha.fiap.Persistencia.aula01.entity.Pedido;

public class PedidoDAO extends DAO {
	
	public void incluir(Pedido pedido) throws Exception {
		try {
			abrirConexao();
			String sql = "INSERT INTO PEDIDOS (CLIENTE_ID, DATA, DESCRICAO, VALOR) values (?,?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, pedido.getCliente().getId());
			stmt.setDate(2, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			fecharConexao();
		}
	}
	
	public List<Pedido> listar(final Cliente cliente) throws Exception {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		try {
			abrirConexao();
			stmt = con.prepareStatement("SELECT * FROM PEDIDO WHERE CLIENTE_ID = ?");
			stmt.setInt(1, cliente.getId());
			rs = stmt.executeQuery();
			while(rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(rs.getInt("id"));
				pedido.setCliente(cliente);
				pedido.setData(rs.getDate("data"));
				pedido.setDescricao(rs.getString("descricao"));
				pedido.setValor(rs.getDouble("valor"));
				pedidos.add( pedido  );
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			fecharConexao();
		}
		return pedidos;
	}

}
