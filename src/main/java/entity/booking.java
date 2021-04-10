package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Embeddable;


@Embeddable
@Entity
@Table(name = "booking")

public class booking {

    public booking() {

    }

    @Column(name = "bookingconfirmation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int bookingconfirmation;

    @Column(name = "fname")
    String fname;


    @Column(name = "lname")
    String lname;


    @Column(name = "totalpassengers")
    String totalpassengers;

    @Column(name = "price")
    double price;

    public int getBookingconfirmation() {
        return bookingconfirmation;
    }

    public void setBookingconfirmation(int bookingconfirmation) {
        this.bookingconfirmation = bookingconfirmation;
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

    public void bookingconfirmation(String fname, String lname, String totalpassengers, double price) {
        //this.ProductID = ProductID;
        this.fname = fname;
        this.lname = lname;
        this.totalpassengers = totalpassengers;
        this.price = price;
    }

}

