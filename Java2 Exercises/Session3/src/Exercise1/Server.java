package Exercise1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        //Run both user and server
        //clinent mus type something
        System.out.println("Starting server");
        try{
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while(true) {
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");

                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                String o = (String) inFromClient.readObject();
                System.out.println("Recieved " + o);

                String answer = o.toUpperCase();

                ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
                outToClient.writeObject(answer);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("lost connection");
            e.printStackTrace();
        }
    }
}
