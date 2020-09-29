package server;

import shared.Chat;
import shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerModelImp implements ServerModel{
    List<Message> messageList;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ServerModelImp(){
        messageList = new ArrayList();
    }

    @Override
    public void taskRemoved(Message message){
        messageList.remove(message);
        support.firePropertyChange("TaskRemoved", null, message);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)){
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void addTask(Message message){
        messageList.add(message);
        support.firePropertyChange("TaskAdded", null, message);
    }

    @Override
    public void taskAddChat(Chat chat) {
        support.firePropertyChange("NewMessageForUser", null, chat);
    }
}