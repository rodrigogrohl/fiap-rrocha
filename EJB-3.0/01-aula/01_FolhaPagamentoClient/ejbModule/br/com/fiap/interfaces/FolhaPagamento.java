/**
 * 
 */
package br.com.fiap.interfaces;

/**
 * @author rm48236
 *
 */
public interface FolhaPagamento {
	void setSalario(double salario);
	void setDesconto(double taxa);
	double calcularINSS();
	double calcularSalarioLiquido();
}
