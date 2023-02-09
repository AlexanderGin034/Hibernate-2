package com.javarush.dao;

import com.javarush.entity.Category;
import com.javarush.entity.City;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class CityDao extends GenericDao<City> {
    public CityDao(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

    public City getByName(String name) {
        Query<City> query = getCurrentSession().createQuery("select c from City c where c.city =:name", City.class);
        query.setParameter("name", name);
        query.setMaxResults(1);
        return query.uniqueResult();
    }
}
