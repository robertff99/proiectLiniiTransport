package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try (ServerSocket socket = new ServerSocket(3000)) {
            while (true) {
                Socket clientSocket = socket.accept();
                ServerConnection s=  new ServerConnection(clientSocket);
                s.start();

            }
        }
    }

}