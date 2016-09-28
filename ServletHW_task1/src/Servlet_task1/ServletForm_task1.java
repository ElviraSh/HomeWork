package Servlet_task1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Elvira on 26.09.2016.
 */
public class ServletForm_task1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        String option = req.getParameter("option");

        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println("<!DOCTYPE HTML>");
        if (option.equals("1")) {
          resp.getWriter().println("<html><body><p>" + "Количество символов: " + text.length() + "</p></body></html>");
           // resp.getWriter().println("<html><body><p>" + "Количество слов: " + text.split(" ").length + "</p></body></html>");

        } else {
           resp.getWriter().println("<html><body><p>" + "Количество слов: " + text.split(" ").length + "</p></body></html>");
           // resp.getWriter().println("<html><body><p>" + "Количество символов: " + text.length() + "</p></body></html>");

        }

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
