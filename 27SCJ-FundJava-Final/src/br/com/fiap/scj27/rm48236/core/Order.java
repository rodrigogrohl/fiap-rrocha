/**
 * 
 */
package br.com.fiap.scj27.rm48236.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;

import br.com.fiap.scj27.rm48236.core.util.ByStatusUsernameComparator;
import twitter4j.Status;

/**
 * @author Rodrigo
 *
 */
public class Order {
	
	private SortedMap<Long, Status> tweetList;
	
	private ArrayList<Status> byAuthorName = new ArrayList<Status>();

	public Order(final SortedMap<Long, Status> tweetList) {
		this.tweetList = tweetList;
		byAuthorName();
		byDate();
	}

	private void byDate() {
		
	}

	private void byAuthorName() {
		Comparator<Status> comp = new ByStatusUsernameComparator();
		ArrayList<Status> list = new ArrayList<>();
		list.addAll(tweetList.values());
		
		Collections.sort(list, comp);
		
		for (Status status : list) {
			System.out.printf("Author: %s Tweeted: %s\n", status.getUser().getName(), status.getText());
			
		}
		
	}

}
