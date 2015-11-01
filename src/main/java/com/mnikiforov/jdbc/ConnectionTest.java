package com.mnikiforov.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            return;
        }

        try {
            {
                for (int i = 0; i < 100; i++) {
                    String username = "username_" + i;
                    String email = "email_" + i;
                    if (insertIntoUsers(conn, username, email)) {
                        System.out.format("insert user with username=%s, email=%s into USERS", username, email);
                    } else {
                        System.out.format("Failed to insert user with username=%s, email=%s into USERS", username, email);
                    }
                }
            }

            {
                System.out.println();
                System.out.println("--------------- Statement ---------------------");
                System.out.println("Table USERS:");
                try (Statement statement = conn.createStatement()) {
                    ResultSet rs = statement.executeQuery("select * from USERS");
                    while (rs.next()) {
                        System.out.println(getFullUserInfo(rs));
                    }
                }
            }

            {
                System.out.println();
                System.out.println("--------------- PreparedStatement ---------------------");
                System.out.println("Table USERS with username 'zigzzzag':");
                try (PreparedStatement ps = conn.prepareStatement("select  * from USERS where username = ?")) {
                    ps.setString(1, "zigzzzag");
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        System.out.println(getFullUserInfo(rs));
                    }
                }
            }
        } finally {
            conn.close();
        }
    }

    private static boolean insertIntoUsers(Connection conn, String username, String email) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Users(username, email) VALUES (?, ?)")) {
            ps.setString(1, username);
            ps.setString(2, email);
            int rowInserted = ps.executeUpdate();
            conn.commit();
            return rowInserted == 1;
        }
    }

    private static String getFullUserInfo(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String email = rs.getString("email");
        return "id=" + id + "; username=" + username + "; email=" + email;
    }
}
