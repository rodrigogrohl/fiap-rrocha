package br.com.fiap.scj27.atividadefinal;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Teste {

	public static void main(String[] args) {
		// System.setProperty("twitter4j.http.useSSL","false");
		// System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			String screenName = twitter.getScreenName();
			System.out.println(screenName);
		} catch (IllegalStateException | TwitterException e) {
			e.printStackTrace();
		}


	}

}
