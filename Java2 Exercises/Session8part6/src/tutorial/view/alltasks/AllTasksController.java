package tutorial.view.alltasks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import tutorial.shared.Task;
import tutorial.view.ViewHandler;
import tutorial.viewmodel.AllTasksVM;

public class AllTasksController {

    @FXML
    private TableView<Task> tableView;
    @FXML
    private TableColumn<String, Task> creatorColumn;
    @FXML
    private TextArea chatForUser;
    @FXML
    private TextField message;
    @FXML
    private Label friendName;
    @FXML
    private Label username;

    private AllTasksVM  viewModel;
    private ViewHandler viewHandler;

    public void init(AllTasksVM vm, ViewHandler vh) {
        this.viewHandler = vh;
        this.viewModel = vm;
        username.textProperty().bindBidirectional(viewModel.usernameStringProperty());
        chatForUser.textProperty().bindBidirectional(viewModel.chatStringProperty());
        creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
        tableView.setItems(vm.getTaskList());
    }

    @FXML
    void changeChat(ActionEvent event) {
        Task newChat = this.tableView.getSelectionModel().getSelectedItem();
        viewModel.changeChat(newChat);
        friendName.setText(viewModel.getFriendName());
    }

    @FXML
    void onAddButton(ActionEvent event) {
        viewModel.reLog();
        viewHandler.openAddTaskView();
    }

    @FXML
    void sendText(ActionEvent event) {
        if(!(message.getText().equals(""))){
            viewModel.sendMessage(message.getText());
            message.clear();
        }
    }
}
