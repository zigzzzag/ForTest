package com.mnikiforov.jdbc;

import java.sql.*;
import java.util.Locale;

/**
 * Created by Zigzag on 01.11.2015.
 */
public class ConnectionTest {

    private static final String USERNAME = "ZIGZZZAG_TEST_1";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Locale.setDefault(Locale.ENGLISH);// oracle xe works only english locale

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", USERNAME, PASSWORD);

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("Table USERS:");
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from USERS");
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String email = rs.getString("email");
            System.out.println("id=" + id + "; username=" + username + "; email=" + email);
        }
    }
}
