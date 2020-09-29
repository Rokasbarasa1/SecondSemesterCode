package tutorial.viewmodel;

import tutorial.model.ModelFactory;

public class ViewModelFactory {

    private AllTasksVM allTasksVM;

    private ModelFactory modelFactory;
    private AddTaskVM addTaskVM;

    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public AllTasksVM getAllTasksVM() {
        if(allTasksVM == null) allTasksVM = new AllTasksVM(modelFactory.getTaskModel());
        return allTasksVM;
    }

    public AddTaskVM getAddTaskVM() {
        if(addTaskVM == null) addTaskVM = new AddTaskVM(modelFactory.getTaskModel());
        return addTaskVM;
    }
}
