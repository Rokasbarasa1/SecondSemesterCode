package tutorial.Example1.client;

import tutorial.shared.Task;

public interface Client {
    void addTask(Task task);
    void removeTask(Task task);
    void messageSent(String username, String currentFriend, String chat);
}
