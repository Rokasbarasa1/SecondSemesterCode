package model;


import networking.Client;
import shared.Chat;
import shared.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ChatModelManager implements ChatModel {

    private String username;
    private String currentFriend;
    private Client client;
    List<Message> messageList;
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ChatModelManager() {
        messageList = new ArrayList<>();
        username = "null";
    }

    @Override
    public void addTask(String creator) {
        Message message = new Message(creator);
        username = creator;
        messageList.add(message);
        support.firePropertyChange("TaskAdded", null, message);
        support.firePropertyChange("updateUser", null, message);
        client.addTask(message);
    }

    @Override
    public void addTaskFromServer(Message message) {
        boolean contains = false;
        for (int i = 0; i < messageList.size(); i++) {
            if(messageList.get(i).getCreator().equals(message.getCreator())){
                contains = true;
                break;
            }
        }
        if(!contains){
            messageList.add(message);
            support.firePropertyChange("TaskAdded", null, message);
        }
    }

    @Override
    public void relogTask() {
        if(!(username.equals("null"))){
            Message removedMessage;
            for (int i = 0; i < messageList.size(); i++) {
                if(messageList.get(i).getCreator().equals(username)){
                    client.removeTask(messageList.get(i));
                    removedMessage = messageList.remove(i);
                    support.firePropertyChange("TaskRemoved", null, removedMessage);
                    break;
                }
            }
        }
    }
    @Override
    public void removeTask(Message message) {
        boolean contains = false;
        for (int i = 0; i < messageList.size(); i++) {
            if(messageList.get(i).getCreator().equals(message.getCreator())){
                contains = true;
                break;
            }
        }
        if(contains){
            messageList.remove(message);
            support.firePropertyChange("TaskRemoved", null, message);
        }
    }

    @Override
    public String getChat(Message message){
        int index = -1;
        for (int i = 0; i < messageList.size(); i++) {
            if(messageList.get(i).getCreator().equals(message.getCreator())){
                index = i;
                currentFriend = messageList.get(i).getCreator();
            }
        }
        return messageList.get(index).getChat() + "=gap=" + messageList.get(index).getCreator();
    }

    @Override
    public void messageSent(String chat){
        for (int i = 0; i < messageList.size() ; i++) {
            if(messageList.get(i).getCreator().equals(currentFriend)){
                messageList.get(i).setChat(chat);
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
        for (int i = 0; i < messageList.size() ; i++) {
            if(messageList.get(i).getCreator().equals(friend)){
                messageList.get(i).setChat(chat.getChat());
                found =true;
                support.firePropertyChange("MessageRecievedUpdateChat", null, null);
                break;
            }
        }
        if(!found){
            Message message = new Message(chat.getUsername());
            message.setChat(chat.getChat());
            messageList.add(message);
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
        for (int i = 0; i < messageList.size(); i++) {
            if(messageList.get(i).getCreator().equals(friend)){
                index = i;
                currentFriend = messageList.get(i).getCreator();
            }
        }
        return messageList.get(index).getChat() + "=gap=" + messageList.get(index).getCreator();
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
