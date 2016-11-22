package ru.kpfu.itis.ShalafaevaElvira.servlets.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Elvira on 12.11.2016.
 */
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String value = request.getParameter("product_id");

        if(value!=null){


        int v = Integer.parseInt(value);
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                    "postgres", "knigafanfikov2w8i123987");





            Statement st = conn.createStatement();

/*
            st = conn.prepareStatement("delete from comments where product=" + value);
            int i2 = st.executeUpdate();*/

            st.executeUpdate("DELETE FROM comments WHERE product='" + value + "'");


            st.executeUpdate("DELETE FROM products WHERE product_id='" + value + "'");

            /*response.sendRedirect("productsForAdmin.jsp");*/
            conn.close();
            response.sendRedirect("/productsForAdmin.jsp?page=1");
            return;

        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
        else {
            response.sendRedirect("/productsForAdmin.jsp?page=1");
        }
    }
}
