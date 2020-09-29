package Clients.Manager.model;

import Clients.Manager.Networking.ManagerClient;
import java.beans.PropertyChangeSupport;

public class ManagerModelManager implements ManagerModel {
    private ManagerClient client;

    @Override
    public void closeBar() {
        client.closeStore();
    }

    @Override
    public void setClient(ManagerClient client) {
        this.client = client;
    }
}
