package tutorial.model;

import tutorial.Example1.client.Client;
import tutorial.shared.Chat;
import tutorial.shared.Task;

public interface TaskModel extends PropertyChangeSubject {
    void addTask(String creator);
    void addTaskFromServer(Task task);
    void relogTask();
    void removeTask(Task task);
    String getChat(String friend);
    String getChat(Task task);
    void messageSent(String chat);
    void setClient(Client client);
    void messageFromFriend(Chat chat);
}
