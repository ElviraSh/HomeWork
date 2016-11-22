package ru.kpfu.itis.ShalafaevaElvira.servlets;

/**
 * Created by Elvira on 19.10.2016.
 */

import ru.kpfu.itis.ShalafaevaElvira.utils.FormDataCheck;
import ru.kpfu.itis.ShalafaevaElvira.objects.Users;
import ru.kpfu.itis.ShalafaevaElvira.utils.Config;
import ru.kpfu.itis.ShalafaevaElvira.database.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegisterServlet extends HttpServlet {
    private Connection con;
    private PreparedStatement ps;

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration1.jsp").forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        String btn = req.getParameter("btn");
        String name = req.getParameter("username");
        String email = req.getParameter("email");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String message = "";








        if (btn != null) {
            message = FormDataCheck.checkAllFieldsAndGetErrorMessageIfFieldsAreInvalid(name, email, password1, password2);
            if (message == null) {
                boolean f;
                f = true;
                Users user;
                try {
                    user = Config.getUserRepository().get(email);
                    if (user != null) {
                        String userEmail = user.getEmail();
                        if (userEmail != null) {
                            if (userEmail.equals(email)) {
                                f = false;
                            }
                        }
                    }
                    if (f) {
                        Users newUser = new Users("-1", name, email,password1);
                        newUser = Config.getUserRepository().add(newUser);
                        req.setAttribute("message", "Registration completed successfully");
                        resp.sendRedirect("/login");
                    } else {
                        message = "This email has already registered";
                        req.setAttribute("message", message);
                        getServletContext().getRequestDispatcher("/registration1.jsp").forward(req, resp);
                        /*resp.sendRedirect("/registration1.jsp");*/
                    }
                } catch (DBException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                req.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/registration1.jsp").forward(req, resp);

            }
        } else {
            getServletContext().getRequestDispatcher("/registration1.jsp").forward(req, resp);
            /*resp.sendRedirect("/registration1.jsp");*/
        }
        PrintWriter out = resp.getWriter();
        out.write("Register successfull...");

    }
}