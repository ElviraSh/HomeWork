package ru.kpfu.itis.ShalafaevaElvira.repositories;

import ru.kpfu.itis.ShalafaevaElvira.database.Products;
import ru.kpfu.itis.ShalafaevaElvira.objects.Coffee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Elvira on 12.11.2016.
 */

public class CoffeeList implements CoffeeRepositories {

    private ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();

    private ArrayList<Coffee> getCoffee(String str) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = Products.getConnection();
            stmt = conn.createStatement();
            System.out.println(str);
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Coffee coffee = new Coffee();
                coffee.setId(rs.getLong("product_id"));
                coffee.setName(rs.getString("product_name"));
                coffee.setDescription(rs.getString("description"));
                coffee.setImage(rs.getString("image"));
                coffeeList.add(coffee);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CoffeeList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CoffeeList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(coffeeList);
        return coffeeList;
    }

    public ArrayList<Coffee> getCoffeeList() {
        if (!coffeeList.isEmpty()) {
            return coffeeList;
        } else {
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = null;
            try {
                conn = Products.getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from  products order by product_id desc limit 5 offset 0");
                while (rs.next()) {
                    Coffee coffee = new Coffee();
                    coffee.setName(rs.getString("product_name"));
                    coffee.setId(rs.getLong("product_id"));
                    coffee.setPrice(rs.getInt("price"));
                    coffee.setDescription(rs.getString("description"));
                    coffee.setImage(rs.getString("image"));
                    coffeeList.add(coffee);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                    if (rs != null) {
                        rs.close();
                    }
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            return coffeeList;
        }
    }

    public static List<Coffee> getRecords(int start, int total) {
        List<Coffee> coffeeList = new ArrayList<Coffee>();
        try {
            Connection con = Products.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from  products order by product_id desc limit " + total + "offset " + (start - 1));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Coffee coffee = new Coffee();
                coffee.setName(rs.getString("product_name"));
                coffee.setId(rs.getLong("product_id"));
                coffee.setPrice(rs.getInt("price"));
                coffee.setDescription(rs.getString("description"));
                coffee.setImage(rs.getString("image"));
                coffeeList.add(coffee);
            }

        } catch (Exception ex) {
        }
        return coffeeList;
    }


    @Override
    public boolean delete(Coffee coffee) {
        boolean result = false;
        try {
            Connection conn = Products.getConnection();
            PreparedStatement st = conn.prepareStatement("DELETE FROM products WHERE product_id=?;");
            st.setInt(1, (int) coffee.getId());
            result = st.execute();

        } catch (Exception ex) {
            Logger.getLogger(CoffeeList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    @Override
    public Coffee get(String name) {
        Connection conn = Products.getConnection();
        Coffee coffee = null;

        try{
            PreparedStatement st = conn.prepareStatement("select * from products where lower(NAME)=?");
            st.setString(1, name.toLowerCase());
            ResultSet result = st.executeQuery();
            while(result.next()){
                coffee = new Coffee(result.getString("product_name"),result.getLong("product_id"),result.getInt("price"),result.getString("description"), result.getString("image") );
                break;
            }
        } catch (Exception ex) {


        }
        return coffee;
    }
}