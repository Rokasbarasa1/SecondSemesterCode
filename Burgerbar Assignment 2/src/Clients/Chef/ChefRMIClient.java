package Clients.Chef;

import Clients.Chef.mediator.RecipeProvider;
import Clients.Chef.mediator.RecipeProxy;
import Clients.RemoteSender;
import Server.RemoteCommandList;
import Clients.Chef.mediator.Burger;
import Clients.Chef.mediator.Recipe;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.ThreadLocalRandom;

public class ChefRMIClient implements RemoteSender {
    private boolean stop = false;
    private RemoteCommandList rml;
    private RecipeProvider recipe;

    public ChefRMIClient() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1099);
        UnicastRemoteObject.exportObject(this, 0);
        rml = (RemoteCommandList)reg.lookup("msgList");
        recipe = new RecipeProxy();
    }

    public void makeBurger() throws RemoteException {
        String[] burgers = {"1", "2", "3"};
        while (true){
            if(stop){
                break;
            }
            int number = ThreadLocalRandom.current().nextInt(0, 2 + 1);
            Recipe toMake = null;
            try {
                toMake = recipe.getRecipeById(burgers[number]);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(toMake.getName());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rml.addPerson(this);
            rml.makeBurger(toMake.createBurger());
        }
    }

    @Override
    public void replyMessage(String message) {
        if(message.equals("Closing store")){
            stop = true;
            System.out.println("Chef is going home");
        }
    }

    @Override
    public void sendBurger(Burger dequeue) {
        System.out.println("bleh");
    }
}
