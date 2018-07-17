package Chingyu;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    
    public static void main(String[] args) {
        TweetLoader tl = new TweetLoader();
        
        Map<String, BYUITweet> data = tl.retrieveTweetsWithHashTag("#byui");
        
        for(String name: data.keySet()) {
            BYUITweet b = data.get(name);
            System.out.format("%s (%d Followers) - %s%n",
                    name, b.getUser().getFollowers(), b.getText());
        }
        
        List<String> sortedNames = new ArrayList<>(data.keySet());
        
        Collections.sort(sortedNames, (a1, a2) -> Integer.compare(data.get(a2).getUser().getFollowers(),
                                                                  data.get(a1).getUser().getFollowers()));
        System.out.println();
        for(String name: sortedNames) {
            BYUITweet b = data.get(name);
            System.out.format("%s (%d Followers) - %s%n",
                    name, b.getUser().getFollowers(), b.getText());
        }
    }
}
