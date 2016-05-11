/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author rm48236
 *
 */
public class Exercicio1 {

	private static final int SIZE_LIST = 15_000_000;
	private static final int GET_ITEM_AT = 13_750_000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		System.out.println("METRICAS DE ARRAY LIST");
		populate(arrayList);
		getItemAtPosition(GET_ITEM_AT, arrayList);
		
		System.out.println("\nMETRICAS DE LINKED LIST");
		populate(linkedList);
		getItemAtPosition(GET_ITEM_AT, linkedList);		
		
	}

	private static void getItemAtPosition(int i, List<Integer> list) {
		LocalDateTime start = LocalDateTime.now();
		Integer integer = list.get(i);
		LocalDateTime end = LocalDateTime.now();
		long between = ChronoUnit.MILLIS.between(start, end);
		System.out.printf("\nGet item %d in %d milliseconds.\n", integer, between);
	}

	private static void populate(List<Integer> list) {
		LocalDateTime start = LocalDateTime.now();
		for (int i = 0; i < SIZE_LIST; i++) {
			Random random = new Random();
			int nextInt = random.nextInt(9999);
			list.add(nextInt);
		}
		LocalDateTime end = LocalDateTime.now();
		long between = ChronoUnit.MILLIS.between(start, end);
		System.out.printf("List Populated in %d milliseconds", between );
	}

}
