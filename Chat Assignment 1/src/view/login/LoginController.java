package view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import view.ViewHandler;
import viewmodel.LoginVM;

public class LoginController {

    @FXML
    TextField creatorTextField;

    private ViewHandler viewHandler;
    private LoginVM viewModel;

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        creatorTextField.textProperty().bindBidirectional(vm.creatorStringProperty());
    }

    public void onAddAction(ActionEvent actionEvent) {
        viewModel.addTask();
        viewModel.clear();
        viewHandler.openAllTasksView();
    }

    public void onBackAction(ActionEvent actionEvent) {
        viewModel.clear();
        viewHandler.openAllTasksView();
    }
}
