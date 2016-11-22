package ru.kpfu.itis.ShalafaevaElvira.servlets.admin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


       /* String product_name = request.getParameter("product_name");

        String description = request.getParameter("description");

        String product_id = request.getParameter("product_id");

        String price = request.getParameter("price");
        String image = request.getParameter("image");


        if(product_id !=null*//* && product_name!=null && description!=null && image!=null && price!=null*//*){

            try {

                Class.forName("org.postgresql.Driver");
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "knigafanfikov2w8i123987");
            *//*Statement st = con.createStatement();*//*

                PreparedStatement st = con.prepareStatement("UPDATE products SET product_name=?, description=?, image=?, price=?  WHERE product_id=? ;");
                st.setString(1, product_name);
                st.setString(2, description);
                st.setString(3, image);
                st.setString(4, price);
                st.execute();

                response.sendRedirect("/productsForAdmin.jsp");

                return;


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        else {
            response.sendRedirect("/edit.jsp");

        }


*/
    }
}