package shared;

import java.io.Serializable;

public class Request implements Serializable {

    public enum TYPE {
        ADD,
        REMOVE,
        ADDCHAT
    }

    public TYPE type;
    public Message message;
    public Chat chat;

    public Request(TYPE type, Message message){
        this.type = type;
        this.message = message;
    }

    public Request(TYPE type, Chat chat){
        this.type = type;
        this.chat = chat;
    }
}
