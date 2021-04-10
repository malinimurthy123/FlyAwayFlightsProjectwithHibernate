package entity;

import com.flyaway.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.List;

@Embeddable
@Entity
@Table(name="flightdetail")

    public class flightdetail {
        @Id
        @Column(name="flight_id")
        private int id;

        @Column(name="source")
        private String source;

        @Column(name="destination")
        private String destination;

        @Column(name="no_of_travllers")
        private int travellers;

        @Column(name="date")
        private String date;

        public flightdetail() {
            super();
        }
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public int getTravellers() {
            return travellers;
        }

        public void setTravellers(int travellers) {
            this.travellers = travellers;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }


    public flightdetail(String source, String destination, int travellers, String date) {
        super();
        this.source = source;
        this.destination = destination;
        this.travellers = travellers;
        this.date = date;
    }


    }
