package br.com.fiap.scj27.rm48236;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query.ResultType;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Teste {

	public static void main(String[] args) {
		//TwitterFactory factory = new TwitterFactory(configurationSetup());
		// Twitter twitter = factory.getInstance();		

		// System.setProperty("twitter4j.http.useSSL","false");
		// System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");

		Twitter twitter = TwitterFactory.getSingleton();
		SortedMap<Long, Status> tweetsMap = new TreeMap<>();
		try {
			String screenName = twitter.getScreenName();
			long id = twitter.getId();
			
			Query query = new Query("#java");
			//query.setSince(since);
			query.setCount(100);
			query.setMaxId(735068327974965249L);

			
			QueryResult queryResult = twitter.search(query);
			query.setResultType(ResultType.recent);
			System.out.println("Found Tweets: " + queryResult.getCount());
			List<Status> tweets = queryResult.getTweets();
			for (Status status : tweets) {
				String tweetLog = String.format("ID: %d from %s at %s posted: %s", status.getId(), status.getUser().getName(), status.getCreatedAt(), status.getText());
				System.out.println(tweetLog);
				tweetsMap.put(status.getId(), status);
			}
			Long firstKey = tweetsMap.firstKey();
			Long lastKey = tweetsMap.lastKey();
			System.out.println( String.format("Query returned range %d to %d", firstKey, lastKey) );
			System.out.println("YOUR ID: " + id + " " + screenName);
		} catch (IllegalStateException | TwitterException e) {
			e.printStackTrace();
		}


	}
	
	private static Configuration configurationSetup() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setHttpReadTimeout(500);
		builder.setUser("rodrigogrohl");
		builder.setPassword("Martinez00");
		builder.setHttpProxyHost("proxypac");
		builder.setHttpProxyPort(8080);
		builder.setHttpProxyUser("rodrigor");
		builder.setHttpProxyPassword("Java!0416");
		return builder.build();
	}

}
