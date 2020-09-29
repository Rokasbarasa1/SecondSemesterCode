package Exercise3;

public class Counter  {
    private int counter = 0;
    public synchronized void inc(){
        counter++;
    }
    public synchronized int get(){
        return counter;
    }
}
