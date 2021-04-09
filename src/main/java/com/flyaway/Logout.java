package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;


@WebServlet("/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Session theSession;

    public Logout() {
        super();

    }

    protected void dSoGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("navigate.html").include(request, response);
        HttpSession session=request.getSession();
        session.removeAttribute("id");
        session.invalidate();
        Session ses= (Session) HibernateUtil.getSessionFactory();
        ses.flush();
        ses.clear();
        //ses.close();
        out.println("<br><h3>You are successfully logged out</h3>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
