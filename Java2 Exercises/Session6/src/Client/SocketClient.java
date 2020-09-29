package Client;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient implements Client {
    TaskListModel model;
    CSocketHandler socketHandler;

    public SocketClient(TaskListModel _model){
        model = model;
        model.setClient(this);
        try{
            Socket socket = new Socket("localhost", 2910);
            socketHandler = new CSocketHandler(
                    new ObjectOutputStream(socket.getOutputStream()),
                    new ObjectInputStream(socket.getInputStream()), this);
            Thread t = new Thread(socketHandler);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToClientModel(Task task){
        model.addTask(task);
    }
    public void removeFromClientModel(Task task){
        model.removeTask(task);
    }

    @Override
    public void addTask(Task task){
        socketHandler.sendToServer(Request.TYPE.ADD, task);
    }

    @Override
    public void removeTask(Task task){
        socketHandler.sendToServer(Request.TYPE.REMOVE, task);
    }
}
