import ReadWrite.WritersPreferanceReadWrite;
import Threads.Accountant;
import Threads.King;
import Threads.TaxCollector;
import TressureRoom.TreasureRoom;

public class KingdomMain {
    public static void main(String[] args) {
        TreasureRoom room = new TreasureRoom();
        WritersPreferanceReadWrite readWrite = new WritersPreferanceReadWrite(room);

        King king = new King(readWrite);

        TaxCollector collector  = new TaxCollector(readWrite);
        TaxCollector collector1 = new TaxCollector(readWrite);
        TaxCollector collector2 = new TaxCollector(readWrite);

        Accountant accountant = new Accountant(readWrite);
        Accountant accountant1 = new Accountant(readWrite);
        Accountant accountant2 = new Accountant(readWrite);
        Accountant accountant3 = new Accountant(readWrite);
        Accountant accountant4 = new Accountant(readWrite);
        Accountant accountant5 = new Accountant(readWrite);
        Accountant accountant6 = new Accountant(readWrite);
        Accountant accountant7 = new Accountant(readWrite);


        Thread k = new Thread(king);
        Thread c = new Thread(collector);
        Thread c1 = new Thread(collector1);
        Thread c2 = new Thread(collector2);
        Thread a = new Thread(accountant);
        Thread a1 = new Thread(accountant1);
        Thread a2 = new Thread(accountant2);
        Thread a3 = new Thread(accountant3);
        Thread a4 = new Thread(accountant4);
        Thread a5 = new Thread(accountant5);
        Thread a6 = new Thread(accountant6);
        Thread a7 = new Thread(accountant7);

        k.start();
        c.start();
        c1.start();
        c2.start();
        a.start();
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
        a6.start();
        a7.start();
    }
}
