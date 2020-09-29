package Clients.Customer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class CustomerMain {
    public static void main(String[] args){
        CustomerRMIClient rmc;
        try {
            rmc = new CustomerRMIClient();
            rmc.getBurger();
        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
}
