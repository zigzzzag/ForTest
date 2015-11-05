package com.mnikiforov.jdbc.postgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

/**
 * Created by Zigzag on 05.11.2015.
 */
public class ConnectionPostgresTest {

    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/test", USERNAME, PASSWORD);

        if (conn != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
            return;
        }

        try {
            {
                System.out.println();
                System.out.println("--------------- Statement ---------------------");
                System.out.println("Table Persons:");
                try (Statement statement = conn.createStatement()) {
                    ResultSet rs = statement.executeQuery("select * from Persons");
                    while (rs.next()) {
                        System.out.println(getFullUserInfo(rs));
                    }
                }
            }

            {
                System.out.println();
                System.out.println("--------------- PreparedStatement ---------------------");
                System.out.println("Table USERS with lastname 'Ivanov':");
                try (PreparedStatement ps = conn.prepareStatement("select  * from Persons where lastname = ?")) {
                    ps.setString(1, "Ivanov");
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

    private static String getFullUserInfo(ResultSet rs) throws SQLException {
        int id = rs.getInt("personid");
        String username = rs.getString("lastname");
        String email = rs.getString("firstname");
        String address = rs.getString("address");
        String city = rs.getString("city");

        StringBuilder sb = new StringBuilder();

        sb.append("id=").append(id)
                .append("; username=").append(username)
                .append("; email=").append(email)
                .append("; address=").append(address)
                .append("; city=").append(city);

        return sb.toString();
    }
}
