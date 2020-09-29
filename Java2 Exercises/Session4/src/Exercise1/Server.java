package Exercise1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket welcomeSocket = new ServerSocket(2910);
            while(true) {
                Socket connectionSocket = welcomeSocket.accept();
                ServerConnection c = new ServerConnection(connectionSocket);
                new Thread(c, "Communication").start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
