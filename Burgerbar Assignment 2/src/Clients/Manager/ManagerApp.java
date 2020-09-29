package Clients.Manager;

import Clients.Manager.Networking.Manager;
import Clients.Manager.Networking.ManagerClient;
import Clients.Manager.model.ModelFactory;
import Clients.Manager.view.ViewHandler;
import Clients.Manager.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ManagerApp extends Application {
    @Override
    public void start(Stage stage) {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory vmf = new ViewModelFactory(mf);
        ViewHandler vh = new ViewHandler(stage, vmf);
        Manager cl = new ManagerClient(mf.getManagerModel());
        vh.start();
    }
}