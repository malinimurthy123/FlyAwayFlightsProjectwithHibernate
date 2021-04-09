package com.flyaway;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.userdetails;

import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Registration() {
        super();

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.sendRedirect("registration.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name=request.getParameter("name");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        userdetails user=new userdetails(name,password,email);
        Session session= (Session) HibernateUtil.getSessionFactory();
        Transaction tx=session.beginTransaction();
        session.save(user);
        tx.commit();
        //theSession.close();
        response.sendRedirect("registrationSuccess.jsp");
    }

}
