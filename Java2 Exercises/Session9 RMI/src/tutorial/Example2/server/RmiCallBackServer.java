package tutorial.Example2.server;

import tutorial.Example2.client.RemoteSender;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RmiCallBackServer implements RemoteMessageList {

    List<String> messageList;

    public RmiCallBackServer() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        messageList = new ArrayList<>();
    }

    @Override
    public void addMessage(String msg, RemoteSender who) throws RemoteException {
        messageList.add(msg);
        who.replyMessage("Thank you for the message");
    }
}
