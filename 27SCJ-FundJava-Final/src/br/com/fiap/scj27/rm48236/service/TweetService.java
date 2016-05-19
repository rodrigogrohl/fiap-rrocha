/**
 * 
 */
package br.com.fiap.scj27.rm48236.service;

import java.util.Date;
import java.util.Map;

import twitter4j.Twitter;

/**
 * Servicos de Query em Tweets.
 * 
 * @author rodrigor
 *
 */
public class TweetService {

	private Twitter twitter;

	/**
	 * Construtor, com instancia aplicada. 
	 * @param twitter
	 */
	public TweetService(final Twitter twitter) {
		this.twitter = twitter;
	}
	
	public Map<Date, Integer> findTweetsPerDayWith(final String hashtag) {
		
		return null;
	}

	public Map<Date, Integer> findReteetsPerDayWith(final String hashtag) {
		
		return null;
	}

	public Map<Date, Integer> findFavoritedPerDayWith(final String hashtag) {
		
		return null;
	}

}
