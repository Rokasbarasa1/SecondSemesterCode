package tutorial.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Task implements Serializable {
    private String creator, chat;
    private ArrayList<String> friends;

    public Task(String creator) {
        this.creator = creator;
        this.chat = "";
        this.friends = new ArrayList<String>();
    }

    public String getCreator() {
        return creator;
    }

    public void addFriend(String friend){
        friends.add(friend);
    }

    public String getFriend(int i){
        return friends.get(i);
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
