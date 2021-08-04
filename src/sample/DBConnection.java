package sample;

import java.sql.*;

public class DBConnection{

    static  final String url = "jdbc:mysql://127.0.0.1:3306/hospital";
    static  final String user = "root";
    static  final String pass = "password";


    public static Connection connector() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Connecting to Database...");
            Connection connect = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection Successful!");
            return connect;
        }
        catch(Exception e) {
            System.out.println("Connection Failed!");
            System.out.println(e);
            return null;
        }
    }
}  