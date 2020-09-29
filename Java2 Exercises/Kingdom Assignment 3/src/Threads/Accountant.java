package Threads;

import ReadWrite.WritersPreferanceReadWrite;
import logging.Logger;

public class Accountant implements Runnable{
    private WritersPreferanceReadWrite readWrite;

    public Accountant(WritersPreferanceReadWrite readWrite){
        this.readWrite = readWrite;
    }
    @Override
    public void run() {
        try {
            while (true){
                readWrite.acquireRead();
                int valueOfRoom = 0;
                if(readWrite.doWrite().size() > 0){
                    for (int i = 0; i < readWrite.doWrite().size(); i++) {
                        Thread.sleep(250);
                        valueOfRoom += readWrite.doRead(i);
                    }
                    Logger.getInstance().log("Accountant counted the value of the treassure room, it is " + valueOfRoom);
                }else{
                    Logger.getInstance().log("Room empty, nothing to count");
                }
                readWrite.releaseRead();
                Thread.sleep(10000);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
