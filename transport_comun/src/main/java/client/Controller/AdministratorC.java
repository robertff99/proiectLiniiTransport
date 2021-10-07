package client.Controller;



import client.ClientMessage;

import java.sql.SQLException;

public class AdministratorC {

    public AdministratorC(){}
    public void updateAngajat(String name,String newName) throws SQLException {
        ClientMessage.sendMsg("updateAngajat;"+name+";"+newName);
    }
    public String searchAngajat(String user) throws SQLException {
        return ClientMessage.sendMsg("searchAngajat;"+user);
    }
    public void deleteAngajat(String user) throws SQLException {
        ClientMessage.sendMsg("deleteAngajat;"+user);
    }
    public void addAngajat (String username,String parola) throws SQLException {
        ClientMessage.sendMsg("addAngajat;"+username+";"+parola);
    }
}