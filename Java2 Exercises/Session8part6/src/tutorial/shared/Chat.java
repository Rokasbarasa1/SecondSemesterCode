package tutorial.shared;

import java.io.Serializable;

public class Chat implements Serializable {
    private String username;
    private String friendName;
    private String chat;

    public Chat(String username, String friendName, String chat) {
        this.username = username;
        this.friendName = friendName;
        this.chat = chat;
    }

    public String getUsername() {
        return username;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getChat(){
        return chat;
    }
}
