package tutorial.Example2.server;

import tutorial.Example2.client.RemoteSender;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote{
    void addMessage(String msg, RemoteSender who) throws RemoteException;
}
