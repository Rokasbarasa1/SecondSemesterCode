package Exercise1;

public class HelloWorld {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(1000);
        System.out.println("hello world");
        Thread.sleep(1000);
        System.out.println("hello world");
        Thread.sleep(1000);
        System.out.println("hello world");
        Thread.sleep(1000);
        System.out.println("hello world");
        Thread cat = new Thread(new MAn());
        Thread dog = new Thread(new Dog());

        dog.start();
        cat.start();
    }


}
