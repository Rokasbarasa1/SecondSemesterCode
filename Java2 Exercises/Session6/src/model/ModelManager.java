package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ModelManager implements Model {

    private double x;
    private double y;
    private double z;
    private String lastUpdate;

    private Random random = new Random();

    @Override
    public double[] getDataValues() {
        return new double[]{x, y, z};
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void saveData(double x, double y, double z) {

    }

    public void recalculateData() {
        int first = random.nextInt(100)+1;
        int second = random.nextInt(100)+1;
        int bottom = Math.min(first, second);
        int top = Math.max(first, second);

        x = bottom;
        y = top - bottom;
        z = 100 - top;
        calTimeStamp();
    }

    private void calTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }

    p
}
