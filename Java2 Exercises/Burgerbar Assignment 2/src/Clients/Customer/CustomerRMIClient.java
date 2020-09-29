package Clients.Customer;

import Clients.RemoteSender;
import Server.RemoteCommandList;
import Clients.Chef.mediator.Burger;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CustomerRMIClient implements RemoteSender {
    private boolean stop = false;
    private RemoteCommandList rml;

    public CustomerRMIClient() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        UnicastRemoteObject.exportObject(this, 0);
        rml = (RemoteCommandList)reg.lookup("msgList");
    }

    public void getBurger() throws RemoteException {
        while (true){
            rml.addPerson(this);
            rml.getBurger(this);
            System.out.println(rml.returnSize());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(stop){
                break;
            }
        }
    }

    @Override
    public void replyMessage(String message) {
        if(message.equals("Closing store")){
            stop = true;
            System.out.println("Customer is leaving");
        } else {
            System.out.println(message);
        }
    }

    @Override
    public void sendBurger(Burger burger) {
        System.out.println("Recieved " + burger.getName());
    }
}
