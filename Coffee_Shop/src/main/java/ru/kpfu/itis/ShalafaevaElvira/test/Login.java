package ru.kpfu.itis.ShalafaevaElvira.test;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Elvira on 14.11.2016.
 */

public class Login extends HttpServlet {
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 38044879686270933L;

    /**
     * Instantiates a new login.
     */
    public Login() {
        super();
    }

    /* (non-Javadoc)
    * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
    */
    public void init(ServletConfig config) throws ServletException// called once servlet loads
    {
        System.out.println("Login Init called...");
        try {
            super.init(config);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    /* (non-Javadoc)
    * @see javax.servlet.GenericServlet#destroy()
    */
    public void destroy()// called just before servlet unload
    {
        System.out.println("Login Destroyed...");
        super.destroy();
    }

    /* (non-Javadoc)
    * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
    */
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        System.out.println("Login doPost...");
        String email = req.getParameter("email");
        String pwd = req.getParameter("password");
        String rememberMe = req.getParameter("rememberMe");
        System.out.println("User: "+email+" | password: "+pwd);
        if(email.equals("abhinav@mail.ru") && pwd.equals("passw0rd")) {
            HttpSession session=req.getSession();
            session.setAttribute("email", email);
            Cookie ck1 = new Cookie("email", email);
            Cookie ck2 = new Cookie("pwd", pwd);
            res.addCookie(ck1);
            res.addCookie(ck2);
            if(rememberMe!=null && rememberMe!=""){
                Cookie ck3 = new Cookie("rememberMe", rememberMe);
                res.addCookie(ck3);
            }
        }
/*
        PrintWriter out= res.getWriter();*/
        System.out.write(Integer.parseInt("Login successfull..."));
//Dispatching request
        RequestDispatcher rd=req.getRequestDispatcher("/HelloWorld.do");
        rd.forward(req, res);
    }
}