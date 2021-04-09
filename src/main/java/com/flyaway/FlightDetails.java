package com.flyaway;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

    public FlightDetails() {
        super();

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        // TODO Auto-generated method stub

        String source=request.getParameter("source");
        String destination=request.getParameter("destination");
        int travellers=Integer.parseInt(request.getParameter("travellers"));
        String date=request.getParameter("date");
        flightdetail flight=new flightdetail(source,destination,travellers,date);
        Session session= HibernateUtil.getSessionFactory().openSession();
        Transaction tx=session.beginTransaction();

        // using HQL
        List<flightdetail> list = session.createQuery("from flightdetail", flightdetail.class).getResultList();
        //session.save(flight);
        //tx.commit();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<b>Flight Listing</b><br>");
        for (flightdetail flightdetail : list) {
            System.out.println(flightdetail.getId());
            out.println("ID: " + String.valueOf(flightdetail.getId()) + ", source: " + flightdetail.getSource() +
                    ",Destination: " + String.valueOf(flightdetail.getDestination()) + ", flightdate: " + flightdetail.getDate() + "<br>");
        }
        out.println("<a href='index.jsp'>Return to homepage</a><br>");
        out.println("</body></html>");

        request.getRequestDispatcher("/flight-details.jsp").forward(request, response);
    }

}
