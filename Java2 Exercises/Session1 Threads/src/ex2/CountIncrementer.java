package ex2;

public class CountIncrementer implements Runnable{

    private Counter cunt;

    public CountIncrementer(Counter cunt){
        this.cunt = cunt;
    }
    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            cunt.addOneA();
            cunt.addOneB();
        }
        System.out.println(cunt.getCountA());
        System.out.println(cunt.getCountB());

    }
}
