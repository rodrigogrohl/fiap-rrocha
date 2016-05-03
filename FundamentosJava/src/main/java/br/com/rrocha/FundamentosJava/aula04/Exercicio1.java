/**
 * 
 */
package br.com.rrocha.FundamentosJava.aula04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author rm48236
 *
 */
public class Exercicio1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> arrayList = new ArrayList<Integer>();
		List<Integer> linkedList = new LinkedList<Integer>();
		populateWithSameContent(arrayList, linkedList);
		getItemAtPosition(750000, arrayList);
		getItemAtPosition(750000, linkedList);		
		
	}

	private static void getItemAtPosition(int i, List<Integer> list) {
		LocalDateTime start = LocalDateTime.now();
		Integer integer = list.get(i);
		LocalDateTime end = LocalDateTime.now();
		long between = ChronoUnit.MILLIS.between(start, end);
		System.out.println(start + " x " + end);
		System.out.printf("Get item %d in %d milliseconds.\n", integer, between);
	}

	private static void populateWithSameContent(List<Integer> arrayList,
			List<Integer> linkedList) {
		for (int i = 0; i < 1000000; i++) {
			Random random = new Random();
			int nextInt = random.nextInt(9999);
			arrayList.add(nextInt);
			linkedList.add(nextInt);
		}
		System.out.printf("List #1 size: %d \nList #2 size: %d\n", arrayList.size(), linkedList.size() );
	}

}
