package tutorial.Example1.client;

import tutorial.model.TaskModel;
import tutorial.shared.Chat;
import tutorial.shared.Request;
import tutorial.shared.Task;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client {
    TaskModel model;
    ClientSocketHandler socketHandler;

    public SocketClient (TaskModel _model){
        model = _model;
        model.setClient(this);
        try {
            Socket socket = new Socket("localhost", 3000);
            socketHandler = new ClientSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream()), this);
            Thread t = new Thread(socketHandler);
            t.start();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void addTask(Task task) {
        socketHandler.sendToServer(Request.TYPE.ADD, task);
    }

    @Override
    public void removeTask(Task task) {
        socketHandler.sendToServer(Request.TYPE.REMOVE, task);
    }

    public void addToCLientModel(Task task){
        model.addTaskFromServer(task);
    }

    public void removeFromClientModel(Task task){
        model.removeTask(task);
    }

    public void messageSent(String username, String friendName, String chat){
        Chat send = new Chat(username, friendName, chat);
        socketHandler.sendToServer(Request.TYPE.ADDCHAT, send);
    }

    public void messageFromFriendInClientModel(Chat chat) {
        model.messageFromFriend(chat);
    }
}
