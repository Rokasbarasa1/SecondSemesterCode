package Clients.Manager.viewmodel;

import Clients.Manager.model.ManagerModel;

public class ManagerVM {

    private ManagerModel model;

    public ManagerVM(ManagerModel model) {
        this.model = model;
    }

    public void closeBar(){
        model.closeBar();
    }
}
