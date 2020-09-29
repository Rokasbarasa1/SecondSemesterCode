package tutorial.Example2.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain {
    public static void main(String[] args) {
        RmiCallBackClient rmc = null;
        try {
            rmc = new RmiCallBackClient();
        } catch (RemoteException | NotBoundException e){
            e.printStackTrace();
        }

        rmc.addMessageToServer("hello");
        rmc.addMessageToServer("testing");
        rmc.addMessageToServer("1,2,3");
    }
}
