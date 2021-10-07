package server.handler;

import server.Model.UtilizatorPersistenta;

import java.sql.SQLException;

public class LoginHandler {
    public LoginHandler(){}
    UtilizatorPersistenta u=new UtilizatorPersistenta();
public String rolLogin(String user,String parola) throws SQLException {
    return UtilizatorPersistenta.getRol(user,parola);
}
}
