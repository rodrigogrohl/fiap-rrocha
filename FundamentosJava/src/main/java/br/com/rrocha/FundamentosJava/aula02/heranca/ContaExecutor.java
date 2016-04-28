package br.com.rrocha.FundamentosJava.aula02.heranca;

public class ContaExecutor {

	public static void main(String[] args) throws NoFundException {
		ContaBancaria contaBancaria = new ContaBancaria("Rodrigo", "Ocean Avenue, 500", "556.584.987", 2000);
		contaBancaria.deposit(500);
		contaBancaria.withdraw(250);
		
		ContaEspecial contaEspecial = new ContaEspecial("Rodrigo", "Ocean Avenue, 500", "556.584.987", 2000);
		contaEspecial.deposit(500);
		contaEspecial.withdraw(9856);

	}

}
