package ReadWrite;

import TressureRoom.TreasureRoom;

public class WritersPreferanceReadWrite implements ReadWrite {
    private int readers;
    private boolean isWriting;
    private int waitingWriters;

    private TreasureRoom sharedData;

    public WritersPreferanceReadWrite(TreasureRoom room){
        readers = waitingWriters = 0;
        isWriting = false;
        this.sharedData = room;
    }


    @Override
    public synchronized void acquireRead() {
        while (isWriting || waitingWriters > 0){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        readers++;
    }
    @Override
    public synchronized void releaseRead() {
        readers--;
        if(readers == 0){
            notifyAll();
        }
    }
    @Override
    public synchronized void acquireWrite() {
        waitingWriters++;
        while (readers > 0 || isWriting){
            try {
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        waitingWriters--;
        isWriting = true;
    }
    @Override
    public synchronized void releaseWrite() {
        isWriting = false;
        notifyAll();
    }

    public synchronized TreasureRoom doWrite(){
        return sharedData;
    }

    public synchronized int doRead(int index){
        return sharedData.getValuable(index).getValue();
    }
}
