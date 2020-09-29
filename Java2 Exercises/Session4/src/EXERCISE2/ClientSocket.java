package EXERCISE2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocket implements Runnable {

    private Socket socket;

    public ClientSocket(Socket serverSocket){
        this.socket = serverSocket;
    }
    @Override
    //Was lazy and didnt do this one, bcs its the same shit as the server socket
    public void run() {
        try {
            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
            int randomNum = 1000 + (int)(Math.random() * 9999);
            outToClient.writeObject(randomNum + "");
            while(true){
                String message = (String) inFromClient.readObject();
                String[] dividedM = message.split("\\s+");
                Thread.sleep(1000);
                outToClient.writeObject("Hello to you too "+ dividedM[4]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
