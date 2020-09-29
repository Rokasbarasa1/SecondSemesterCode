package model;

import networking.Client;
import shared.Chat;
import shared.Message;

public interface ChatModel extends PropertyChangeSubject {
    void addTask(String creator);
    void addTaskFromServer(Message message);
    void relogTask();
    void removeTask(Message message);
    String getChat(String friend);
    String getChat(Message message);
    void messageSent(String chat);
    void setClient(Client client);
    void messageFromFriend(Chat chat);
}
