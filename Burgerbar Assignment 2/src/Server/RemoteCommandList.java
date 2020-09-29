package Server;

import Clients.RemoteSender;
import Clients.Chef.mediator.Burger;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteCommandList extends Remote{
    void makeBurger(Burger burger) throws RemoteException;
    void getBurger(RemoteSender sender) throws RemoteException;
    void closeStore(RemoteSender sender) throws RemoteException;
    void addPerson(RemoteSender sender) throws RemoteException;
    int returnSize() throws RemoteException;
}
