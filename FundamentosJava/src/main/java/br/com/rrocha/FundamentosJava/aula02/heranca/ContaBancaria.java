/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula02.heranca;

import java.time.LocalDate;

import br.com.rrocha.FundamentosJava.aula02.interfaces.Taxes;

/**
 * @author rm48236
 *
 */
public class ContaBancaria implements Taxes {
	
	private String owner;
	private String address;
	private String identification; 
	private long totalAmount;
	private LocalDate openDate;
	

	public ContaBancaria(String owner, String address, String identification, long totalAmount, LocalDate openDate) {
		super();
		this.openDate = openDate;
		this.owner = owner;
		this.address = address;
		this.identification = identification;
		this.totalAmount = totalAmount;
		String log = String.format("\n----- Opening the Wallet for MR. %s with $%s -----", owner, Float.toString(totalAmount));
		System.out.println(log);
	}
	
	public boolean withdraw(final long amount) throws NoFundException {
		if(amount > totalAmount) {
			String message = String.format("Tentativa de retirada de %d: Saldo insuficiente ($ %d)", amount, totalAmount);
			throw new NoFundException(message);
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

	public long getTotalAmount() {
		return totalAmount;
	}

	public String getOwner() {
		return owner;
	}

	public String getAddress() {
		return address;
	}

	public String getIdentification() {
		return identification;
	}

	public double calculateTaxes() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public LocalDate getOpenDate() {
		return openDate;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().isInstance(this)){
			ContaBancaria c = (ContaBancaria) obj;
			if(c.getIdentification() == this.identification)
				return true;
		}
		return false;
	}
	
}
