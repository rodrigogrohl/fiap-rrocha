package br.com.fiap.rm48236.jpa.exercicio3.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PACIENTE")
public class Paciente implements Serializable {

	private static final long serialVersionUID = -1757698609453675572L;

	@Id
	@Column(name="CPF", length=11, updatable=false, unique = true)
	private String CPF;  
	
	@OneToMany(mappedBy="paciente")
	private List<Procedimento> procedimentos;
	
	@OneToMany(mappedBy="paciente")
	private List<Material> materiais;
	
	@ManyToMany
	private List<Agenda> agendas;
	
	@Column(name="NOME")
	private String nome;
	
	@Column(name="DATANASC")
	@Temporal(TemporalType.TIMESTAMP)
	private Date nasc;
	
	@Column(name="TELEFONE", length = 20)
	private String telefone;
	
	public Paciente() {}

	public Paciente(String cPF, List<Procedimento> procedimentos, List<Material> materiais, String nome, Date nasc,
			String telefone) {
		super();
		CPF = cPF;
		this.procedimentos = procedimentos;
		this.materiais = materiais;
		this.nome = nome;
		this.nasc = nasc;
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNasc() {
		return nasc;
	}

	public void setNasc(Date nasc) {
		this.nasc = nasc;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public List<Material> getMateriais() {
		return materiais;
	}

	public void setMateriais(List<Material> materiais) {
		this.materiais = materiais;
	}
	

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	@Override
	public String toString() {
		return "CPF=" + CPF + ", nome=" + nome + ", nasc=" + nasc + ", telefone=" + telefone;
	}
	
}
