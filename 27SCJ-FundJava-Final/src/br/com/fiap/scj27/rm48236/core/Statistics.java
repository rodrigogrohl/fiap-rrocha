package br.com.fiap.scj27.rm48236.core;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import twitter4j.Status;

/**
 * Classe responsavel por agrupar e calcular as estatisticas de uma lista de
 * Tweets (Status)
 * 
 * @author Rodrigo
 *
 */
public class Statistics {

	private SortedMap<Long, Status> tweetList;

	private SortedMap<LocalDate, List<Status>> groupedTweetsPerDay = new TreeMap<>();

	private SortedMap<LocalDate, Integer> tweetsPerDay = new TreeMap<>();

	private SortedMap<LocalDate, Integer> retweetsPerDay = new TreeMap<>();

	private SortedMap<LocalDate, Integer> favoritesPerDay = new TreeMap<>();

	public Statistics(final SortedMap<Long, Status> tweetList) {
		this.tweetList = tweetList;
		groupTweetsPerDay();
		sumarizeTweets();
	}

	private void sumarizeTweets() {
		Set<LocalDate> dates = groupedTweetsPerDay.keySet();
		for (LocalDate tweetDate : dates) {
			List<Status> tweets = groupedTweetsPerDay.get(tweetDate);
			int retweets = 0;
			int favorites = 0;
			for (Status status : tweets) {
				retweets += status.getRetweetCount();
				favorites += status.getFavoriteCount();
			}

			tweetsPerDay.put(tweetDate, tweets.size());
			retweetsPerDay.put(tweetDate, retweets);
			favoritesPerDay.put(tweetDate, favorites);

			System.out.printf("Dia %d: %d tweets. %d RT's. %d Favorites.\n", tweetDate.getDayOfMonth(), tweets.size(),
					retweets, favorites);
		}
	}

	private void groupTweetsPerDay() {
		Iterator<Status> iterator = tweetList.values().iterator();
		while (iterator.hasNext()) {
			Status status = (Status) iterator.next();
			Date date = status.getCreatedAt();

			@SuppressWarnings("deprecation")
			LocalDate tweetDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDate());

			if (!groupedTweetsPerDay.containsKey(tweetDate)) {
				groupedTweetsPerDay.put(tweetDate, new ArrayList<Status>());
			}
			groupedTweetsPerDay.get(tweetDate).add(status);
		}
		//String log = String.format("Agrupados status em %d dias distintos", groupedTweetsPerDay.size());
		//System.out.println(log);
	}

	public SortedMap<LocalDate, List<Status>> getGroupedTweetsPerDay() {
		return groupedTweetsPerDay;
	}

	public SortedMap<LocalDate, Integer> getTweetsPerDay() {
		return tweetsPerDay;
	}

	public SortedMap<LocalDate, Integer> getRetweetsPerDay() {
		return retweetsPerDay;
	}

	public SortedMap<LocalDate, Integer> getFavoritesPerDay() {
		return favoritesPerDay;
	}

}
