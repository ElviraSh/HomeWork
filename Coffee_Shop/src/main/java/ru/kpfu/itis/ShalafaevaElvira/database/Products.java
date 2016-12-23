package ru.kpfu.itis.ShalafaevaElvira.database;

import java.sql.*;

/**
 * Created by Elvira on 10.11.2016.
 */
public class Products {
    private static final String url = "jdbc:postgresql://localhost:5432/postgres";
    private static final String login = "postgres";
    private static final String password =  "knigafanfikov2w8i123987";


    public static Connection getConnection() {
        try {
            DriverManager.registerDriver((Driver)
                    Class.forName("org.postgresql.Driver").newInstance());
            Connection con = DriverManager.getConnection(url, login, password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
