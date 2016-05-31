package br.com.fiap.scj27.rm48236.core;

import static org.junit.Assert.*;

import java.util.SortedMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class SorterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	private Search search;

	@Before
	public void setUp() throws Exception {
		Twitter twitter = TwitterFactory.getSingleton(); 
		search = new Search(twitter);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOrder() throws TwitterException {
		SortedMap<Long, Status> tweets = search.byQuery("#javaone");
		Sorter order = new Sorter();

	}

}
