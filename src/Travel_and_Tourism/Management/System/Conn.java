package Travel_and_Tourism.Management.System;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn() throws Exception{
        //loading
        Class.forName("com.mysql.cj.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", "root");
        
        //creating statement
        s = c.createStatement();


    }

//    public static void main(String[] args) throws Exception {
//        new Conn();
//    }
}
