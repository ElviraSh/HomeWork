package Servlet2;


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Elvira on 27.09.2016.
 */

public class Profile extends HttpServlet {
    private Configuration cfg;

    @Override
    public void init() throws ServletException {

        cfg=new Configuration(new Version("2.3.25"));
        cfg.setServletContextForTemplateLoading(getServletContext(),"WEB-INF/views");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();


        if(session.getAttribute("user")!=null){


            try {

                Template helloTemplate = cfg.getTemplate("profile.ftl");

                Map<String, Object> helloMap = new HashMap<String, Object>();
                helloMap.put("name", "user");
                helloTemplate.process(helloMap, resp.getWriter());



            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            resp.sendRedirect("/login");
        }

    }

}