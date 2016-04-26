package br.com.rrocha.FundamentosJava.aula02.heranca;

public class ContaExecutor {

	public static void main(String[] args) {
		ContaBancaria contaBancaria = new ContaBancaria(2000);
		contaBancaria.deposit(500);
		contaBancaria.withdraw(250);
		
		ContaEspecial contaEspecial = new ContaEspecial(2000);
		contaEspecial.deposit(500);
		contaEspecial.withdraw(250);

	}

}
