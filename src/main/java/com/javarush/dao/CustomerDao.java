package com.javarush.dao;

import com.javarush.entity.Country;
import com.javarush.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDao extends GenericDao<Customer> {
    public CustomerDao(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
