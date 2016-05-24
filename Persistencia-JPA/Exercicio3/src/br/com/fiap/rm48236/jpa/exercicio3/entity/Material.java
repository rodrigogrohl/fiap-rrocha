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
@Table(name = "matmed")
public class Material implements Serializable {

	private static final long serialVersionUID = -6180888308149154737L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "CPFPAC")
	private Paciente paciente;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PRECO")
	private Double preco;

	@Column(name = "FABRICANTE")
	private String fabricante;

	public Material() {}
	
	public Material(Integer id, Paciente paciente, String descricao, Double preco, String fabricante) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.descricao = descricao;
		this.preco = preco;
		this.fabricante = fabricante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
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

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

}
