package Exercise1;

import javax.xml.transform.sax.SAXSource;
import java.sql.SQLOutput;

public class MAn implements Runnable{

    private Thread t1;


    @Override
    public void run(){

        try{
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("i");
        }
    }
}
