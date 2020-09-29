package tutorial.Example1.server;

import tutorial.shared.Chat;
import tutorial.shared.Task;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ServerModel {
    List<Task> taskList;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ServerModel(){
        taskList = new ArrayList();
    }

    public void taskRemoved(Task task){
        taskList.remove(task);
        support.firePropertyChange("TaskRemoved", null, task);
    }

    public void addListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)){
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    public void addTask(Task task){
        taskList.add(task);
        support.firePropertyChange("TaskAdded", null, task);
    }

    public void taskAddChat(Chat chat) {
        support.firePropertyChange("NewMessageForUser", null, chat);
    }
}