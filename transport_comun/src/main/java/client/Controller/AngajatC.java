package client.Controller;


import client.ClientMessage;
import server.Model.LiniiTransportPersistenta;

import java.io.IOException;
import java.sql.SQLException;

public class AngajatC {
    LiniiTransportPersistenta l=new LiniiTransportPersistenta();
    public AngajatC(){}
    public String searchLinie(int numarLinie) throws SQLException {
        return ClientMessage.sendMsg("searchLinie;"+numarLinie);
    }
    public void addLinie (int l1,String l2) throws SQLException {
         ClientMessage.sendMsg("addLinie;"+l1+";"+l2);
    }
    public void deleteLinie(int numarLinie) throws SQLException {
        ClientMessage.sendMsg("deleteLinie;"+numarLinie);;
    }
    public void updateLinie(int l1,String numarLinieNew) throws SQLException {
        ClientMessage.sendMsg("updateLinie;"+l1+";"+numarLinieNew);
    }
    public void genRaportCSV(String type,String path,String name) throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportJSON(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportTXT(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportHTML(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
}
