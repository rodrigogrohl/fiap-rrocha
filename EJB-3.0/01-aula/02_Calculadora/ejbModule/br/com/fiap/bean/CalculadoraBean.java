package br.com.fiap.bean;

import javax.ejb.Stateless;

import br.com.fiap.interfaces.CalculadoraLocal;

/**
 * Session Bean implementation class CalculadoraBean
 */
@Stateless
public class CalculadoraBean implements CalculadoraLocal {

	@Override
	public double somar(double x, double y) {
		return x + y;
	}

	@Override
	public double subtrair(double x, double y) {
		return x - y;
	}

	@Override
	public double multiplicar(double x, double y) {
		return x * y;
	}

	@Override
	public double dividir(double x, double y) {
		return x / y;
	}

}
