/**
 * 
 */
package br.com.fiap.mb;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.fiap.interfaces.CalculadoraLocal;

/**
 * @author rm48236
 *
 */
@ManagedBean(name = "calcMB")
public class CalculadoraManagedBean {

	@EJB
	private CalculadoraLocal calculadora;

	private double x, y;
	private String resultado;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public void somar() {
		double result = calculadora.somar(x, y);
		setResultado("Soma = " + result);
	}

	public void subtrair() {
		double result = calculadora.subtrair(x, y);
		setResultado("Subtração = " + result);
	}

	public void multiplicar() {
		double result = calculadora.multiplicar(x, y);
		setResultado("Multiplicação = " + result);
	}

	public void dividir() {
		double result = calculadora.dividir(x, y);
		setResultado("Divisão = " + result);
	}
}
