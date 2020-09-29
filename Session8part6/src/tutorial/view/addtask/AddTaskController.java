package tutorial.view.addtask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tutorial.view.ViewHandler;
import tutorial.viewmodel.AddTaskVM;

public class AddTaskController {

    @FXML
    TextField creatorTextField;

    private ViewHandler viewHandler;
    private AddTaskVM viewModel;

    public void init(AddTaskVM vm, ViewHandler vh) {
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
