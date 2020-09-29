package Clients.Manager.view;

import Clients.Manager.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler {

    private ViewModelFactory viewModelFactory;
    private Stage mainStage;
    private Scene managerScene;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        managerView();
        mainStage.show();
    }

    public void managerView() {
        FXMLLoader loader = new FXMLLoader();

        Parent root = getRootByPath("manager/managerview.fxml", loader);
        managerController controller = loader.getController();
        controller.init(viewModelFactory.getManagerVM(), this);
        managerScene = new Scene(root);

        mainStage.setTitle("Manager mode");
        mainStage.setScene(managerScene);
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
