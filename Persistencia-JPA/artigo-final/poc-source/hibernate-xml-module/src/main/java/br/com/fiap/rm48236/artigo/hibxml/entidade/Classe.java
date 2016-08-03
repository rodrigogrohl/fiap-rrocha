package br.com.fiap.rm48236.artigo.hibxml.entidade;

import java.io.Serializable;
import java.util.List;

/**
 * @author rodrigor
 * 
 */
public class Classe implements Serializable{

	private static final long serialVersionUID = 2961192598499567023L;

	private Integer id;

	private String sigla;

	private String coordenador;

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
