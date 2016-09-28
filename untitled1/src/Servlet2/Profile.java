package Servlet2;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



/**
 * Created by Elvira on 27.09.2016.
 */

public class Profile extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        if(session.getAttribute("user")!=null){
            resp.setContentType("text/html");
            resp.getWriter().print("<html><head><meta charset='UTF-8'><title>Profile</title></head><body>" + "<center>"+
                    "<h1> Hi, " + req.getSession().getAttribute("user") + "<br><form method='get' action='/logout'>"  +
                    "<input type=\"submit\" value=\"Logout\"> \n" +
                    "</form>" + "</center>");
        }else {
            resp.sendRedirect("/login");
        }

    }

}