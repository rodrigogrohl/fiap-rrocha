/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula02.enumerated;

import br.com.rrocha.FundamentosJava.aula02.heranca.ContaBancaria;

/**
 * @author rm48236
 *
 */
public enum Classifier {
	
	LOW,MEDIUM,POTENTIAL;
	
	public Classifier check(final ContaBancaria conta) {
		if(conta.getTotalAmount() < 2000000) {
			return Classifier.LOW;
		} else if(conta.getTotalAmount() < 400000) {
			return Classifier.MEDIUM;
		}
		return Classifier.POTENTIAL;
			
	}

}
