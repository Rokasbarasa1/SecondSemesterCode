package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ChatModel;

public class LoginVM {

    private StringProperty creator;
    private ChatModel model;

    public LoginVM(ChatModel model) {
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
