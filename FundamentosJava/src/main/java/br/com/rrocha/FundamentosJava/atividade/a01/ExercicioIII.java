package br.com.rrocha.FundamentosJava.atividade.a01;

import javax.swing.JOptionPane;

public class ExercicioIII {

	public static void main(String[] args) {
		
		ExercicioIII exercicio = new ExercicioIII();
		
		int employersNumber = exercicio.askEmployersNumber();
		double [] revenue = exercicio.askForRevenue(employersNumber);
		
		exercicio.printArray(revenue);
	}

	private void printArray(double[] revenue) {
		for (double d : revenue) {
			System.out.print(d + " : ");
		}
	}
	
	private double[] askForRevenue(int employersNumber) {
		double [] results = new double[employersNumber];
		for (int i = 0; i < results.length; i++) {
			results[i] = askForADoublePanel();
		}
		return results;
	}

	private int askEmployersNumber() {
		String text = JOptionPane.showInputDialog("Quantidade de Leituras:", "0");
		try {
			return Integer.parseInt(text);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor de Entrada Inválido: Informe um Inteiro!");
			askEmployersNumber();
		}
		return 0;
	}
	
	private double askForADoublePanel() {
		String text = JOptionPane.showInputDialog("Entre com um valor no Formato:", "0000.00");
		try {
			return Double.parseDouble(text);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Valor de Entrada Inválido: Informe um Inteiro!");
			askForADoublePanel();
		}
		return 0.0;
	}
}
