package EXERCISE2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3000);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            String id =  (String) inFromServer.readObject();
            while (true) {
                outToServer.writeObject("hello from client number " + id);
                System.out.println((String) inFromServer.readObject());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
