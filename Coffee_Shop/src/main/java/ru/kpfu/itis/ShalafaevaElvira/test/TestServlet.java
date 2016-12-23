package ru.kpfu.itis.ShalafaevaElvira.test;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ru.kpfu.itis.ShalafaevaElvira.servlets.RegisterServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
/**
 * Created by Elvira on 22.11.2016.
 */
public class TestServlet extends TestCase {
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

        when(request.getParameter("username")).thenReturn("testUsername");
        when(request.getParameter("email")).thenReturn("testEmail");
        when(request.getParameter("password1")).thenReturn("testPassword");
        when(request.getRequestDispatcher("/views/registration.html")).thenReturn(rd);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        when(response.getWriter()).thenReturn(pw);

        new RegisterServlet().doGet(request, response);

        verify(rd).forward(request, response);

        new RegisterServlet().doPost(request, response);

        String result = sw.getBuffer().toString().trim();

        System.out.println("Result: " + result);

        assertEquals("Register successfull...", result);

    }

}

