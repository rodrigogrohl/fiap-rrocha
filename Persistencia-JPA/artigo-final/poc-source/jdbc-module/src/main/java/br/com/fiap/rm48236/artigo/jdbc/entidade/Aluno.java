package br.com.fiap.rm48236.artigo.jdbc.entidade;

public class Aluno {
	
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

	public Aluno(Integer matricula, String nome, String email, Classe classe) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.classe = classe;
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
	}

}
