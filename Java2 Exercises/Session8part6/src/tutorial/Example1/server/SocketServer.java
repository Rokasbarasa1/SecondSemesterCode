package tutorial.Example1.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) {
        ServerModel model = new ServerModel();
        try {
            ServerSocket welcomeSocket = new ServerSocket(3000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                ServerSocketHandler c = new ServerSocketHandler(connectionSocket, model);
                new Thread(c, "Chat user").start();
                System.out.println("Connected");
            }
       }catch (IOException e){
            e.printStackTrace();
        }
    }
}
