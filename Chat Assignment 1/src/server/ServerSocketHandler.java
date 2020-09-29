package server;

import shared.Chat;
import shared.Request;
import shared.Message;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable {

    private ServerModel model;
    private Socket socket;
    private ObjectOutputStream outToClient;
    private ObjectInputStream inFromClient;
    private String username;

    public ServerSocketHandler(Socket socket, ServerModel model){
        this.socket = socket;
        this.model = model;
        try {
            outToClient = new ObjectOutputStream(socket.getOutputStream());
            inFromClient = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e){
            e.printStackTrace();
        }
        model.addListener("TaskAdded", evt -> addTask(evt));
        model.addListener("TaskRemoved", this::removeTask);
        model.addListener("NewMessageForUser", evt -> newMessage(evt));
    }



    @Override
    public void run() {
        try{
            while (true){
                Request req = (Request)  inFromClient.readObject();
                if(req.type == Request.TYPE.ADD){
                    model.addTask(req.message);
                    username = req.message.getCreator();
                } else if(req.type == Request.TYPE.REMOVE){
                    model.taskRemoved(req.message);
                } else if(req.type == Request.TYPE.ADDCHAT){
                    model.taskAddChat(req.chat);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void addTask(PropertyChangeEvent evt){
        try {
            Request req = new Request(Request.TYPE.ADD, (Message) evt.getNewValue());
            outToClient.writeObject(req);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private  void removeTask(PropertyChangeEvent evt){
        try {
            Request req = new Request(Request.TYPE.REMOVE, (Message) evt.getNewValue());
            outToClient.writeObject(req);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void newMessage(PropertyChangeEvent evt) {
        try {
            System.out.println(username);
            Chat givenUser = (Chat)evt.getNewValue();
            System.out.println(givenUser.getUsername());
            if(givenUser.getFriendName().equals(username)){
                Request req = new Request(Request.TYPE.ADDCHAT, (Chat) evt.getNewValue());
                outToClient.writeObject(req);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}

