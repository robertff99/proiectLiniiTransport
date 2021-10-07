package client;

import client.View.LoginGUI;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnection extends Thread {

    private final Socket socket;
    private final ObjectOutputStream output;
    private final ObjectInputStream input;
    private LoginGUI loginGUI = new LoginGUI();

    public ClientConnection(Socket socket) throws IOException {

        this.socket = socket;
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
    }

    @Override
    public void run() {
        try {
            while (socket.isConnected()) {
                // Seems that input.available() is not reliable?
                boolean serverHasData = socket.getInputStream().available() > 0;
                if (serverHasData) {
                    String msg = (String) input.readObject();

                    String[] s = msg.split(";");

                    switch (s[0]) {
                        case "rolLogin":
                            System.out.println(s[1]);
                            loginGUI.setRol(s[1]);
                            break;
                        case"updateAngajat":
                            System.out.println(s[1]);
                            break;
                        case"addAngajat":
                            System.out.println(s[1]);
                            break;
                        case"deleteAngajat":
                            System.out.println(s[1]);
                            break;
                        case"searchAngajat":
                            if(s[1].equals("angajatul nu exista")){
                                loginGUI.setScrollPane("Angajatul nu exista \n");
                            }
                            else
                            loginGUI.setScrollPane("Angajatul:"+s[1]+" cu parola "+s[2]+" exista \n");
                            break;
                        case"searchLinie":
                            loginGUI.setScrollPane("Linia:"+s[1]+" exista cu statia "+s[2]);
                            break;
                        case"addLinie":System.out.println(s[1]);
                            break;
                        case"deleteLinie":System.out.println(s[1]);
                            break;
                        case"updateLinie":
                            System.out.println(s[1]);
                            break;
                        case"afisareLinii":

                            loginGUI.setScrollPane(s[1]);
                            break;
                        case "searchLinieA":
                            loginGUI.setScrollPane("Linia:"+s[1]+" exista cu statia "+s[2]);
                            break;
                        default:
                            break;
                    }


                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToServer(String message) throws IOException {
        output.writeObject(message);
    }
}