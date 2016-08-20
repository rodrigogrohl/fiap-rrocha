package br.com.fiap.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 783872226987875032L;

	@Id
	private String cpf;
	
	@Column
	private String nome;
	
	@Column
	private String cargo;
	
	@Column
	private Double salario;
	
	@Column
	private Double irpf;
	
	@Column
	private Double inss;
	
	public Funcionario() { }
	
	public Funcionario(String cpf, String nome, String cargo, Double salario, Double inss) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
		this.inss = inss;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getInss() {
		return inss;
	}

	public void setInss(Double inss) {
		this.inss = inss;
	}

	public Double getIrpf() {
		return irpf;
	}

	
}
