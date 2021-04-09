package com.flyaway;

import entity.airlines;
import entity.flightdetail;
import org.hibernate.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet("/getflightdetails")
public class GetFlightDetails extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GetFlightDetails() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("navigate.html").include(request, response);
        HttpSession s=request.getSession(false);
        String username=(String)s.getAttribute("uname");
        out.println("<h2 style=\"text-align: center;color: red;\"> Welcome ! "+ username +"</h2>");
        out.println("<br><br>");

        try {
            Session session= HibernateUtil.getSessionFactory().openSession();
            List<flightdetail> fdetails=session.createQuery("from flightdetail ").list();
            List<airlines> bdetails=session.createQuery("from airlines ").list();
            out.print("<h2 style='text-indent:25em';>   Booking Details </h2>");
            out.print("<style> table,td,th {"
                    + "border:2px solid gray;"
                    + "padding: 10px; "
                    + "}</style>");
            out.print("<style>th{background-color: #4287f5;\r\n" +
                    " color: white; }</style>");
            out.print("<style> table{ margin-left: auto;\r\n" + "  margin-right: auto;}</style>");
            out.print("<table>");
            out.print("<tr>");
            out.print("<th> Source </th>");
            out.print("<th> Destination </th>");
            out.print("<th> Travellers </th>");
            out.print("<th> Journey Date </th>");
            out.print("</tr>");
            for(flightdetail f:fdetails) {
                out.print("<tr>");
                out.print("<td>"+f.getSource()+"</td>");
                out.print("<td>"+f.getDestination()+"</td>");
                out.print("<td>"+f.getTravellers()+"</td>");
                out.print("<td>"+f.getDate()+"</td>");
                out.print("</tr>");
            }
            out.print("<tr>");
            out.print("<th> </th>");
            out.print("<th> Airline </th>");
            out.print("<th> Price </th>");
            out.print("<th> </th>");
            out.print("</tr>");

            int id= (int)request.getSession().getAttribute("id");
            for(airlines p:bdetails) {
                if(p.getId()==id) {
                    out.print("<tr>");
                    out.print("<td> </td>");
                    out.print("<td>"+p.getAirline()+"</td>");
                    out.print("<td>"+p.getPrice()+"</td>");
                    out.print("<td> </td>");
                    out.print("</tr>");
                }
            }
            out.print("</table>");
            //session.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        out.print("<br>");
        out.print("<input type=\"button\" onclick=\"document.location.href='Confirmation'\" value=\"Confirm Booking\" style=\"color:white; background-color: #4287f5;  width: 150px; margin-left:560px;\">");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
