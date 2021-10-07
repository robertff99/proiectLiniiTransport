package client;

import java.io.*;
import java.net.Socket;

public class Client  {
    private static ClientConnection connection;

    public static void sendMsgToServer(String msg) {
        try {
            if(connection!=null) {
                connection.sendMessageToServer(msg);
            }
        } catch (IOException e) {
        }
    }



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        connection = new ClientConnection(new Socket("localhost", 3000));
        connection.start();
    }
}