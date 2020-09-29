package Exercise1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class User {
    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("About to do something");
        try {
            System.out.println("about to connect");
            Socket socket = new Socket("localhost", 2910);
            System.out.println("Connected");

            String command = null;
            while(true){
                ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());
                System.out.println("Type something");
                command = key.nextLine();
                outToServer.writeObject(command);
                String o = (String)inFromServer.readObject();
                System.out.println(o);
            }
            //System.out.println("Closing connection");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("FAiled");
            e.printStackTrace();
        }

    }
}
