package model;

public interface Model {
    double[] getDataValues();

    String getLastUpdateTimeStamp();

    void saveData(double x, double y, double z);
}
