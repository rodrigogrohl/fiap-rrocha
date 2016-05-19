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
@Table(name = "locais" , schema = "jpa_48236")
public class Local implements Serializable {
	
	private static final long serialVersionUID = 752104122520969702L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="IDCINEMA")
	private Cinema cinema;
	
	@Column(name="LOCAL")
	private String local;
	
	@Column(name = "NUMSALAS")
	private Integer qtdeSalas;
	
	public Local() { }
	
	public Local(Integer id, Cinema cinema, String local, Integer qtdeSalas) {
		super();
		this.id = id;
		this.cinema = cinema;
		this.local = local;
		this.qtdeSalas = qtdeSalas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getQtdeSalas() {
		return qtdeSalas;
	}

	public void setQtdeSalas(Integer qtdeSalas) {
		this.qtdeSalas = qtdeSalas;
	}

	@Override
	public String toString() {
		return cinema.getDescricao() + " - " + local;
	}
	
	

}
