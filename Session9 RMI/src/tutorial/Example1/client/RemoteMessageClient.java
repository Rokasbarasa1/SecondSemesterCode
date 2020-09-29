package tutorial.Example1.client;

import tutorial.Example1.server.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageClient {
    private RemoteMessageList rml;

    public RemoteMessageClient() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        rml = (RemoteMessageList)reg.lookup("msgList");
    }

    public void addMessageToServer(String msg){
        try {
            rml.addMessage(msg);
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }
}
