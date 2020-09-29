package Threads;

import ReadWrite.WritersPreferanceReadWrite;
import TressureRoom.Valuables.Valuable;
import logging.Logger;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class King implements Runnable {
    private int nextPartyPrice;
    private WritersPreferanceReadWrite readWrite;
    private ArrayList<Valuable> partyBudgetValuables;

    public King(WritersPreferanceReadWrite readWrite){
        this.nextPartyPrice = ThreadLocalRandom.current().nextInt(50, 200 + 1);
        this.readWrite = readWrite;
        this.partyBudgetValuables = new ArrayList<>(10);
    }

    @Override
    public void run() {
        try {
            while (true){
                readWrite.acquireWrite();
                int budgetValue = 0;
                while (true){
                    if(readWrite.doWrite().size() == 0 && budgetValue < nextPartyPrice || budgetValue >= nextPartyPrice){
                        break;
                    }
                    Thread.sleep(1000);
                    partyBudgetValuables.add(readWrite.doWrite().removeValuable(0));
                    for (int i = 0; i < partyBudgetValuables.size(); i++) {
                        budgetValue += partyBudgetValuables.get(i).getValue();
                    }
                }
                if(budgetValue > nextPartyPrice){
                    Logger.getInstance().log("King has declared a party with the budget of " + budgetValue);
                    readWrite.releaseWrite();
                    Thread.sleep(30000);
                    partyBudgetValuables = new ArrayList<>();
                    this.nextPartyPrice = ThreadLocalRandom.current().nextInt(50, 200 + 1);
                } else if(readWrite.doWrite().size() == 0 || budgetValue < nextPartyPrice){
                    int size = partyBudgetValuables.size();
                    for (int i = 0; i < size; i++) {
                        readWrite.doWrite().addValue(partyBudgetValuables.remove(0));
                    }
                    Logger.getInstance().log("Kings party is canceled");
                    readWrite.releaseWrite();
                    Thread.sleep(30000);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
