/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula02.heranca;

/**
 * @author rm48236
 *
 */
public class ContaEspecial extends ContaBancaria {
	
	public ContaEspecial(long initialValue) {
		super(initialValue);
	}

	@Override
	public boolean withdraw(long amount) {
		amount += (amount * 0.1);
		return super.withdraw(amount);
	}
	
	@Override
	public boolean deposit(long amount) {
		amount -= (amount * 0.1);
		return super.deposit(amount);
	}

}
