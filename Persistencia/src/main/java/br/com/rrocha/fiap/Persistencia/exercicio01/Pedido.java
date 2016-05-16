package br.com.rrocha.fiap.Persistencia.exercicio01;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PEDIDO")
public class Pedido implements Serializable {

	private static final long serialVersionUID = 6765230762980730775L;

	@Id
	@Column(name = "IDPEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(optional=false)
	@JoinColumn(name = "IDCLIENTE")
	private Cliente cliente;

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@Column
	private String descricao;

	@Column
	private Double valor;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Pedido(Integer id, Cliente cliente, Date data, String descricao, Double valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}
	public Pedido() { }

}
