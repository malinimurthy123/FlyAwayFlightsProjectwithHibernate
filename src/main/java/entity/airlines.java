package entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.*;
import javax.persistence.Embeddable;
import javax.persistence.*;


    @Embeddable
    @Entity
    @Table(name = "airlines")

    public class airlines {
        @Id
        private int id;

        @Column(name = "flights")
        private String airline;
        @Column(name = "price")
        private double price;

        public airlines() {
            super();

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAirline() {
            return airline;
        }

        public void setAirline(String airline) {
            this.airline = airline;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }


        public airlines(int id, String airline, double price) {
            super();
            this.id = id;
            this.airline = airline;
            this.price = price;
        }
    }

