package server.handler;

import server.Model.LiniiTransport;
import server.Model.LiniiTransportPersistenta;
import server.Model.Utilizator;

import java.io.IOException;
import java.sql.SQLException;

public class AngajatHandler {
    LiniiTransportPersistenta l=new LiniiTransportPersistenta();
    public AngajatHandler(){}
    public String searchLinie(int numarLinie) throws SQLException {
        LiniiTransport linie=l.viewLinie(numarLinie);
        String a=linie.getNrLinie()+";"+linie.getNumeStatie();
        return a;
    }
    public void addLinie (int l1,String l2) throws SQLException {
        System.out.println(l1+l2);
       l.addLinie(l1,l2);
    }
    public void deleteLinie(int numarLinie) throws SQLException {
        System.out.println(numarLinie);
        l.deleteLinie(numarLinie);
    }
    public void updateLinie(int l1,String numarLinieNew) throws SQLException {
        System.out.println(l1+numarLinieNew);
        l.updateLinie(l1,numarLinieNew);
    }
    public void genRaportCSV(String type,String path,String name) throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportJSON(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportTXT(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
    public void genRaportHTML(String type,String path,String name)throws IOException, SQLException {l.creareRaport(type,path,name);}
}
