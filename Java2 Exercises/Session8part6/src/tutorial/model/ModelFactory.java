package tutorial.model;

public class ModelFactory {

    private TaskModel taskModel;

    public TaskModel getTaskModel() {
        if(taskModel == null)
            taskModel = new TaskModelManager();
        return taskModel;
    }
}
