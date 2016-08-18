/**
 * 
 */
package br.com.fiap.bean;

import javax.ejb.Local;
import javax.ejb.Stateful;

import br.com.fiap.interfaces.FolhaPagamento;

/**
 * @author rm48236
 *
 */
@Stateful
@Local(FolhaPagamento.class)
public class FolhaPagamentoBean implements FolhaPagamento {

	private double salario, taxa;
	
	@Override
	public void setSalario(double salario) {
		this.salario = salario;		
	}

	@Override
	public void setDesconto(double taxa) {
		this.taxa = taxa;
	}

	@Override
	public double calcularINSS() {
		return salario * taxa / 100;
	}

	@Override
	public double calcularSalarioLiquido() {
		return salario - calcularINSS();
	}

}
