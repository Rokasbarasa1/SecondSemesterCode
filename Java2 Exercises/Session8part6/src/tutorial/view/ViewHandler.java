package tutorial.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tutorial.view.addtask.AddTaskController;
import tutorial.view.alltasks.AllTasksController;
import tutorial.viewmodel.ViewModelFactory;

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
        //openAddTaskView();
        mainStage.show();
    }

    public void openAllTasksView() {
        FXMLLoader loader = new FXMLLoader();

        if(allTasksScene == null) {
            Parent root = getRootByPath("alltasks/AllTasksView.fxml", loader);
            AllTasksController controller = loader.getController();
            controller.init(viewModelFactory.getAllTasksVM(), this);
            allTasksScene = new Scene(root);
        }

        mainStage.setTitle("View tasks");
        mainStage.setScene(allTasksScene);

    }

    public void openAddTaskView() {
        FXMLLoader loader = new FXMLLoader();

        if(addTaskScene == null) {
            Parent root = getRootByPath("addtask/AddTaskView.fxml", loader);
            AddTaskController controller = loader.getController();
            controller.init(viewModelFactory.getAddTaskVM(), this);
            addTaskScene = new Scene(root);
        }

        mainStage.setTitle("Add task");
        mainStage.setScene(addTaskScene);
    }

    public void openGetNextTaskView() {

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
