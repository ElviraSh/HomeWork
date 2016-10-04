package Servlet2;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Login extends HttpServlet{

    private Map passwords;

    @Override
    public void init(){
        passwords = new HashMap();
        passwords.put("Elvira", "1997");
        passwords.put("Maks_Frai", "1111");
        passwords.put("Bubuta", "9876");
        passwords.put("Exo", "9843");
        passwords.put("Night", "2400");
        passwords.put("Kofa", "5467");
        passwords.put("Happy", "1234");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Cookie[] cookies = req.getCookies();
        HttpSession session = req.getSession();


        if (cookies!=null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String pass = cookie.getValue();
                if (hasUser(name, pass)) {
                    session.setAttribute("user", name);
                }
            }
        }
        if (session.getAttribute("user") ==null){

           getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);

        }else{
            resp.sendRedirect("/profile");

        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user")!=null){
            response.sendRedirect("/profile");
        }else {
            String user = request.getParameter("user");
            String password = request.getParameter("pass");
            String remember = request.getParameter("remember");
            if(passwords.containsKey(user)){
                if(passwords.get(user).equals(password)){
                    if(remember!=null){
                        Cookie cookie = new Cookie(user,password);
                        cookie.setMaxAge(10*10*10);
                        response.addCookie(cookie);
                    }
                    session.setAttribute("user",user);
                    response.sendRedirect("/profile");
                } else {
                    response.sendRedirect("/login?error_msg=Password+invalid&password="+user);
                }
            } else {
                response.sendRedirect("/login?error_msg=Username+not+registered&username="+user);

            }
        }
    }

    private boolean hasUser(String username, String pass){
        return (passwords.containsKey(username)&&passwords.get(username).equals(pass));
    }
}

