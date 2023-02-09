package com.javarush.dao;

import com.javarush.entity.Rental;
import com.javarush.entity.Staff;
import org.hibernate.SessionFactory;

public class StaffDao extends GenericDao<Staff> {
    public StaffDao(SessionFactory sessionFactory) {
        super(Staff.class, sessionFactory);
    }
}
