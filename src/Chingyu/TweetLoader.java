package Chingyu;


import com.google.gson.Gson;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Map;
import java.util.TreeMap;

public class TweetLoader {
    
    private Twitter twitter;
    
    public TweetLoader() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("Jro8WI0Ihday8AFjdT8QV9Wmk")
                .setOAuthConsumerSecret("He0kosNtXatCBUtHbuA8Y1Vthlk2zVgjXMYQ7GGqMa8PJUX07z")
                .setOAuthAccessToken("2827384230-jYl0hCfSIJ9LelTjvsDub3dimWqEB20JGlG8WZy")
                .setOAuthAccessTokenSecret("q3DSPuOvenPjXwndiC0544EgR58MyBWRr2KeDWUb4d5z9")
                .setJSONStoreEnabled(true);
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        this.twitter = tf.getInstance();
    }
    
    public Map<String, BYUITweet> retrieveTweetsWithHashTag(String hashTag) {
        TreeMap<String, BYUITweet> hashMap = new TreeMap<>();
        
        Query qHashTag = new Query(hashTag);
        QueryResult qResults;
        try {
            qResults = twitter.search(qHashTag);
        } catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }
    
        Gson gson = new Gson();
        for(Status s: qResults.getTweets()) {
            String str = TwitterObjectFactory.getRawJSON(s);
            BYUITweet b = gson.fromJson(str, BYUITweet.class);
            
            hashMap.put(s.getUser().getName(), b);
        }
        
        return hashMap;
    }
}

