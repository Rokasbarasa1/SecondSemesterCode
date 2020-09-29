package Exercise3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            Scanner key = new Scanner(System.in);
            System.out.println("Enter number");
            while (true){
                int number = key.nextInt();
                outToServer.writeObject("add " + number);
                System.out.println((String) inFromServer.readObject());
                System.out.println((String) inFromServer.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
