import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class Main {
	
	
	public static void main(String Args[]) throws IOException{
		int count=0;
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey("")
		  .setOAuthConsumerSecret("")
		  .setOAuthAccessToken("")
		  .setOAuthAccessTokenSecret("");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		try {
			String q = "#nea_dimokratia";
            //Query query = new Query("to:"+q+" since:2017-01-26 until:2017-02-01 -RT lang:el");
            Query query = new Query(q+" since:2017-01-26 until:2017-02-01 -RT lang:el");
            query.count(2000);
            QueryResult result;
            FileWriter fstream = new FileWriter(q+".txt",true);
            BufferedWriter bw = new BufferedWriter(fstream);
            do{
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
            	count++;
                bw.write("<id>"+tweet.getId());
                bw.newLine();
                bw.write("<tweet>"+tweet.getText());
                bw.newLine();
                bw.write("<user>"+tweet.getUser().getScreenName());
                bw.newLine();
                bw.write("<date>"+tweet.getCreatedAt());
                bw.newLine();
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText()+tweet.getId());
            }
        } while ((query = result.nextQuery()) != null);
            bw.close();
            fstream.close();
            System.out.println(count);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
		
	}

}
