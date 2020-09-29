package tutorial.Example1.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer implements RemoteMessageList{

    private ArrayList<String> msgs;

    public RemoteMessageServer() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        msgs = new ArrayList<String>();
    }

    @Override
    public void addMessage(String msg) throws RemoteException {
        msgs.add(msg);
        System.out.println("Message added: " + msg);
    }
}
