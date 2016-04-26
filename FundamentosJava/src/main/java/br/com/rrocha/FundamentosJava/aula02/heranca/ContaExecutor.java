package br.com.rrocha.FundamentosJava.aula02.heranca;

public class ContaExecutor {

	public static void main(String[] args) {
		ContaBancaria contaBancaria = new ContaBancaria("Rodrigo", "Ocean Avenue, 500", "556.584.987",2000.5f);
		contaBancaria.deposit(500);
		contaBancaria.withdraw(250);
		
		ContaEspecial contaEspecial = new ContaEspecial("Rodrigo", "Ocean Avenue, 500", "556.584.987",2000.5f);
		contaEspecial.deposit(500);
		contaEspecial.withdraw(250);

	}

}
