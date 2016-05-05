/**
 * 
 */
package br.com.rrocha.fiap.Persistencia.aula01.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author rm48236
 *
 */
public class Cliente implements Serializable {

	private static final long serialVersionUID = 5686526896040723845L;

	private int id;
	
	private String nome;
	
	private String email;
	
	private List<Pedido> pedidos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Cliente() { }

	@Override
	public String toString() {
		return "Id=" + id + ", nome=" + nome + ", email=" + email;
	}
	
}
