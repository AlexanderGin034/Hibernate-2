package com.javarush.dao;

import com.javarush.entity.Customer;
import com.javarush.entity.Feature;
import org.hibernate.SessionFactory;

public class FeatureDao extends GenericDao<Feature> {
    public FeatureDao(SessionFactory sessionFactory) {
        super(Feature.class, sessionFactory);
    }
}
