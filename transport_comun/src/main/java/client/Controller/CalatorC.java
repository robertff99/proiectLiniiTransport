package client.Controller;

import client.ClientMessage;
import server.Model.LiniiTransport;
import server.Model.LiniiTransportPersistenta;

import java.sql.SQLException;
import java.util.ArrayList;

public class CalatorC {
    LiniiTransportPersistenta l=new LiniiTransportPersistenta();
public CalatorC(){}
    public ArrayList<LiniiTransport> afisareLinii() throws SQLException {
          ClientMessage.sendMsg("afisareLinii;");
           ArrayList<LiniiTransport> l= new ArrayList<LiniiTransport>();
           return  l;
    }
    public LiniiTransport searchLinieA(int numarLinie) throws SQLException {
        ClientMessage.sendMsg("searchLinieA;"+numarLinie);
        LiniiTransport l= null;
        return l;
    }
}
