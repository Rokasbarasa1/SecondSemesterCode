package tutorial.shared;

import java.io.Serializable;

public class Request implements Serializable {

    public enum TYPE {
        ADD,
        REMOVE,
        ADDCHAT
    }

    public TYPE type;
    public Task task;
    public Chat chat;

    public Request(TYPE type, Task task){
        this.type = type;
        this.task = task;
    }

    public Request(TYPE type, Chat chat){
        this.type = type;
        this.chat = chat;
    }
}
