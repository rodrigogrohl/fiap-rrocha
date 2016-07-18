package br.com.fiap.rm48236.artigo.jpa.entidade;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author rodrigor
 * 
 */
@Entity
@Table
public class Classe implements Serializable{

	private static final long serialVersionUID = 2961192598499567023L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String sigla;

	@Column(nullable = false)
	private String coordenador;

	@OneToMany(mappedBy = "classe")
	private List<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(String coordenador) {
		this.coordenador = coordenador;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Classe [id=" + id + ", sigla=" + sigla + ", coordenador="
				+ coordenador + "]";
	}

}
