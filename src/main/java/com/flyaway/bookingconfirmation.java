package com.flyaway;

import entity.booking;
import entity.userdetails;

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
import java.util.Random;
import java.util.logging.Logger;

@WebServlet("/passengerpayment")
public class bookingconfirmation extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static Logger logger = Logger.getLogger("bookingconfirmation.class");
    public bookingconfirmation() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.sendRedirect("PaymentConfirmation.html");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SessionFactory theFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(booking.class)
                .buildSessionFactory();

        Session theSession = theFactory.getCurrentSession();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        //boolean status = false;
        try {

            //response.setContentType("text/html");
            Session session = HibernateUtil.getSessionFactory().openSession();

            int min = 1;
            int max = 200;

            int randomValue = (int) Math.floor(Math.random() * (max - min + 1) + min);
            System.out.println(randomValue);
            String bookingconfirmation = String.valueOf(randomValue);

            //String bookingconfirmation=request.getParameter("bookingconfirmation");
            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String totalpassengers = request.getParameter("totalpassengers");
            double price = Double.parseDouble(request.getParameter("price"));
            System.out.println(randomValue);

            price = 1200.00;
            booking booking = new booking();
            //bookingconfirmation,fname,lname,totalpassengers,price
            booking.setBookingconfirmation(bookingconfirmation);
            booking.setFname(fname);
            booking.setLname(lname);
            booking.setTotalpassengers(totalpassengers);
            booking.setPrice(price);
            Transaction tx = session.beginTransaction();
            session.save(booking);
            tx.commit();
            //theSession.close();

            System.out.println("Object Saved");
            out.println("<p>booking confirmed..</p>");
            out.println("<html><body>");
            out.println("<b>Flight Booking Confirmed</b><br>");


            response.sendRedirect("PaymentConfirmation.html");

        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

