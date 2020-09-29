package networking;

import shared.Message;

public interface Client {
    void addTask(Message message);
    void removeTask(Message message);
    void messageSent(String username, String currentFriend, String chat);
}
