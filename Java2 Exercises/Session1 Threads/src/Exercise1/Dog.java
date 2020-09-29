package Exercise1;

public class Dog implements Runnable {
    public Dog(){
    }

    @Override
    public void run(){
        for (int i = 0; i < 25; i++) {
            System.out.println((char) (i+97));
        }
    }
}
