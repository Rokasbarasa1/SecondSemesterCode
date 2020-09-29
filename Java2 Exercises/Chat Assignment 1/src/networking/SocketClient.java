package networking;

import model.ChatModel;
import shared.Chat;
import shared.Request;
import shared.Message;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketClient implements Client {
    ChatModel model;
    ClientSocketHandler socketHandler;

    public SocketClient (ChatModel _model){
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
    public void addTask(Message message) {
        socketHandler.sendToServer(Request.TYPE.ADD, message);
    }

    @Override
    public void removeTask(Message message) {
        socketHandler.sendToServer(Request.TYPE.REMOVE, message);
    }

    public void addToCLientModel(Message message){
        model.addTaskFromServer(message);
    }

    public void removeFromClientModel(Message message){
        model.removeTask(message);
    }

    public void messageSent(String username, String friendName, String chat){
        Chat send = new Chat(username, friendName, chat);
        socketHandler.sendToServer(Request.TYPE.ADDCHAT, send);
    }

    public void messageFromFriendInClientModel(Chat chat) {
        model.messageFromFriend(chat);
    }
}
