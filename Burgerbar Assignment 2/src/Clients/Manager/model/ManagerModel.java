package Clients.Manager.model;

import Clients.Manager.Networking.ManagerClient;


public interface ManagerModel {
    void closeBar();
    void setClient(ManagerClient client);
}
