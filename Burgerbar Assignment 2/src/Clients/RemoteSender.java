package Clients;

import Clients.Chef.mediator.Burger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteSender extends Remote {
    void replyMessage(String message) throws RemoteException;
    void sendBurger(Burger dequeue) throws RemoteException;
}
