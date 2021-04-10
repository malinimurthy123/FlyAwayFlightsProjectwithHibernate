package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.flightdetail;
import org.hibernate.Session;
import org.hibernate.Transaction;


@WebServlet("/flight-details")
public class FlightDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private FlightDAO FlightDAO;

    public void init(){
        FlightDAO= new FlightDAO();

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        int travellers=Integer.parseInt(request.getParameter("travellers"));
        String date=request.getParameter("date");
        flightdetail flight=new flightdetail(source,destination,travellers,date);

/*
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        // using HQL
        List<flightdetail> listFlight = session.createQuery("from flightdetail", flightdetail.class).getResultList();
        //session.save(flight);
        //tx.commit();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Flight Listing</b><br>");
        for (flightdetail flightdetail : listFlight) {
            System.out.println(flightdetail.getId());
            out.println("ID: " + String.valueOf(flightdetail.getId()) + ", source: " + flightdetail.getSource() +
                    ",Destination: " + String.valueOf(flightdetail.getDestination()) + ", flightdate: " + flightdetail.getDate() + "<br>");
        }
        out.println("<a href='index.jsp'>Return to homepage</a><br>");
        out.println("</body></html>");
        request.setAttribute("listFlight", listFlight);
        request.getRequestDispatcher("/flight-details.jsp").forward(request, response);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();
        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        int travellers=Integer.parseInt(request.getParameter("travellers"));
        String date=request.getParameter("date");
        flightdetail flight=new flightdetail(source,destination,travellers,date);


        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();


        // using HQL
        List<flightdetail> listFlight = session.createQuery("from flightdetail", flightdetail.class).getResultList();
        //session.save(flight);
        //tx.commit();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Flight Listing</b><br>");
        for (flightdetail flightdetail : listFlight) {
            System.out.println(flightdetail.getId());
            out.println("ID: " + String.valueOf(flightdetail.getId()) + ", source: " + flightdetail.getSource() +
                    ",Destination: " + String.valueOf(flightdetail.getDestination()) + ", flightdate: " + flightdetail.getDate() + "<br>");
        }
        out.println("<a href='index.jsp'>Return to homepage</a><br>");
        out.println("</body></html>");
        request.setAttribute("listFlight", listFlight);
        request.getRequestDispatcher("/flight-details.jsp").forward(request, response);

        try {
            listFlight(request, response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void listFlight(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List < flightdetail > listFlight = FlightDAO.getAllFlight();
        request.setAttribute("listFlight", listFlight);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);
    }
}
