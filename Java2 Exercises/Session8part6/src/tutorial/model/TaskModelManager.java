package tutorial.model;


import tutorial.Example1.client.Client;
import tutorial.shared.Chat;
import tutorial.shared.Task;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TaskModelManager implements TaskModel {

    private String username;
    private String currentFriend;
    private Client client;
    List<Task> taskList;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TaskModelManager() {
        taskList = new ArrayList<>();
        username = "null";
    }

    @Override
    public void addTask(String creator) {
        Task task = new Task(creator);
        username = creator;
        taskList.add(task);
        support.firePropertyChange("TaskAdded", null, task);
        support.firePropertyChange("updateUser", null, task);
        client.addTask(task);
    }

    @Override
    public void addTaskFromServer(Task task) {
        boolean contains = false;
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getCreator().equals(task.getCreator())){
                contains = true;
                break;
            }
        }
        if(!contains){
            taskList.add(task);
            support.firePropertyChange("TaskAdded", null, task);
        }
    }

    @Override
    public void relogTask() {
        if(!(username.equals("null"))){
            Task removedTask;
            for (int i = 0; i < taskList.size(); i++) {
                if(taskList.get(i).getCreator().equals(username)){
                    client.removeTask(taskList.get(i));
                    removedTask = taskList.remove(i);
                    support.firePropertyChange("TaskRemoved", null, removedTask);
                    break;
                }
            }
        }
    }
    @Override
    public void removeTask(Task task) {
        boolean contains = false;
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getCreator().equals(task.getCreator())){
                contains = true;
                break;
            }
        }
        if(contains){
            taskList.remove(task);
            support.firePropertyChange("TaskRemoved", null, task);
        }
    }

    @Override
    public String getChat(Task task){
        int index = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getCreator().equals(task.getCreator())){
                index = i;
                currentFriend = taskList.get(i).getCreator();
            }
        }
        return taskList.get(index).getChat() + "=gap=" + taskList.get(index).getCreator();
    }

    @Override
    public void messageSent(String chat){
        for (int i = 0; i < taskList.size() ; i++) {
            if(taskList.get(i).getCreator().equals(currentFriend)){
                taskList.get(i).setChat(chat);
            }
        }
        client.messageSent(username, currentFriend, chat);
    }

    @Override
    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void messageFromFriend(Chat chat) {
        String friend = chat.getUsername();
        boolean found = false;
        for (int i = 0; i <taskList.size() ; i++) {
            if(taskList.get(i).getCreator().equals(friend)){
                taskList.get(i).setChat(chat.getChat());
                found =true;
                support.firePropertyChange("MessageRecievedUpdateChat", null, null);
                break;
            }
        }
        if(!found){
            Task task = new Task(chat.getUsername());
            task.setChat(chat.getChat());
            taskList.add(task);
            support.firePropertyChange("MessageRecievedUpdateChat", null, null);
        }

        System.out.println(currentFriend);
        System.out.println(username);
        //if(currentFriend.equals(username)){

          //  support.firePropertyChange("MessageRecievedUpdateChat", null, null);
        //}
    }

    public String getChat(String friend){
        int index = -1;
        for (int i = 0; i < taskList.size(); i++) {
            if(taskList.get(i).getCreator().equals(friend)){
                index = i;
                currentFriend = taskList.get(i).getCreator();
            }
        }
        return taskList.get(index).getChat() + "=gap=" + taskList.get(index).getCreator();
    }

    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
