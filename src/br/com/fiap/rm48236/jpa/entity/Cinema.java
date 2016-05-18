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
import javax.persistence.Table;

/**
 * @author rm48236
 *
 */
@Entity
@Table(name = "cinemas", schema = "jpa_48236")
public class Cinema implements Serializable {

	private static final long serialVersionUID = -2687684210957367208L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "CONTATO")
	private String contato;
	
	public Cinema() {}

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

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", descricao=" + descricao + ", contato=" + contato + "]";
	}
	
}
