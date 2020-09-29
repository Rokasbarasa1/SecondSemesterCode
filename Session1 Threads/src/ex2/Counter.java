package ex2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private int countA;
    private int countB;

    private Lock assA = new ReentrantLock();
    private Lock assB = new ReentrantLock();
    public Counter(){
        this.countA = 0;
        this.countB = 0;

    }

    public  void addOneB(){
        synchronized (assB) {
            countB++;
        }
    }

    public  int getCountB(){
        synchronized (assB){
            return countB;
        }
    }

    public  void addOneA(){
        synchronized (assA){
            countA++;
        }
    }

    public  int getCountA(){
        synchronized (assA){
            return countA;
        }
    }
    //Example of try lock, not integrated
    /*
    private Lock lock = new ReentrantLock();
    public void inc(){
        if(lock.trylock()){
            count++;
            lock.unlock();
        } else {
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e){
                
            }
        }
    }
     */
}
