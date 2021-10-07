package server.Model;

import client.Controller.Connect;
import client.Raport.Report;
import client.Raport.ReportConcreteCreator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LiniiTransportPersistenta {


    static Connection myConn=null;

    public static void Conect(){
        {
            try {
                myConn = Connect.Connect1();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addLinie(int l1,String l2) throws SQLException {
        Conect();

        String query = " insert into transport.liniitransport (numarLinie,numeLinie)"
                + " values (?,?)";

        PreparedStatement preparedStmt = null;

        preparedStmt = myConn.prepareStatement(query);
        preparedStmt.setInt (1, l1);
        preparedStmt.setString (2,l2 );
        // execute the preparedstatement
        preparedStmt.execute();


    }

    public static boolean updateLinie(int numarLinie,String numeS) throws SQLException {
        Conect();

        String query = "update transport.liniitransport set numeLinie = ?  where numarLinie = ?";
        PreparedStatement preparedStmt = myConn.prepareStatement(query);

        preparedStmt.setInt (2, numarLinie);
        preparedStmt.setString (1, numeS);

        preparedStmt.executeUpdate();

        return true;
    }

    public static LiniiTransport viewLinie(int numar) throws SQLException{
        Conect();
        Statement myS = myConn.createStatement();
        String s= "SELECT * FROM transport.liniitransport WHERE numarLinie = "+ numar;
        ResultSet rs = myS.executeQuery(s);
        int numarLinie=0;
        String numeLinie= "";


        while ( rs.next() ) {
            numeLinie=rs.getString("numeLinie");
            numarLinie=rs.getInt("numarLinie");
        }
        if("".equals(numeLinie))
        {
            return null;
        }
        else
        {
            return new LiniiTransport(numeLinie,numarLinie);
        }
    }

    public static void deleteLinie(int numar) throws SQLException{
        Conect();

        String query = "DELETE FROM transport.liniitransport WHERE numarLinie = '"+ numar+ "' ";
        PreparedStatement preparedStmt = myConn.prepareStatement(query);

        preparedStmt.executeUpdate();
    }
    public static List<LiniiTransport> viewLinii() throws SQLException {
        Conect();
        List<LiniiTransport> listaNoua=new ArrayList<LiniiTransport>();
        Statement myS = myConn.createStatement();
        String s= "SELECT * FROM transport.liniitransport";
        ResultSet rs = myS.executeQuery(s);

        while ( rs.next() ) {
            System.out.println(rs.getString("numeLinie"));
            LiniiTransport linieInter=new LiniiTransport();

            linieInter.setNumeStatie(rs.getString("numeLinie"));
            linieInter.setNrLinie(rs.getInt("numarLinie"));
            listaNoua.add(linieInter);
        }
        return listaNoua;
    }
    public void creareRaport(String type, String path, String numeFisier) throws IOException, SQLException {
        Report report= ReportConcreteCreator.factoryMethod(type);
        File myFile=report.createReport(path,numeFisier);
        FileWriter myWriter = new FileWriter(myFile);
        Conect();
        List<LiniiTransport> listaNoua=new ArrayList<LiniiTransport>();
        Statement myS = myConn.createStatement();
        String s= "SELECT * FROM transport.liniitransport";
        ResultSet rs = myS.executeQuery(s);

        while ( rs.next() ) {
            System.out.println(rs.getString("numeLinie"));
            LiniiTransport linieInter=new LiniiTransport();

            linieInter.setNumeStatie(rs.getString("numeLinie"));
            linieInter.setNrLinie(rs.getInt("numarLinie"));
            listaNoua.add(linieInter);
        }
        if (listaNoua.isEmpty())
        {
            System.out.println("BD goala");
        }
        else
        {
            for (LiniiTransport l:listaNoua)
            {
                myWriter.write(l.toString());
                myWriter.write('\n');
            }
        }
        myWriter.close();
    }
    public static int liniiOptime(LiniiTransport linie) {
        return 0;
    }
}
