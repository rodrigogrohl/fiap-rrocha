/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula02.heranca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author rm48236
 *
 */
public class ContaEspecial extends ContaBancaria {
	
	public ContaEspecial(String owner, String address, String identification, long totalAmount, LocalDate openDate) {
		super(owner, address, identification, totalAmount, openDate);
	}

	@Override
	public boolean withdraw(long amount) throws NoFundException {
		//Period difference = Period.between(getOpenDate(), now);
		long months = ChronoUnit.MONTHS.between(getOpenDate(), LocalDate.now());
		if(months > 11) {
			System.out.printf("No taxes, your wallet is an old one: %d months.\n", months);
		} else {
			amount += (amount * 0.1);
		}
		return super.withdraw(amount);
	}
	
	@Override
	public boolean deposit(long amount) {
		amount -= (amount * 0.1);
		return super.deposit(amount);
	}

}
