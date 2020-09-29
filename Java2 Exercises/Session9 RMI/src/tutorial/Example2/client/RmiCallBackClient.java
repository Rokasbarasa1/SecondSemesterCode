package tutorial.Example2.client;

import tutorial.Example2.server.RemoteMessageList;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RmiCallBackClient implements RemoteSender{

    private RemoteMessageList rml;

    public RmiCallBackClient() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        try {
            rml = (RemoteMessageList)reg.lookup("msgList");
        } catch (NotBoundException e){
            e.printStackTrace();
        }
    }

    public void addMessageToServer(String msg){
        try {
            rml.addMessage(msg, this);
        } catch (RemoteException e){
            e.printStackTrace();
        }
    }

    @Override
    public void replyMessage(String msg) throws RemoteException{
        System.out.println(msg);
    }
}
