package br.com.fiap.scj27.rm48236.service;

import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;

public class TweetStatisticServiceTest {

	private static TweetStatisticService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Twitter twitter = TwitterFactory.getSingleton();
		String query = "#jvm";
		service = new TweetStatisticService(twitter, query);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetResumeInformation() {
		String resumeInformation = service.getResumeInformation();
		System.out.println(resumeInformation);
		assertNotNull(resumeInformation);
	}


}
