package br.com.fiap.scj27.rm48236.core;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Classe responsavel pelas chamadas de busca na API.
 * 
 * @author Rodrigo
 *
 */
public class Search {

	private Twitter twitter;

	public Search(final Twitter twitter) {
		this.twitter = twitter;
	}
	
	/**
	 * Busca todos os tweets disponíveis na API, paginando regressivamente 
	 * via minId e maxId.
	 * 
	 * Utilizado TreeMap pelo seu algoritmo de Armazenamento e Ordenação
	 * 
	 * @param query
	 * @return
	 * @throws TwitterException 
	 */
	public SortedMap<Long, Status> byQuery(final String stringQuery) throws TwitterException {
		
		Query query = new Query(stringQuery);
		query.setCount(100);
		QueryResult result = null;
		SortedMap<Long, Status> allResults = new TreeMap<>();
		
		do {
			result = twitter.search(query);
			List<Status> tweets = result.getTweets();
			for (Status status : tweets) {
				allResults.put(status.getId(), status);
			}
			query.setMaxId(allResults.firstKey() - 1);

			//System.out.println( String.format("Putting %d Tweets in Map", tweets.size()) );
		} while (result.getTweets().size() > 0);
		
		System.out.println( String.format("Found %d Tweets!", allResults.size()) );
		return allResults;
	}

}
