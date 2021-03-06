package com.flyaway;

import entity.booking;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet("/bookingconfirmation")
public class bookingconfirmation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger("bookingconfirmation.class");
    public bookingconfirmation() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.sendRedirect("booking.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.getLogger("inside post method");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        //boolean status = false;
        try {

            //response.setContentType("text/html");
            Session session = HibernateUtil.getSessionFactory().openSession();
            Logger.getLogger("inside post method");
            int min = 1;
            int max = 200;
            double price = 1200.00;
            int randomValue = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println(randomValue);
            String bookingconfirmation = String.valueOf(randomValue);

            //String booking=request.getParameter("booking");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String totalpassengers = request.getParameter("totalpassengers");
            //double price = Double.parseDouble(request.getParameter("price"));
            System.out.println(randomValue);


            booking booking = new booking();
            //booking,fname,lname,totalpassengers,price
            //booking.setBookingconfirmation(booking);
            booking.setFname(fname);
            booking.setLname(lname);
            booking.setTotalpassengers(totalpassengers);
            booking.setPrice(price);
            Transaction tx = session.beginTransaction();
            session.save(booking);
            tx.commit();
            //theSession.close();
            Logger.getLogger("save");
            System.out.println("Object Saved");
            out.println("<p>booking confirmed..</p>");
            out.println("<html><body>");
            out.println("<b>Flight Booking Confirmed</b><br>");

            response.sendRedirect("bookingconfirmation.jsp");

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

