package Exercise1.subpackage2;

public class Start {
    public static void main(String[] args) {

        Counter count = new Counter();
        Counter count1 = new Counter();
        Thread one = new Thread(new Kukas(count));
        Thread two = new Thread(new Kukas(count1));
        Thread tree = new Thread(new Kukas(count));
        Thread four = new Thread(new Kukas(count1));

        one.start();
        two.start();
        tree.start();
        four.start();
    }
}
