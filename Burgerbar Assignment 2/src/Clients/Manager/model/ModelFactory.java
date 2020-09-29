package Clients.Manager.model;

public class ModelFactory {

    private ManagerModel managerModel;

    public ManagerModel getManagerModel() {
        if(managerModel == null)
            managerModel = new ManagerModelManager();
        return managerModel;
    }
}
