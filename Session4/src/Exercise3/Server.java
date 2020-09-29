package Exercise3;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            Counter count = new Counter();
            ServerSocket welcomeSocket = new ServerSocket(3000);
            while(true){
                Socket connectionSocket = welcomeSocket.accept();
                SocketHandler c = new SocketHandler(connectionSocket, count);
                new Thread(c, "comunication").start();
                System.out.println("Connected");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
