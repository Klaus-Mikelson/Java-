package Hotel_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    Conn() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        c= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagement","root","pass123");
        s=c.createStatement();
//        System.out.println("Connection Successfully");
    }

public static void main(String[] args) throws SQLException, ClassNotFoundException {
        new Conn();

}
}

