package ex2;
import java.util.Scanner;
public class Glass implements Runnable{

    private int reps;

    public Glass(int num){
        this.reps = num;
    }
    @Override
    public void run() {
        for (int i = 0; i < reps; i++) {
            System.out.println("Hi");
        }
    }
}
