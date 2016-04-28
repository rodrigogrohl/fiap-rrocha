/**
 * 
 */
package br.com.rrocha.FundamentosJava.atividade.a01;

import java.util.Random;

/**
 * @author rm48236
 *
 */
public class ExercicioI {
	
	private int[] createArray(final int size) {
		int [] array = new int[size];
		Random random = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(99);
		}
		print(array);
		return array;		
	}
	
	private void print(final int[] array) {
		System.out.print("Printing an array: ");
		for (int i : array) {
			System.out.print(i + ", ");
		}
		System.out.println("\n");
	}
	
	private void invert(int[] array) {
		int [] inverted = new int[array.length];
		int upCounter = 0;
		for (int downCounter = array.length -1; downCounter >= 0; downCounter--) {
			inverted[upCounter] = array[downCounter];
			upCounter++;
		}
		print(inverted);
	}
	
	public static void main(String[] args) {
		int arraySize = 10;
		ExercicioI exercicioI = new ExercicioI();
		int[] array = exercicioI.createArray(arraySize);
		exercicioI.invert(array);
	}


}
