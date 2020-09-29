package Exercise3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable{

    private Counter counter;
    private Socket socket;

    public SocketHandler(Socket serverSocket, Counter counter){
        this.counter = counter;
        this.socket = serverSocket;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
            while(true){
                String command = (String) inFromClient.readObject();
                outToClient.writeObject("Current counter value: " + counter.get());
                String[] divided = command.split("\\s+");
                if(!(divided[1].equals("")))
                    for (int i = 0; i < Integer.parseInt(divided[1]); i++) {
                        counter.inc();
                    }
                outToClient.writeObject("Current counter value after: " + counter.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
