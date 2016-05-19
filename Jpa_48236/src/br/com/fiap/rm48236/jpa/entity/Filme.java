/**
 * 
 */
package br.com.fiap.rm48236.jpa.entity;

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
@Table(name = "filmes", schema = "jpa_48236")
public class Filme implements Serializable {
	
	private static final long serialVersionUID = -7531657037829832544L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne (optional = false)
	@JoinColumn(name = "IDLOCAL", nullable = false)
	private Local local;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "DURACAO")
	private Double duracao;
	
	@Column(name = "NUMEROSALA")
	private Integer numeroSala;

	public Filme() {}
	
	public Filme(Integer id, Local local, String nome, Double duracao, Integer numeroSala) {
		super();
		this.id = id;
		this.local = local;
		this.nome = nome;
		this.duracao = duracao;
		this.numeroSala = numeroSala;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public Integer getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(Integer numeroSala) {
		this.numeroSala = numeroSala;
	}

	@Override
	public String toString() {
		return String.format("%d - %s (Sala %d)", id, nome, numeroSala);
	}
	

}
