package server.Model;

import client.Controller.Connect;

import java.sql.*;


public class UtilizatorPersistenta {
    static Connection myConn=null;
LiniiTransportPersistenta liniiP;
    public UtilizatorPersistenta(){

    }
    public static void Conect(){
        {
            try {
                myConn = Connect.Connect1();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static String numeE=new String();

    public static String getRol(String user, String pass) throws SQLException {

        Connection c=null;
        {
            try {
                c = Connect.Connect1();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Statement myS = c.createStatement();
        String sql = "select * from transport.utilizator where username = '" + user + "' and parola = '"+ pass + "' ";
        String s= "invalid";
        try {
            ResultSet rs = myS.executeQuery(sql);
            while (rs.next()) {
                s = rs.getString("rol");
            }
        }catch (SQLException ex) {
            System.out.println("Invalid user or password");
        }

        return s;

    }


    public static Utilizator viewAngajat(String nume) throws SQLException{
        Conect();
        Statement myS = myConn.createStatement();
        String s= "SELECT * FROM transport.utilizator WHERE username = '"+ nume+ "' ";
        ResultSet rs = myS.executeQuery(s);
        String username= "";
        String password= "";
        String rol= "";

        while ( rs.next() ) {
            username = rs.getString("username");
            password = rs.getString("parola");
            rol = rs.getString("rol");
        }
        if("".equals(username))
        {
            return null;
        }
        else
        {
            return new Utilizator(username,password,rol
            );
        }
    }
    public static boolean updateAngajat(String user,String numeS) throws SQLException {
        Conect();

        String query = "update transport.utilizator set username = ? where username = ?";
        PreparedStatement preparedStmt = myConn.prepareStatement(query);

        preparedStmt.setString (2, user);
        preparedStmt.setString (1, numeS);


        preparedStmt.executeUpdate();

        return true;
    }
    public static void deleteAngajat(String nume) throws SQLException{
        Conect();

        String query = "DELETE FROM transport.utilizator WHERE username = '"+ nume+ "' ";
        PreparedStatement preparedStmt = myConn.prepareStatement(query);

        preparedStmt.executeUpdate();
    }
    public static void addAngajat(String nume,String parola) throws SQLException {
        Conect();

        String query = " insert into transport.utilizator (username, parola, rol)"
                + " values (?,?,?)";

        PreparedStatement preparedStmt = null;

        preparedStmt = myConn.prepareStatement(query);
        preparedStmt.setString (1, nume);
        preparedStmt.setString (2, parola);
        preparedStmt.setString (3, "angajat");
        // execute the preparedstatement
        preparedStmt.execute();


    }
}
