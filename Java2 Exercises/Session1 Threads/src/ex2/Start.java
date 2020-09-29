package ex2;
import  java.util.Scanner;
public class Start {
    public static void main(String[] args) {
        int num1, num2;
        Scanner key = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        num1 =key.nextInt();
        num2 =key.nextInt();
        Thread kaku = new Thread(new Klass(num1));
        Thread kaka = new Thread(new Glass(num2));

        kaku.start();
        kaka.start();

    }
}
