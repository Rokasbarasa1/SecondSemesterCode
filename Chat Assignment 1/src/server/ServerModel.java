package server;

import shared.Chat;
import shared.Message;

import java.beans.PropertyChangeListener;

public interface ServerModel {
    public void taskRemoved(Message message);

    public void addListener(String eventName, PropertyChangeListener listener);

    public void addTask(Message message);

    public void taskAddChat(Chat chat);
}
