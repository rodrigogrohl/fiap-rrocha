/**
 * 
 */
package br.com.fiap.rm48236.artigo.jdbc.entidade;

import java.util.List;

/**
 * @author rodrigor
 * 
 */
public class Classe {

	private Integer id;

	private String sigla;

	private String coordenador;

	private List<Aluno> alunos;

	public Classe() { }
	
	public Classe(Integer id, String sigla, String coordenador) {
		super();
		this.id = id;
		this.sigla = sigla;
		this.coordenador = coordenador;
	}

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
