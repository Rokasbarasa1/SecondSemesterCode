package tutorial.Example1.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteMessageList extends Remote{

    public void addMessage(String msg) throws RemoteException;
}
