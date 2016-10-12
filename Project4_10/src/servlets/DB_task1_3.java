package servlets;

import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

/**
 * Created by Elvira on 12.10.2016.
 */
public class DB_task1_3 {
    private static final String url = "jdbc:postgresql://localhost:5432/CREATE";
    private static final String login = "postgres";
    private static final String password = "password123";
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) throws SQLException {
        String query = "UPDATE EMPLOYEES SET WAGE = WAGE + WAGE * 1.2 FROM " +
                "(SELECT NAMES, WAGE FROM EMPLOYEES) AS EMPLOYEES" +
                " WHERE NAMES FROM EMPLOYEES LIKE '%PETR'";
        ;
        Connection con = DriverManager.getConnection(url, login, password);
        System.out.println("Connected");
        try {
            con = DriverManager.getConnection(url, login, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }

}
