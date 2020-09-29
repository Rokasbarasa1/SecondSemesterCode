package Clients.Manager.viewmodel;


import Clients.Manager.model.ModelFactory;

public class ViewModelFactory {

    private ModelFactory modelFactory;
    private ManagerVM managerVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public ManagerVM getManagerVM() {
        if(managerVM == null) managerVM = new ManagerVM(modelFactory.getManagerModel());
        return managerVM;
    }
}
