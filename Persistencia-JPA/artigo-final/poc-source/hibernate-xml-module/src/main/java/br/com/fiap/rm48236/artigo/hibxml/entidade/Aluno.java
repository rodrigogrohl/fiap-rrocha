package br.com.fiap.rm48236.artigo.hibxml.entidade;

import java.io.Serializable;

public class Aluno implements Serializable {
	
	private static final long serialVersionUID = 5112772788360107911L;

	private Integer matricula;
	
	private String nome;
	
	private String email;
	
	private Classe classe;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + ", email="
				+ email + ", classe=" + classe + "]";
	}

}
