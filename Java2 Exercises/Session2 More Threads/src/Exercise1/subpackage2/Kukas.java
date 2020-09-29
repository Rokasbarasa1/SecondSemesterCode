package Exercise1.subpackage2;

public class Kukas implements Runnable{
    private Counter counter;
    public Kukas(Counter counter){
        this.counter = counter;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            counter.inc();
        }
        System.out.println(counter.get());
    }
}
