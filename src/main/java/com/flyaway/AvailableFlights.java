package com.flyaway;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AvailableFlights")
public class AvailableFlights extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AvailableFlights() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("login.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String st=request.getParameter("airlines");
        int id=Integer.parseInt(st);
        HttpSession idValue=request.getSession(true);
        idValue.setAttribute("id",id);
        doGet(request,response);

    }

}
