package tutorial;

import javafx.application.Application;
import javafx.stage.Stage;
import tutorial.Example1.client.SocketClient;
import tutorial.model.ModelFactory;
import tutorial.view.ViewHandler;
import tutorial.viewmodel.ViewModelFactory;

public class TaskListApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        SocketClient cl = new SocketClient(mf.getTaskModel());
        vh.start();

    }
}
