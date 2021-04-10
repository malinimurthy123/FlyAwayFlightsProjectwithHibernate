package com.flyaway;

import entity.flightdetail;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FlightDAO {

    /**
     * Get all Flights
     * @return
     */
    @SuppressWarnings("unchecked")

    public List<flightdetail> getAllFlight() {



        Transaction transaction = null;
        List < flightdetail > listOfFlight = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object

            // using HQL
            listOfFlight = session.createQuery("from flightdetail", flightdetail.class).getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return listOfFlight;
    }
}
