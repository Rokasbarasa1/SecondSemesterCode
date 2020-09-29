package Clients.Chef;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ChefMain {
    public static void main(String[] args) {
        ChefRMIClient rmc;
        try {
            rmc = new ChefRMIClient();
            rmc.makeBurger();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
