package br.com.rrocha.FundamentosJava.atividade.a01;

import javax.swing.JOptionPane;

public class ExercicioIV {
	
	public static void main(String[] args) {
		String a = JOptionPane.showInputDialog("Valor 1");
		String op = JOptionPane.showInputDialog("Operação");
		String b = JOptionPane.showInputDialog("Valor 2");
		
		ExercicioIV exercicio = new ExercicioIV();
		double resultado = exercicio.calcular(a, b, op);
		System.out.println(resultado);
	}
	
	public double calcular(String a, String b, String op) {
		double valorA = Double.parseDouble(a);
		double valorB = Double.parseDouble(b);
		double result = 0;
		
		switch (op) {
		case "+":
			result = adiciona(valorA, valorB);
			break;
		case "-":
			result = subtrai(valorA, valorB);
			break;
		case "*":
			result = multiplica(valorA, valorB);
			break;
		case "/":
			result = divide(valorA, valorB);
			break;
			
		default:
			break;
		}
		return result;
	}
	
	private double divide(double valorA, double valorB) {
		return valorA / valorB;
	}

	private double multiplica(double valorA, double valorB) {
		return valorA * valorB;
	}

	private double subtrai(double valorA, double valorB) {
		return valorA - valorB;
	}

	private double adiciona(double valueA, double valueB) {
		return valueA + valueB;
	}
	
}
