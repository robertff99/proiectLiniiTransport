package server.handler;

import server.Model.Utilizator;
import server.Model.UtilizatorPersistenta;

import java.sql.SQLException;

public class AdministratorHandler {
    UtilizatorPersistenta u=new UtilizatorPersistenta();
    public AdministratorHandler(){}
    public void updateAngajat(String name,String newName) throws SQLException {
        System.out.println(name+newName);
        u.updateAngajat(name,newName);
    }
    public String searchAngajat(String user) throws SQLException {
        System.out.println(user);
        Utilizator angajat=u.viewAngajat(user);
        String a="";
        if(angajat!=null)
        a=angajat.getUsername()+";"+angajat.getParola();
        else
            a="angajatul nu exista";
        return a;
    }
    public void deleteAngajat(String user) throws SQLException {
        System.out.println(user);
        u.deleteAngajat(user);
    }
    public void addAngajat (String username,String parola) throws SQLException {
        System.out.println(username+parola);
        u.addAngajat(username,parola);
    }
}