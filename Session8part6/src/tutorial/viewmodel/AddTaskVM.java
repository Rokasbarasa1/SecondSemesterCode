package tutorial.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tutorial.model.TaskModel;

public class AddTaskVM {

    private StringProperty creator;
    private TaskModel model;

    public AddTaskVM(TaskModel model) {
        creator = new SimpleStringProperty();
        this.model = model;
    }

    public void addTask() {
        model.addTask(creator.getValue());
    }

    public StringProperty creatorStringProperty() {
        return creator;
    }

    public void clear() {
        creator.setValue("");
    }
}
