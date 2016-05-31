/**
 * 
 */
package br.com.fiap.scj27.rm48236.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;

import br.com.fiap.scj27.rm48236.core.util.ByStatusDateComparator;
import br.com.fiap.scj27.rm48236.core.util.ByStatusUsernameComparator;
import twitter4j.Status;

/**
 * @author Rodrigo
 *
 */
public class Sorter {
	
	public ArrayList<Status> byDate(final SortedMap<Long, Status> tweetList) {
		return sort(tweetList, new ByStatusDateComparator());
	}

	public ArrayList<Status> byAuthorName(final SortedMap<Long, Status> tweetList) {
		return sort(tweetList, new ByStatusUsernameComparator());
	}

	private ArrayList<Status> sort(final SortedMap<Long, Status> tweetList, Comparator<Status> comparator) {
		ArrayList<Status> list = new ArrayList<>();
		list.addAll(tweetList.values());
		
		Collections.sort(list, comparator);

		return list;
	}
	
}
