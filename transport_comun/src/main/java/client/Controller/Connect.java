package client.Controller;

import java.sql.*;

public class Connect{

    public static Connection Connect1() throws SQLException {
        String url ="jdbc:mysql://localhost:3306/transport";
        String user="root";
        String password="root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Connection myConn=DriverManager.getConnection(url, user, password);

        return myConn;

    }
}