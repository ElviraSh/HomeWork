package ru.kpfu.itis.ShalafaevaElvira.repositories;

import ru.kpfu.itis.ShalafaevaElvira.database.DBException;
import ru.kpfu.itis.ShalafaevaElvira.database.Products;
import ru.kpfu.itis.ShalafaevaElvira.objects.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Elvira on 12.11.2016.
 */
public class PSQLUserRep implements UserRepositories {
    @Override
    public Users add(Users obj) throws DBException {
        Connection conn = Products.getConnection();
        try {

            PreparedStatement st = conn.prepareStatement("INSERT INTO users (username, email, password) VALUES (?, ?, ?);");
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setString(3, obj.getPassword());
            st.execute();
            return this.get(obj.getEmail());

        } catch (SQLException ex) {
            throw new DBException("ERROR DATABASE!!!!!!!!!!!!: " + ex.getMessage());
        }
    }


    @Override
    public Users get(String email) throws DBException {

        Connection conn = Products.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement("select * from users where email=?;");
            st.setString(1, email);

            ResultSet result = st.executeQuery();
            Users user = null;
            while (result.next()) {
                user = new Users(result.getInt(Users.ATRIBUTE_ID),
                        result.getString(Users.ATRIBUTE_NAME),
                        result.getString(Users.ATRIBUTE_EMAIL),
                        result.getString(Users.ATRIBUTE_PASSWORD));
            }
            return user;


        } catch (SQLException ex) {
            Logger.getLogger(PSQLUserRep.class.getName()).log(Level.SEVERE, null, ex);
            throw new DBException("ERROR IN GET USER FROM DATABASE !!!!!");
        }
    }

    @Override
    public Users get(int id) throws DBException {

        Connection conn = Products.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement("select * from users where user_id=?;");
            st.setInt(1, id);
            ResultSet result = st.executeQuery();
            Users user = null;
            while (result.next()) {
                user = new Users(result.getInt(Users.ATRIBUTE_ID),
                        result.getString(Users.ATRIBUTE_NAME),
                        result.getString(Users.ATRIBUTE_EMAIL),
                        result.getString(Users.ATRIBUTE_PASSWORD));
            }
            return user;


        } catch (SQLException ex) {
            Logger.getLogger(PSQLUserRep.class.getName()).log(Level.SEVERE, null, ex);
            throw new DBException("ERROR IN GET USER FROM DATABASE !!!!!");
        }
    }
}