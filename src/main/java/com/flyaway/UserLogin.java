package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.userdetails;
import org.hibernate.Session;


@WebServlet("/login")
public class UserLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String admin = "malini";
    private final String pass = "murthy";

    public UserLogin() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("navigate.html").include(request, response);
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        Session session = (Session) HibernateUtil.getSessionFactory();
        List<userdetails> list = session.createQuery("from userdetails ").list();

        if (username.equals(admin) && password.equals(pass)) {
            HttpSession s = request.getSession(true);
            s.setAttribute("uname", username);
            s.setAttribute("userId", UUID.randomUUID().toString());
            response.sendRedirect("adminsuccess.jsp");
        } else {
            boolean flag1 = false, flag2 = false;
            String name = "";
            for (userdetails user : list) {
                if (user.getName().equalsIgnoreCase(username)) {
                    if (user.getPassword().equals(password)) {
                        flag1 = true;
                        name = user.getName();
                        break;
                    }
                    flag2 = true;
                    break;
                }
            }
            if (flag1 == true) {
                HttpSession s = request.getSession(true);
                s.setAttribute("uname", name);
                s.setAttribute("userId", UUID.randomUUID().toString());
                s.setMaxInactiveInterval(2 * 60 * 60);
                response.sendRedirect("getflightdetails");
            } else if (flag2 == true) {
                out.println("<font color=blue><br><br><h1>User Password is wrong!</h1></font>");
                request.getRequestDispatcher("login.html").include(request, response);
            } else {

                out.println("<font color=red><br><br><h1>User does not exists!.. Register First..!<h1></font>");
                request.getRequestDispatcher("registration.html").include(request, response);
            }
        }
    }
}
