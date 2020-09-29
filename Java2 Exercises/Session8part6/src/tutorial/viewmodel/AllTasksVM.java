package tutorial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tutorial.model.TaskModel;
import tutorial.shared.Task;
import java.beans.PropertyChangeEvent;

public class AllTasksVM {

    private TaskModel model;
    private StringProperty chat;
    private ObservableList<Task> tasks;
    private StringProperty username;
    private String friendName;

    public AllTasksVM(TaskModel model) {
        this.model = model;
        chat = new SimpleStringProperty();
        username = new SimpleStringProperty();
        tasks = FXCollections.observableArrayList();

        model.addPropertyChangeListener("TaskAdded", this::listModified);
        model.addPropertyChangeListener("TaskRemoved", evt -> tasks.remove((Task) evt.getNewValue()));
        model.addPropertyChangeListener("MessageRecievedUpdateChat", this::updateChat);
        model.addPropertyChangeListener("updateUser", this::username );
    }
    private void listModified(PropertyChangeEvent evt) {
        tasks.add((Task) evt.getNewValue());
    }
    private void updateChat(PropertyChangeEvent evt) {
        String value = model.getChat(friendName);
        String[] divided = value.split("=gap=");
        chat.set(divided[0]);
        System.out.println("tried to update chat with " + chat.get());
    }
    private void username(PropertyChangeEvent evt){
        Task user = (Task) evt.getNewValue();
        username.setValue(user.getCreator());
    }
    public ObservableList<Task> getTaskList() {
        return tasks;
    }


    public void sendMessage(String message) {
        chat.setValue(chat.get() + "\n+ " + username+ ": " + message);
        model.messageSent(chat.get()); //Kodel cia chat vel siunciu i ta metoda
    }

    public void reLog(){
        model.relogTask();
    }

    public void changeChat(Task newChat) {
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
