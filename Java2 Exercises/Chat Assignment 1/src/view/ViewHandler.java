package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.login.LoginController;
import view.chat.ChatController;
import viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;

    private Scene allTasksScene;
    private Scene addTaskScene;
    private Scene nextTaskScene;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openAllTasksView();
        mainStage.show();
    }

    public void openAllTasksView() {
        FXMLLoader loader = new FXMLLoader();

        if(allTasksScene == null) {
            Parent root = getRootByPath("chat/ChatView.fxml", loader);
            ChatController controller = loader.getController();
            controller.init(viewModelFactory.getChatVM(), this);
            allTasksScene = new Scene(root);
        }
        mainStage.setTitle("Chat");
        mainStage.setScene(allTasksScene);
    }

    public void openAddTaskView() {
        FXMLLoader loader = new FXMLLoader();

        if(addTaskScene == null) {
            Parent root = getRootByPath("login/LoginView.fxml", loader);
            LoginController controller = loader.getController();
            controller.init(viewModelFactory.getLoginVM(), this);
            addTaskScene = new Scene(root);
        }

        mainStage.setTitle("Login");
        mainStage.setScene(addTaskScene);
    }

    private Parent getRootByPath(String path, FXMLLoader loader) {
        loader.setLocation(getClass().getResource(path));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return root;
    }
}
