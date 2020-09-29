package Clients.Manager.view;

import Clients.Manager.view.ViewHandler;
import Clients.Manager.viewmodel.ManagerVM;

public class managerController {

    private ManagerVM viewModel;
    private ViewHandler viewHandler;

    public void init(ManagerVM vm, ViewHandler vh) {
        this.viewHandler = vh;
        this.viewModel = vm;
    }

    public void closeBar(javafx.event.ActionEvent event) {
        viewModel.closeBar();
    }
}
