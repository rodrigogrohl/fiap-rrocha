package br.com.rrocha.FundamentosJava.aula04.lambda;

import java.time.LocalDateTime;
import java.util.Calendar;

public class Cliente {
	
	private String nome;
	
	private int idade;
	
	private boolean ativo;
	
	private LocalDateTime dataPrimeiraCompra;

	
	public Cliente(String nome, int idade, boolean ativo,
			LocalDateTime localDateTime) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.ativo = ativo;
		this.dataPrimeiraCompra = localDateTime;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDateTime getDataPrimeiraCompra() {
		return dataPrimeiraCompra;
	}

	public void setDataPrimeiraCompra(LocalDateTime dataPrimeiraCompra) {
		this.dataPrimeiraCompra = dataPrimeiraCompra;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + ", ativo="
				+ ativo + ", dataPrimeiraCompra=" + dataPrimeiraCompra + "]";
	}
	

}
