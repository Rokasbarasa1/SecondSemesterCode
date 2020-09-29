package Exercise2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WaitingRoom room = new WaitingRoom(0);
        Patient person1 = new Patient(0, room);
        Patient person2 = new Patient(1, room);
        Patient person3 = new Patient(2, room);
        Patient person4 = new Patient(3, room);
        Patient person5 = new Patient(4, room);
        Patient person6 = new Patient(5, room);
        Patient person7 = new Patient(6, room);
        Patient person8 = new Patient(7, room);

        room.start();
    }
}
