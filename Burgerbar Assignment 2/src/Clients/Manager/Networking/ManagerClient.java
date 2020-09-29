package Clients.Manager.Networking;

import Clients.Manager.model.ManagerModel;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ManagerClient implements Manager{
    private ManagerRMIClient rmc;

    public ManagerClient(ManagerModel model) {
        model.setClient(this);
        try {
            rmc = new ManagerRMIClient();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void closeStore() {
        try {
            rmc.closeStore();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
