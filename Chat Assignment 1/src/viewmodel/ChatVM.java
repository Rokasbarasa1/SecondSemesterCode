package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ChatModel;
import shared.Message;
import java.beans.PropertyChangeEvent;

public class ChatVM {

    private ChatModel model;
    private StringProperty chat;
    private ObservableList<Message> messages;
    private StringProperty username;
    private String friendName;

    public ChatVM(ChatModel model) {
        this.model = model;
        chat = new SimpleStringProperty();
        username = new SimpleStringProperty();
        messages = FXCollections.observableArrayList();

        model.addPropertyChangeListener("TaskAdded", this::listModified);
        model.addPropertyChangeListener("TaskRemoved", evt -> messages.remove((Message) evt.getNewValue()));
        model.addPropertyChangeListener("MessageRecievedUpdateChat", this::updateChat);
        model.addPropertyChangeListener("updateUser", this::username );
    }
    private void listModified(PropertyChangeEvent evt) {
        messages.add((Message) evt.getNewValue());
    }
    private void updateChat(PropertyChangeEvent evt) {
        String value = model.getChat(friendName);
        String[] divided = value.split("=gap=");
        chat.set(divided[0]);
        System.out.println("tried to update chat with " + chat.get());
    }
    private void username(PropertyChangeEvent evt){
        Message user = (Message) evt.getNewValue();
        username.setValue(user.getCreator());
    }
    public ObservableList<Message> getTaskList() {
        return messages;
    }


    public void sendMessage(String message) {
        chat.setValue(chat.get() + "\n " + username.get()+ ": " + message);
        model.messageSent(chat.get());
    }

    public void reLog(){
        model.relogTask();
    }

    public void changeChat(Message newChat) {
        String value = model.getChat(newChat);
        String[] divided = value.split("=gap=");
        chat.set(divided[0]);
        friendName = divided[1];
    }

    public String getChat() {
        return chat.get();
    }

    public String getFriendName(){
        return  friendName;
    }


    public StringProperty usernameStringProperty() {
        return username;
    }

    public StringProperty chatStringProperty() {
        return chat;
    }
}
