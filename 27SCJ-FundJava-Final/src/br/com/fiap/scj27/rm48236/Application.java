package br.com.fiap.scj27.rm48236;

import java.util.logging.Logger;

import javax.swing.JOptionPane;

import br.com.fiap.scj27.rm48236.service.TweetSenderService;
import br.com.fiap.scj27.rm48236.service.TweetStatisticService;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class Application {
	
	private static Logger log = Logger.getLogger(Application.class.getName());
	
	public static void main(String[] args) {
		Twitter twitter = TwitterFactory.getSingleton();
		String hashtag = JOptionPane.showInputDialog("Hastag a ser processada: ");
		
		try {
			TweetStatisticService service = new TweetStatisticService(twitter , hashtag);
			String resumeInformation = service.getResumeInformation();
			
			TweetSenderService sender = new TweetSenderService(twitter);
			sender.updateStatusWithOverflow(resumeInformation);
			
		} catch (TwitterException e) {
			log.warning(e.getLocalizedMessage());
			e.printStackTrace();
		}
		//@michelpf 
	}

}
