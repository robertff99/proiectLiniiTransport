package client.Controller;

import client.ClientMessage;

import java.sql.SQLException;

public class LoginC {
    public LoginC(){}
public void rolLogin(String user,String parola) throws SQLException {
     ClientMessage.sendMsg("rolLogin;"+user+";"+parola);

}
}
