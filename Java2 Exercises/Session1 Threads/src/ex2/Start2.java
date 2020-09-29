package ex2;

public class Start2 {
    public static void main(String[] args) {
        Counter c = new Counter();
        Thread t = new Thread(new CountIncrementer(c));
        Thread u = new Thread(new CountIncrementer(c));
        t.start();
        u.start();
    }
}
