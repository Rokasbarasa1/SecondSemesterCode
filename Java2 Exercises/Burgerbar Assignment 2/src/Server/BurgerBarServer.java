package Server;

import Clients.RemoteSender;
import Server.utility.BlockingQueue;
import Server.utility.Queue;
import Clients.Chef.mediator.Burger;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class BurgerBarServer implements RemoteCommandList {

    private ArrayList<RemoteSender> users;
    private BlockingQueue burgers;

    public BurgerBarServer() throws RemoteException{
        UnicastRemoteObject.exportObject(this, 0);
        burgers = new Queue();
        users = new ArrayList<>();
    }

    @Override
    public void makeBurger( Burger burger) {
        burgers.enqueue(burger);
        System.out.println("Made burger, total: "+ burgers.size());
    }

    @Override
    public void getBurger(RemoteSender sender) throws RemoteException {
        System.out.println("customer is trying to take burger");
        sender.sendBurger(burgers.dequeue());
        System.out.println("Taking burger, total: " + burgers.size());
    }

    @Override
    public void closeStore(RemoteSender sender) {
        System.out.println("got info to close store");
        System.out.println(users.size());
        for (int i = 0; i < users.size(); i++) {
            try {
                users.get(i).replyMessage("Closing store");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Closing store");
    }

    @Override
    public void addPerson(RemoteSender sender) {
        if(!(users.contains(sender))){
            users.add(sender);
        }
    }

    @Override
    public int returnSize() {
        return 19;
    }
}
