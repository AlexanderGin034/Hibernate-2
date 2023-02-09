package com.javarush.dao;

import com.javarush.entity.Language;
import com.javarush.entity.Payment;
import org.hibernate.SessionFactory;

public class PaymentDao extends GenericDao<Payment> {
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
