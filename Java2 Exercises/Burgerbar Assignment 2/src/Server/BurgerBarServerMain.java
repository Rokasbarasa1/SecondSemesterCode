package Server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BurgerBarServerMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            RemoteCommandList server = new BurgerBarServer();
            registry.bind("msgList", server);
            System.out.println("Server started...");
        } catch (RemoteException | AlreadyBoundException e){
            e.printStackTrace();
        }
    }
}
