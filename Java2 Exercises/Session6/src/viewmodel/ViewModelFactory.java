package viewmodel;

import model.ModelFactory;
import viewmodel.piechart.PieChartViewModel;

public class ViewModelFactory {

    private PieChartViewModel pieChartViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        pieChartViewModel = new PieChartViewModel(modelFactory.getDataModel());
    }

    public PieChartViewModel getPieChartViewModel() {
        return pieChartViewModel;
    }

}
