/**
 * 
 */
package br.com.fiap.scj27.rm48236.core;

import static org.junit.Assert.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author rodrigor
 *
 */
public class SearchTest {

	private Search search;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Twitter twitter = TwitterFactory.getSingleton(); 
		search = new Search(twitter);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link br.com.fiap.scj27.rm48236.core.Search#byQuery(java.lang.String)}.
	 * @throws TwitterException 
	 */
	@Test
	public void testByQuery() throws TwitterException {
		SortedMap<Long,Status> map = search.byQuery("#javaone");
		assertNotNull("Retorno do Objeto MAP not null",map);
		
		Status firstStatus = map.get(map.firstKey());
		Status lastStatus = map.get(map.lastKey());
		
		// Utilizando nova API de Datas
		Instant startInstant = Instant.ofEpochMilli(firstStatus.getCreatedAt().getTime());
		Instant endInstant = Instant.ofEpochMilli(lastStatus.getCreatedAt().getTime());
		
		LocalDate startLocalDate = LocalDateTime.ofInstant(startInstant, ZoneId.systemDefault()).toLocalDate();
		LocalDate endLocalDate = LocalDateTime.ofInstant(endInstant, ZoneId.systemDefault()).toLocalDate();
		
		Period between = Period.between(startLocalDate, endLocalDate);

		int days = between.getDays();
		String log = String.format("Todo o Range foi pesquisado. %s ate %s. ID %d ate %d", 
				startInstant.toString(), endInstant.toString(), map.firstKey(), map.lastKey() );
		System.out.println(log);
		assertTrue(log, days > 5);
		
	}

}
