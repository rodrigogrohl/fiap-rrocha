/**
 * 
 */
package br.com.fiap.scj27.rm48236.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import br.com.fiap.scj27.rm48236.core.Search;
import br.com.fiap.scj27.rm48236.core.Sorter;
import br.com.fiap.scj27.rm48236.core.Statistics;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

/**
 * Servicos Estatistico em Tweets.
 * Com o objetivo de Minimizar as consultas externas esta classe foi projetada para carregar
 * todas as inforamções de uma busca (query injetada via construtor) e todos demais métodos
 * são acionados sob demanda, porém sem refazer a busca na API.
 * 
 * @author rodrigor
 *
 */
public class TweetStatisticService {

	private Search search;
	
	private Statistics calculate;
	
	private Sorter sorter;
	
	private SortedMap<Long, Status> tweets;

	private String query;

	/**
	 * Construtor, com dependencia requerida. 
	 * @param twitter
	 * @throws TwitterException 
	 */
	public TweetStatisticService(final Twitter twitter, final String query) 
			throws TwitterException {
		this.query = query;
		this.search = new Search(twitter);
		this.tweets = search.byQuery(query);
		this.calculate = new Statistics(tweets);
		sorter = new Sorter();
	}

	/**
	 * Texto de retorno e o resultado da atividade. 
	 * @return
	 */
	public String getResumeInformation() {
		Iterator<Integer> tIt = calculate.getTweetsPerDay().values().iterator();
		String tweetsLog = String.format("HASTAG: %s. Tweets Ult Dias [ASC]: %d, %d, %d, %d, %d, %d, %d", query, tIt.next(), tIt.next(), tIt.next(), tIt.next(), tIt.next(), tIt.next(), tIt.next(), tIt.next());

		Iterator<Integer> rIt = calculate.getRetweetsPerDay().values().iterator();
		String rtsLog = String.format("RTs Ult Dias [ASC]: %d, %d, %d, %d, %d, %d, %d", rIt.next(), rIt.next(), rIt.next(), rIt.next(), rIt.next(), rIt.next(), rIt.next(), rIt.next());
		
		Iterator<Integer> fIt = calculate.getFavoritesPerDay().values().iterator();
		String favLog = String.format("FAVs Ult Dias [ASC]: %d, %d, %d, %d, %d, %d, %d", fIt.next(), fIt.next(), fIt.next(), fIt.next(), fIt.next(), fIt.next(), fIt.next(), fIt.next());
		
		ArrayList<Status> byAuthorName = sorter.byAuthorName(tweets);
		User first = byAuthorName.get(1).getUser();
		User last = byAuthorName.get(byAuthorName.size()-1).getUser();
		String nameLog = String.format("Name: First %s. Last %s", first.getName(), last.getName());
		
		
		ArrayList<Status> byDate = sorter.byDate(tweets);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM");
		Date firstDate = byDate.get(1).getCreatedAt();
		Date lastDate = byDate.get(byDate.size()-1).getCreatedAt();
		String dateLog = String.format("Date: First %s. Last %s", sdf.format(firstDate) , sdf.format(lastDate) );
		
		String log = tweetsLog + "\n" + rtsLog + "\n" + favLog + "\n" + nameLog + "\n" + dateLog;
		System.out.println(log);
		
		return log;
	}
	
	public Map<LocalDate, Integer> getTweetsPerDay(){
		return calculate.getTweetsPerDay();
	}

	public Map<LocalDate, Integer> getReteetsPerDay() {
		return calculate.getRetweetsPerDay();
	}

	public Map<LocalDate, Integer> getFavoritedPerDay() {
		return calculate.getFavoritesPerDay();
	}

}
