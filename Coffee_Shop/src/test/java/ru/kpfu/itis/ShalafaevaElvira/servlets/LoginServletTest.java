package ru.kpfu.itis.ShalafaevaElvira.servlets;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Elvira on 14.11.2016.
 */



class LoginServletTest extends TestCase {

    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;
    @Mock
    HttpSession session;

    @Mock
    RequestDispatcher rd;


    @Before
    protected void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test() throws Exception {


        when(request.getParameter("email")).thenReturn("admin@mail.ru");
        when(request.getParameter("password")).thenReturn("admin1");
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher("/productsForAdmin.jsp")).thenReturn(rd);


        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new LoginServlet().doPost(request, response);

        verify(session).setAttribute("email", "admin@mail.ru");

        verify(rd).forward(request, response);

        String result = sw.getBuffer().toString().trim();

        System.out.println("Result: "+result);

        assertEquals("Login successfull...", result);
    }
}