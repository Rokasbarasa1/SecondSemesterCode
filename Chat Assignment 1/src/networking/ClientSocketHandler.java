package networking;

import shared.Chat;
import shared.Request;
import shared.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ClientSocketHandler implements Runnable{

    private SocketClient client;
    private ObjectInputStream inFromServer;
    private ObjectOutputStream outToServer;

    public ClientSocketHandler(ObjectOutputStream outToClient,ObjectInputStream inFromClient, SocketClient _client){
        this.client = _client;
        this.outToServer = outToClient;
        this.inFromServer = inFromClient;
    }
    @Override
    public void run() {
        try {
            while (true){
                Request req = (Request) inFromServer.readObject();
                if(req.type == Request.TYPE.ADD){
                    client.addToCLientModel(req.message);
                } else if(req.type == Request.TYPE.REMOVE){
                    client.removeFromClientModel(req.message);
                } else if(req.type == Request.TYPE.ADDCHAT){
                    client.messageFromFriendInClientModel(req.chat);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(Request.TYPE type, Message message){
        try {
            outToServer.writeObject(new Request(type, message));
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(Request.TYPE type, Chat chat){
        try {
            outToServer.writeObject(new Request(type, chat));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
