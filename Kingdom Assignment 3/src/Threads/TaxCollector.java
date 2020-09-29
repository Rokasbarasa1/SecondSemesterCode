package Threads;

import ReadWrite.WritersPreferanceReadWrite;
import TressureRoom.ValuableFactory;
import TressureRoom.Valuables.Valuable;
import logging.Logger;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class TaxCollector implements Runnable {
    private WritersPreferanceReadWrite readWrite;
    private int limit;

    public TaxCollector(WritersPreferanceReadWrite readWrite){
        this.readWrite = readWrite;
        this.limit = ThreadLocalRandom.current().nextInt(50, 200 + 1);
    }
    @Override
    public void run() {
        try {
            String[] valuableTypes = {"Cow", "Diamond", "GoldCoin", "Jewel", "Ruby", "WoodenCoin"};
            ArrayList<Valuable> pouch = new ArrayList<>();
            while (true){
                int valueOfPouch = 0;
                for (int i = 0; i < pouch.size(); i++) {
                    valueOfPouch += pouch.get(i).getValue();
                }
                if(valueOfPouch >= limit){
                    readWrite.acquireWrite();
                    int size = pouch.size();
                    for (int i = 0; i < size; i++) {
                        Thread.sleep(500);
                        readWrite.doWrite().addValue(pouch.remove(0));
                    }
                    readWrite.releaseWrite();
                    Logger.getInstance().log("Tax collector collected: " + valueOfPouch + " . He will now rest");
                    Thread.sleep(10000);
                    limit = ThreadLocalRandom.current().nextInt(50, 200 + 1);
                    continue;
                }
                int randomIndex = ThreadLocalRandom.current().nextInt(0, 5 + 1);
                Valuable possesion = ValuableFactory.getValuable(valuableTypes[randomIndex]);
                pouch.add(possesion);
                Thread.sleep(50);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
