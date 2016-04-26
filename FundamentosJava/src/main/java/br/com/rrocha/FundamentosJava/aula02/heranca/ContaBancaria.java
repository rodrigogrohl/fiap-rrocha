/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula02.heranca;

/**
 * @author rm48236
 *
 */
public class ContaBancaria {
	
	private float totalAmount;
	
	public ContaBancaria(final long initialValue) {
		this.totalAmount = initialValue;
		System.out.println("\n\nCreating a Bank Wallet: $" + initialValue);
	}
	
	public boolean withdraw(final long amount) {
		if(amount > totalAmount) {
			return false;
		} else {
			this.totalAmount -= amount;
			System.out.println("(-) Getting in your wallet: $" + amount + ".\nNow you have: $" + totalAmount);
		}
		return true;
	}
	
	public boolean deposit(final long amount) {
		if(amount <= 0) {
			System.out.println("Please deposit some value!");
			return false;
		}
		this.totalAmount += amount;
		System.out.println("(+) Adding to your wallet: $" + amount + ".\nNow you have: $" + totalAmount);
		return true;
	}

	public float getTotalAmount() {
		return totalAmount;
	}
	
}
