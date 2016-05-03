/**
 * 
 */
package br.com.rrocha.FundamentosJava.atividade.a01;

import javax.swing.JOptionPane;

/**
 * @author rm48236
 *
 */
public class ExercicioV {
	
	public static void main(String[] args) {
		String inputDialog = JOptionPane.showInputDialog("Fatorial: Entre com o número a ser calculado!");
		int i = Integer.parseInt(inputDialog);
		int resultado = fatorial(i);
		System.out.println(resultado);
	}

	private static int fatorial(int i) {
		int result = i * (i-1);
		if(i > 0){
			i--;
			result += fatorial(i);  
		}
		return result;
	}
}
