package Exercise1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {

            Socket socket = new Socket("localhost", 2910);
            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
            while(true){
                outToServer.writeObject("Hello");
                System.out.println((String) inFromServer.readObject());
                System.out.println("Closing connection");
            }

        } catch (IOException | ClassNotFoundException e){
            System.out.println("something wong");
            e.printStackTrace();
        }
    }
}
