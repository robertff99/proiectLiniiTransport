package server;

import server.Model.LiniiTransport;
import server.handler.AdministratorHandler;
import server.handler.AngajatHandler;
import server.handler.CalatorHandler;
import server.handler.LoginHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class ServerConnection extends Thread{

    private final Socket clientSocket;

    private LoginHandler loginHandler=new LoginHandler();
    private AdministratorHandler adminHandler=new AdministratorHandler();
    private CalatorHandler calatorHandler=new CalatorHandler();
    private AngajatHandler angajatHandler=new AngajatHandler();

    public ServerConnection(Socket clientSocket) {
        this.clientSocket = clientSocket;

    }
    ObjectOutputStream output;
    ObjectInputStream input;

    @Override
    public void run()
    {

        try
        {   output = new ObjectOutputStream(clientSocket.getOutputStream());
            input = new ObjectInputStream(clientSocket.getInputStream());

            while (clientSocket.isConnected())
            {
                boolean clientHasData = clientSocket.getInputStream().available() > 0;
                if (clientHasData) {
                    String msg = (String) input.readObject();

                    String [] s= msg.split(";");
                    System.out.println(s[0]);
                    switch (s[0]) {
                        case "rolLogin":
                           String rol= loginHandler.rolLogin(s[1],s[2]);
                           output.writeObject("rolLogin;"+rol);
                            break;
                        case"updateAngajat":
                            adminHandler.updateAngajat(s[1],s[2]);
                            output.writeObject("updateAnagajat;Succes");
                            break;
                        case"addAngajat":
                            adminHandler.addAngajat(s[1],s[2]);
                            output.writeObject("addAnagajat;Succes");
                            break;
                        case"deleteAngajat":
                            adminHandler.deleteAngajat(s[1]);
                            output.writeObject("deleteAngajat;Succes");
                            break;
                        case"searchAngajat":
                            String sA=adminHandler.searchAngajat(s[1]);
                            output.writeObject("searchAngajat;"+sA);
                            break;
                        case"searchLinie":
                            String sL=angajatHandler.searchLinie(Integer.parseInt(s[1]));
                            output.writeObject("searchLinie;"+sL);
                            break;
                        case"addLinie":angajatHandler.addLinie(Integer.parseInt(s[1]),s[2]);
                            output.writeObject("addLinie;Succes");
                            break;
                        case"deleteLinie":angajatHandler.deleteLinie(Integer.parseInt(s[1]));
                            output.writeObject("deleteLinie;Succes");
                            break;
                        case"updateLinie":
                            angajatHandler.updateLinie(Integer.parseInt(s[1]),s[2]);
                            output.writeObject("updateLinie;Succes");
                            break;
                        case"afisareLinii":
                            String linii=calatorHandler.afisareLinii();
                            output.writeObject("afisareLinii;"+linii);
                            break;
                        case"searchLinieA":
                            String sL2=calatorHandler.searchLinie(Integer.parseInt(s[1]));
                            output.writeObject("searchLinieA;"+sL2);
break;
                        default:
                            break;
                    }

                }

                try
                {
                    Thread.sleep(500);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
        catch (IOException | ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        // cleanup
        try
        {
            clientSocket.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /*@Override
    public void update(String name) {
        try {
            output.writeObject("notify; " + name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}