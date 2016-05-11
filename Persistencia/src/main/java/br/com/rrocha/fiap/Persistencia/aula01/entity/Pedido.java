/**
 * 
 */
package br.com.rrocha.fiap.Persistencia.aula01.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author rm48236
 *
 */
public class Pedido implements Serializable {
	
	private static final long serialVersionUID = -3679483198727260179L;

	private int id;
	
	private Cliente cliente;
	
	private Date data;
	
	private String descricao;
	
	private Double valor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public Pedido() {}
	
}
