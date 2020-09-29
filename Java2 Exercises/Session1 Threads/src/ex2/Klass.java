package ex2;

public class Klass implements Runnable {

    private int reps;

    public Klass(int num){
        this.reps = num;
    }
    @Override
    public void run() {
        for (int i = 0; i < reps; i++) {
            System.out.println("Hey");
        }
    }
}
