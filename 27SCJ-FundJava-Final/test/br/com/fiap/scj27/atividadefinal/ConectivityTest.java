/**
 * 
 */
package br.com.fiap.scj27.atividadefinal;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author Rodrigo
 *
 */
public class ConectivityTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Twitter twitter = TwitterFactory.getSingleton();
		try {
			String screenName = twitter.getScreenName();
			assertNotNull(screenName);			
		} catch (IllegalStateException | TwitterException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
