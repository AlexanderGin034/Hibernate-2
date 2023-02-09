package com.javarush.dao;

import com.javarush.entity.Payment;
import com.javarush.entity.Rental;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class RentalDao extends GenericDao<Rental> {
    public RentalDao(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getAnyUnreturnedRental() {
        Query<Rental> query = getCurrentSession().createQuery("select r from Rental r where r.rentalDate is null", Rental.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
