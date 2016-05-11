package br.com.rrocha.FundamentosJava.atividade.a02;

public class Exercicio1 implements CalculadoraBase {

	@Override
	public float somar(float op1, float op2) {
		return op1 + op2;
	}

	@Override
	public float subtrair(float op1, float op2) {
		return op1 - op2;
	}

	@Override
	public float dividir(float op1, float op2) {
		return op1/op2;
	}

	@Override
	public float multiplicar(float op1, float op2) {
		return op1 * op2;
	}

}
