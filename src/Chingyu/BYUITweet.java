package Chingyu;

import com.google.gson.annotations.SerializedName;

public class BYUITweet {
    
    @SerializedName("user")
    private Chingyu.User user;
    public Chingyu.User getUser() { return user; }
    public void setUser(Chingyu.User user) { this.user = user; }
    
    @SerializedName("text")
    private String text;
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    
}
