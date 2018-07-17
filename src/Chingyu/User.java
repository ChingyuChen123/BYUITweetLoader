package Chingyu;

import com.google.gson.annotations.SerializedName;

public class User{
    
    @SerializedName("name")
    private String name;
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    
    @SerializedName("followers_count")
    private int followers;
    public int getFollowers() {return followers;}
    public void setFollowers(int followers) {this.followers = followers;}
    
}
