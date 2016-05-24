/**
 * 
 */
package br.com.fiap.rm48236.jpa.exercicio3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author rm48236
 *
 */
@Entity
@Table(name="procedimento")
public class Procedimento implements Serializable {

	private static final long serialVersionUID = -4946247310864502712L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "PRECO")
	private Double preco;
	
	@ManyToOne
	@JoinColumn(name = "CPFPAC")
	private Paciente paciente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Procedimento() {}

	public Procedimento(Integer id, String descricao, Double preco, Paciente paciente) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.paciente = paciente;
	}
	
	
	
}
