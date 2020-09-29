package tutorial.Example1.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteMessageServerMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            RemoteMessageList server = new RemoteMessageServer();
            registry.bind("msgList", server);

            System.out.println("Server started...");
        } catch (RemoteException | AlreadyBoundException e){
            e.printStackTrace();
        }
    }
}
