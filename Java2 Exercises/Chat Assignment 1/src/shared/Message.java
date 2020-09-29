package shared;

import java.io.Serializable;

public class Message implements Serializable {
    private String creator, chat;

    public Message(String creator) {
        this.creator = creator;
        this.chat = "";
    }

    public String getCreator() {
        return creator;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }
}
