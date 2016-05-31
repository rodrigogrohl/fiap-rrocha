package br.com.fiap.scj27.rm48236.service;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

/**
 * Classe de servicos de envio/update de Status (Tweet)
 * @author Rodrigo
 */
public class TweetSenderService {
	
	private Twitter twitter;

	public TweetSenderService(final Twitter twitter) {
		this.twitter = twitter;
	}
	
	public void updateStatusWithOverflow(final String text) throws TwitterException {
		String[] split = text.split("\n");
		String overflow = "";
		for (int i = 0; i < split.length; i++) {
			if( (overflow.length() + split[i].length()) >= 140){
				updateStatus(overflow);
				overflow = "";
			}
			overflow += split[i] + "\n";
		}
		updateStatus(overflow);
	}
	
	public Status updateStatus(final String text) throws TwitterException {
		return twitter.updateStatus(text + "@michelpf");
	}
}
