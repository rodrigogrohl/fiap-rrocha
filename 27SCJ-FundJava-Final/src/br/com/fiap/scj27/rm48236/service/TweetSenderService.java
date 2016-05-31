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
	
	/**
	 * Metodo criado para quebrar textos maiores que 140 caracteres
	 * @param text
	 * @throws TwitterException
	 */
	public void updateStatusWithOverflow(final String text, final String regex, final String sufix) throws TwitterException {
		String[] split = text.split(regex);
		String overflow = "";
		for (int i = 0; i < split.length; i++) {
			if( (overflow.length() + split[i].length() + sufix.length()) >= 140){
				updateStatus(overflow, sufix);
				overflow = "";
			}
			overflow += split[i] + "\n";
		}
		updateStatus(overflow, sufix);
	}
	
	public Status updateStatus(final String text, final String sufix) throws TwitterException {
		return twitter.updateStatus(text + " " + sufix);
	}
}
