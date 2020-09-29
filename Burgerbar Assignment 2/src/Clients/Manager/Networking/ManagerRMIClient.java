package Clients.Manager.Networking;

import Clients.RemoteSender;
import Server.RemoteCommandList;
import Clients.Chef.mediator.Burger;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ManagerRMIClient implements RemoteSender {
    private RemoteCommandList rml;

    public ManagerRMIClient() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        UnicastRemoteObject.exportObject(this, 0);
        rml = (RemoteCommandList)reg.lookup("msgList");
    }

    public void closeStore() throws RemoteException {
        rml.closeStore(this);
    }

    @Override
    public void replyMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void sendBurger(Burger dequeue) {
    }
}
