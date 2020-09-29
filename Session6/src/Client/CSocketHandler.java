package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CSocketHandler implements Runnable {

    private ObjectOutputStream outToServer;
    private ObjectInputStream inFromServer;
    private SocketClient client;

    public CSocketHandler( ObjectOutputStream outToServer,
        ObjectInputStream inFromServer, SocketClient _client){
        client = _client;
        this.outToServer = outToServer;
        this.inFromServer = inFromServer;
    }

    @Override
    public void run() {
        try{
            while (true){
                Request req = (Request)inFromServer.readObject();
                if(req.type == Request.TYPE.ADD){
                    client.addToClientModel(req.task);
                } else if(req.type == Request.TYPE.REMOVE) {
                    client.removeFromClientModel(req.task);
                }
            }
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void sendToServer(Request.TYPE type, Task task){
        try {
            outToServer.writeObject(new Request(type, task));
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
