package Exercise1;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerConnection implements Runnable {

    private Socket socket;

    public ServerConnection(Socket serverSocket){
        this.socket = serverSocket;
    };

    @Override
    public void run() {
        try{
            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

            while(true){
                System.out.println("works");
                //Message message = (Message) inFromClient.readObject();
                String o = (String) inFromClient.readObject();
                System.out.println("Message from Client: " + o);
                System.out.println(o);
                String u = o.toUpperCase();
                System.out.println(u);
                Thread.sleep(1000);
                outToClient.writeObject(u);
            }
        } catch (Exception e) {
            System.out.println("Doestn work");
        }
    }
}
