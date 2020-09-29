package model;

public class ModelFactory {

    private Model dataModel;

    public Model getDataModel() {
        if(dataModel == null) {
            dataModel = new ModelManager();
        }
        return dataModel;
    }

}
