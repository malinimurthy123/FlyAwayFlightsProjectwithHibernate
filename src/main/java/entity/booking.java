package entity;

import javax.persistence.*;
import com.flyaway.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Embeddable
@Entity
@Table(name = "booking")

public class booking {

    @Id
    private String bookingconfirmation;
    private String fname;
    private String lname;
    private String totalpassengers;
    private double price;

    public booking() {
        super();
    }


    public void setBookingconfirmation(String bookingconfirmation) {
        this.bookingconfirmation = bookingconfirmation;
    }

    public String getBookingconfirmation() {
        return bookingconfirmation;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getTotalpassengers() {
        return totalpassengers;
    }

    public void setTotalpassengers(String totalpassengers) {
        this.totalpassengers = totalpassengers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public booking(String bookingconfirmation, String fname, String lname, String totalpassengers, double price) {
        this.bookingconfirmation = bookingconfirmation;
        this.fname = fname;
        this.lname = lname;
        this.totalpassengers = totalpassengers;
        this.price = price;
    }

}

